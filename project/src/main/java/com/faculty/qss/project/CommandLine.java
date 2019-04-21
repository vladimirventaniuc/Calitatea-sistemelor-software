package com.faculty.qss.project;

import com.faculty.qss.project.comands.Implementation.DatabaseImpl;
import com.faculty.qss.project.comands.Implementation.TableImpl;
import com.faculty.qss.project.comands.Interfaces.Database;
import com.faculty.qss.project.comands.Interfaces.Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLine extends Thread {
    private Table table;
    private Database database;
    private String currentDatabaseName;

    public void run() {
        this.table = new TableImpl();
        this.database = new DatabaseImpl();
        currentDatabaseName = null;
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String query = reader.readLine();
                readQuery(query.toLowerCase());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readQuery(String query) {
        /*
        List<String> selectRecords(String dbName, String tableName, String fieldsToBeDisplayed, String whereClause);
        String downloadTable(String databaseName, String tableName, String fileFormat, String destinationPath);
         */
        String splittedQuery[] = query.split(" ");
        if (splittedQuery.length == 2 && splittedQuery[0].equals("show") && splittedQuery[1].equals("databases")) {
            try {
                showTablesOrDatabases(database.getAllDabaseNames(), "database");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (splittedQuery.length == 4 && splittedQuery[0].equals("show") && splittedQuery[1].equals("tables") && splittedQuery[2].equals("from")) {
            try {
                showTablesOrDatabases(database.getAllTableNamesForDb(splittedQuery[3]), "table");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (splittedQuery.length == 3 && splittedQuery[0].equals("create") && splittedQuery[1].equals("database")) {
            System.out.println(database.createDatabase(splittedQuery[2]));
        } else if (splittedQuery.length == 3 && splittedQuery[0].equals("delete") && splittedQuery[1].equals("database")) {
            System.out.println(database.deleteDatabase(splittedQuery[2]));
        } else if (splittedQuery.length == 4 && splittedQuery[0].equals("change") && splittedQuery[1].equals("database") && splittedQuery[2].equals("to")) {
            if (database.checkIfDatabaseExists(splittedQuery[3])) {
                currentDatabaseName = splittedQuery[3];
                System.out.println("Database changed successfully");
            } else {
                System.out.println("Invalid database");
            }
        } else if (splittedQuery.length == 5 && splittedQuery[0].equals("get") && splittedQuery[1].equals("table") && splittedQuery[2].equals("schema") && splittedQuery[3].equals("for")) {
            showTablesOrDatabases(table.getTableSchemaForDbAndTable(currentDatabaseName, splittedQuery[4]), "schema");
        } else if (splittedQuery.length > 3 && splittedQuery[0].equals("create") && splittedQuery[1].equals("table") && query.contains("(")) {
            Pattern patternForValue = Pattern.compile("\\((.*?)\\)", Pattern.DOTALL);
            Matcher matcherValue = patternForValue.matcher(query);
            matcherValue.find();
            String tableName = splittedQuery[2].replace(" ", "");
            if (tableName.contains("("))
                tableName = tableName.split("\\(")[0];
            System.out.println(table.createTable(currentDatabaseName, tableName, createMapFromString(matcherValue.group(1), " ")));

        } else if (splittedQuery.length == 2 && splittedQuery[0].equals("drop")) {
            System.out.println(table.deleteTable(currentDatabaseName, splittedQuery[1]));
        } else if (splittedQuery.length > 4 && splittedQuery[0].equals("insert") && splittedQuery[1].equals("into") && query.contains("values")) {
            Pattern patternForValue = Pattern.compile("\\((.*?)\\)", Pattern.DOTALL);
            Matcher matcherValue = patternForValue.matcher(query);
            matcherValue.find();
            System.out.println(table.insertRecords(currentDatabaseName, splittedQuery[2], createListFromString(matcherValue.group(1))));
        } else if (splittedQuery.length > 4 && splittedQuery[0].equals("delete") && splittedQuery[1].equals("from") && splittedQuery[3].equals("where")) {
            String whereClause = query.split("where ")[1];
            System.out.println(table.deleteRecords(currentDatabaseName, splittedQuery[2], whereClause));
        } else if (splittedQuery.length > 5 && splittedQuery[0].equals("update") && splittedQuery[2].equals("set") && query.contains("where")) {
            String whereClause = query.split("where")[1].replace(" ", "");
            String values = query.split("set")[1].split("where")[0].replace(" ", "");
            System.out.println(table.updateRecords(currentDatabaseName, splittedQuery[1], whereClause, createMapFromString(values, "=")));
        } else if (splittedQuery.length > 3 && splittedQuery[0].equals("update") && splittedQuery[2].equals("set") && !query.contains("where")) {
            String values = query.split("set")[1].replace(" ", "");
            System.out.println(table.updateRecords(currentDatabaseName, splittedQuery[1], "", createMapFromString(values, "=")));
        } else if (splittedQuery.length > 3 && splittedQuery[0].equals("select") && query.contains("from") && query.contains("where")) {
            String tableName = query.split("from")[1].split("where")[0].replace(" ", "");
            String whereClause = query.split("where")[1].replace(" ", "");
            String fieldsToBeDisplayed = query.split("select")[1].split("from")[0].replace(" ", "");
            displayTable(table.selectRecords(currentDatabaseName, tableName, fieldsToBeDisplayed, whereClause));
        } else if (splittedQuery.length > 3 && splittedQuery[0].equals("select") && query.contains("from") && !query.contains("where")) {
            String tableName = query.split("from")[1].replace(" ", "");
            String whereClause = "";
            String fieldsToBeDisplayed = query.split("select")[1].split("from")[0].replace(" ", "");
            displayTable(table.selectRecords(currentDatabaseName, tableName, fieldsToBeDisplayed, whereClause));
        } else if (splittedQuery.length == 6 && splittedQuery[0].equals("download") && splittedQuery[2].equals("as") && splittedQuery[4].equals("to")) {
            System.out.println(table.downloadTable(currentDatabaseName, splittedQuery[1], splittedQuery[3], splittedQuery[5]));
        } else if (splittedQuery.length > 4 && splittedQuery[0].equals("alter") && splittedQuery[1].equals("table") && splittedQuery[3].equals("add")) {
            String newColums = query.split("add ")[1];
            System.out.println(table.addNewColumns(currentDatabaseName, splittedQuery[2], createMapFromString(newColums, " ")));
        } else if (splittedQuery.length == 6 && splittedQuery[0].equals("alter") && splittedQuery[1].equals("table") && splittedQuery[3].equals("drop") && splittedQuery[4].equals("column")) {
            System.out.println(table.deleteColumns(currentDatabaseName, splittedQuery[2], splittedQuery[5]));
        } else {
            System.out.println("Invalid command");
        }
    }

    public void showTablesOrDatabases(List<String> data, String type) {
        if (type.equals("database"))
            System.out.println("Database: ");
        else if (type.equals("table"))
            System.out.println("Table: ");
        else if (type.equals("schema"))
            System.out.println("Schema: ");
        for (String name : data) {
            System.out.println(" * " + name);
        }
        if (data.size() == 0)
            System.out.println("Nothing to show");
    }

    public HashMap<String, String> createMapFromString(String string, String splitBy) {
        HashMap<String, String> result = new HashMap<>();
        String[] splittedString = string.split(",");
        for (String keyValue : splittedString) {
            keyValue = keyValue.trim();
            String[] separator = keyValue.split(splitBy);
            result.put(separator[0], separator[1]);
        }
        return result;
    }

    public List<String> createListFromString(String string) {
        string = string.replace(" ", "");
        return Arrays.asList(string.split(","));
    }

    public void displayTable(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}
