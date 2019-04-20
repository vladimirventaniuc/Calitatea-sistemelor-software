package com.faculty.qss.project.commands.Interfaces;

import java.util.List;

public interface Table {
    List<String> getTableSchemaForDbAndTable(String dbName, String tableName);
}
