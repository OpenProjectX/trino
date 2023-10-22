package io.trino.llm;

import io.airlift.log.Logger;
import io.trino.execution.QueryIdGenerator;
import jakarta.inject.Inject;

public class NL2SqlParser {
    private static final Logger log = Logger.get(NL2SqlParser.class);

    private static final QueryIdGenerator queryIdGenerator = new QueryIdGenerator();

    private final LLMSqlClient llmSqlClient;

    @Inject
    public NL2SqlParser(LLMSqlClient llmSqlClient) {
        this.llmSqlClient = llmSqlClient;
    }


    public String translateToSql(String question) {
        String sql = llmSqlClient.testToSql(question);
        log.info("sql result from llm %s", sql);
        return sql;
    }
}
