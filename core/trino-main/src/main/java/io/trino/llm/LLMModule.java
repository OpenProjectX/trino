package io.trino.llm;

import com.google.inject.Binder;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import io.airlift.configuration.AbstractConfigurationAwareModule;

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

import static java.net.Proxy.Type.HTTP;
import static java.time.Duration.ofSeconds;

public class LLMModule
        extends AbstractConfigurationAwareModule {
    @Override
    protected void setup(Binder binder) {
        OpenAiChatModel.OpenAiChatModelBuilder builder = OpenAiChatModel.builder()
                .apiKey(System.getenv("openai_api_key"))
                .timeout(ofSeconds(60));

        String httpProxy = System.getenv("http_proxy");
        if (httpProxy != null) {
            try {
                URL url = new URL(httpProxy);
                builder.proxy(new Proxy(HTTP, new InetSocketAddress(url.getHost(), url.getPort())));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        ChatLanguageModel model = builder
                .build();

        binder.bind(LLMSqlClient.class).toInstance(AiServices.builder(LLMSqlClient.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(4096))
                .build());
        binder.bind(NL2SqlParser.class);
    }
}
