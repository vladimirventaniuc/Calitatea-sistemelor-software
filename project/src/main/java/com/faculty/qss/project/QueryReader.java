package com.faculty.qss.project;

import com.faculty.qss.project.commands.Implementation.DatabaseImpl;
import com.faculty.qss.project.commands.Implementation.TableImpl;
import com.faculty.qss.project.commands.Database;
import com.faculty.qss.project.commands.TableWithoutLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryReader {
    private String database;

    public void readQuery() throws IOException {
        TableWithoutLibrary table = new TableWithoutLibrary();
        Database database = new Database();
        DatabaseImpl database2 = new DatabaseImpl();
        TableImpl table1 = new TableImpl();
        database2.createDatabase("adevarat");
        database2.createDatabase("adevarat2");
        database.deleteDatabase("adevarat2");

        String p = "C:\\Users\\vlad\\Desktop\\test\\";
        try {
            database2.getAllDabaseNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            database2.getAllTableNamesForDb("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
        table1.getTableSchemaForDbAndTable("test","testtable");
        while (true) {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();
            String[] splited = command.toLowerCase().split("\\s+");

            if (splited.length == 4 && splited[0].equals("create") && splited[1].equals("new") && splited[2].equals("database")) {
                database.createDatabase(splited[3]);
            }
            if (splited.length == 2 && splited[0].equals("show") && splited[1].equals("databases")) {
                database.showDatabases();
            }
            if (splited.length == 4 && splited[0].equals("show") && splited[1].equals("tables") && splited[2].equals("from")) {
                database.showTablesFromDatabase(splited[3]);
            }
            if (splited.length == 4 && splited[0].equals("change") && splited[1].equals("database") && splited[2].equals("to")) {
                database.changeDatabaseName(splited[3]);
            }
            if (splited.length == 3 && splited[0].equals("delete") && splited[1].equals("database")) {
                database.deleteDatabase(splited[2]);
            }
            if (database.getDatabaseName() != null) {
                if(splited.length>3 && splited[0].equals("download")&& splited[2].equals("as") && splited[4].equals("to")){
//                    table.downloadTable(database.getDatabaseName(),splited[1],splited[3],p);
                }
                if (splited.length > 2 && splited[0].equals("create") && splited[1].equals("table")) {
                    String[] queryDivider = command.toLowerCase().split("\\(");
                    String[] firstHalf = queryDivider[0].split(" ");
                    String tableName = firstHalf[firstHalf.length - 1].replace(" ", "");
                    HashMap<String, String> fields = new HashMap<>();
                    String[] fieldsAndTypes = queryDivider[1].split(",");
                    for (String str : fieldsAndTypes) {
                        String[] separator = str.replace(" ", "").replace(")", "").split(":");
                        fields.put(separator[0], separator[1]);
                    }
                    table.createTable(database.getDatabaseName(), tableName, fields);
                }
                if(splited.length>2 && splited[0].equals("insert") && splited[1].equals("into")){
                    String[] queryDivider = command.split("\\(");
                    String[] firstHalf = queryDivider[0].split(" ");
                    String tableName = firstHalf[firstHalf.length - 1].replace(" ", "");
                    ArrayList<String> values = (ArrayList<String>) Stream.of(queryDivider[1].split(","))
                            .map (elem -> elem.replace(" ","").replace(")",""))
                            .collect(Collectors.toList());
                    table.insertRecord(database.getDatabaseName(), tableName, values);
                }
                if(splited.length>4 && splited[0].equals("delete") && splited[1].equals("from") && splited[3].equals("where")){
                    String tableName = splited[2];
                    String whereClause = command.split("where")[1].replace(" ","");
                    table.deleteRecord(database.getDatabaseName(), tableName, whereClause);
                }
//                UPDATE table_name
//                SET column1 = value1, column2 = value2, ...
//                WHERE condition;
                if(splited.length>5 && splited[0].equals("update") && command.contains("set")&&command.contains("where")){
                    String tableName = splited[1];
                    String whereClause = command.split("where")[1].replace(" ","");
                    String fieldsToBeChanged = command.split("set")[1].split("where")[0].replace(" ","");
                    table.updateRecord(database.getDatabaseName(), tableName, fieldsToBeChanged, whereClause);
                }
            }

        }
    }

}
