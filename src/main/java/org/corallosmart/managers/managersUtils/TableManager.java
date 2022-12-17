package org.corallosmart.managers.managersUtils;

import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

public abstract class TableManager{
    protected final QueryRunner runner;
    public TableManager(DataSource dataSource) {
        this.runner = new QueryRunner(dataSource);
    }
}