package io.trino.llm;

import io.trino.spi.connector.ColumnMetadata;

import java.util.List;
import java.util.Map;

public class TableMetadata {

    private String catalog;

    private  String schema;
    private  String table;
    private  String comment;
    private  List<ColumnMetadata> columns;
    private  Map<String, Object> properties;
    private  List<String> checkConstraints;

    public String getCatalog() {
        return catalog;
    }

    public TableMetadata setCatalog(String catalog) {
        this.catalog = catalog;
        return this;
    }

    public String getSchema() {
        return schema;
    }

    public TableMetadata setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public String getTable() {
        return table;
    }

    public TableMetadata setTable(String table) {
        this.table = table;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public TableMetadata setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public List<ColumnMetadata> getColumns() {
        return columns;
    }

    public TableMetadata setColumns(List<ColumnMetadata> columns) {
        this.columns = columns;
        return this;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public TableMetadata setProperties(Map<String, Object> properties) {
        this.properties = properties;
        return this;
    }

    public List<String> getCheckConstraints() {
        return checkConstraints;
    }

    public TableMetadata setCheckConstraints(List<String> checkConstraints) {
        this.checkConstraints = checkConstraints;
        return this;
    }

    @Override
    public String toString() {
        return "TableMetadata{" +
                "catalog='" + catalog + '\'' +
                ", schema='" + schema + '\'' +
                ", table='" + table + '\'' +
                ", comment='" + comment + '\'' +
                ", columns=" + columns +
                ", properties=" + properties +
                ", checkConstraints=" + checkConstraints +
                '}';
    }
}
