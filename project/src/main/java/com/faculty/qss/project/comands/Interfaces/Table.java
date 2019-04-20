package com.faculty.qss.project.comands.Interfaces;

import java.util.HashMap;
import java.util.List;

public interface Table {
    List<String> getTableSchemaForDbAndTable(String dbName, String tableName);

    String createTable(String dbName, String newTableName, HashMap<String, String> columnAndType);

    String deleteTable(String dbName, String tableNameToDel);

    String changeTableName(String dbName, String oldTableName, String newTableName);

    String insertRecords(String dbName, String tableName, List<String> values);

    String deleteRecords(String dbName, String tableName, String whereClause);

    String updateRecords(String dbName, String tableName, String whereClause, HashMap<String, String> values);

    List<String> selectRecords(String dbName, String tableName, String fieldsToBeDisplayed, String whereClause);

}
