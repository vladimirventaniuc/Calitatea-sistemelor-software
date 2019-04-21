package com.faculty.qss.project.comands.Implementation;

import com.faculty.qss.project.comands.Helpers.EntityConvertor;
import com.faculty.qss.project.comands.Helpers.Entry;
import com.faculty.qss.project.comands.Helpers.WhereClauseValidator;
import com.faculty.qss.project.comands.Interfaces.Table;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableImpl implements Table {
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "/src/main/resources/";
    private final String tableSuccessfullyCreated = "Table successfully created";
    private final String createTableError = "Could not create table";
    private final String tableAlreadyExists = "Table already exists";
    private final String tableSuccessfullyDeleted = "Table has been successfully deleted";
    private final String deleteTableError = "Could not delete table";
    private final String tableNotFound = "Table not found";
    private final String tableNameSuccessfullyChanged = "Table was successfully renamed";
    private final String changeTableNamenameIsAlreadyUsed = "File already exists";
    private final String changeTableNameError = "Table was not successfully renamed";
    private final String numberOfParametersIsNotEqual = "Incorrect number of arguments";
    private final String ENTRYES_SUCCESSFULLY_INSERTED = "Entryes successfully inserted";
    private final String DELETE_SUCCESFULLY = "[number] entryes deleted";
    private final String DELETE_ERROR = "Could not delete entryes";
    private final String SUCCESSFULLY_UPDATED = "[number] entryes modified";
    private final String INVALID_FIELD = "Field [field] does not exist in the database";
    private final String SUCCESSFULLY_DOWNLOADED = "Table was successfully downloaded";
    private final String UNSUPPORTED_FILE_FORMAT = "Unsupported file format : [format]";
    private final String SEPARATOR = " : ";
    private final String APOSTROPHE = "\"";

    @Override
    public List<String> getTableSchemaForDbAndTable(String dbName, String tableName) {
        List<String> result = new ArrayList<>();
        HashMap<String, String> fields = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(projectPath + dbName + "/" + tableName + ".xml"), "utf-8"));

            while (!reader.readLine().contains("Fields")) {
            }
            String fieldsTag = reader.readLine();
            String field;
            while (!(field = reader.readLine()).contains("/Fields")) {
                Pattern patternForValue = Pattern.compile(">(.+?)<", Pattern.DOTALL);
                Matcher matcherValue = patternForValue.matcher(field);
                matcherValue.find();
                Pattern patternForTag = Pattern.compile("<(.+?)>", Pattern.DOTALL);
                Matcher matcherTag = patternForTag.matcher(field);
                matcherTag.find();
                result.add(matcherTag.group(0).replace("<", "").replace(">", "")
                        + " = " + matcherValue.group(0).replace("<", "").replace(">", ""));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String createTable(String dbName, String newTableName, HashMap<String, String> columnAndType) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(projectPath + dbName + "/" + newTableName + ".xml"), "utf-8"))) {
            String spaces = "                         ";
            int nrOfSpaces = 0;
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            writer.newLine();
            writer.write("<TableInfo>");
            writer.newLine();
            nrOfSpaces += 4;
            writer.write(spaces.substring(0, nrOfSpaces) + "<Name> " + newTableName + " </Name>");
            writer.newLine();
            writer.write(spaces.substring(0, nrOfSpaces) + "<NumberOfFields> " + columnAndType.size() + " </NumberOfFields>");
            writer.newLine();
            writer.write(spaces.substring(0, nrOfSpaces) + "<Fields> ");
            nrOfSpaces += 4;
            writer.newLine();
            for (Map.Entry<String, String> entry : columnAndType.entrySet()) {
                writer.write(spaces.substring(0, nrOfSpaces) + "<" + entry.getKey() + "> " + entry.getValue() + " </" + entry.getKey() + ">");
                writer.newLine();
            }
            nrOfSpaces -= 4;
            writer.write(spaces.substring(0, nrOfSpaces) + "</Fields>");
            writer.newLine();
            writer.write(spaces.substring(0, nrOfSpaces) + "<Entryes>");
            writer.newLine();
            writer.write(spaces.substring(0, nrOfSpaces) + "</Entryes>");
            writer.newLine();
            writer.write("</TableInfo>");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return createTableError;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return tableNotFound;
        } catch (IOException e) {
            e.printStackTrace();
            return createTableError;
        }
        return tableSuccessfullyCreated;
    }

    @Override
    public String deleteTable(String dbName, String tableNameToDel) {
        File file = new File(projectPath + dbName + "/" + tableNameToDel + ".xml");

        if (file.delete()) {
            return tableSuccessfullyDeleted;
        } else {
            return deleteTableError;
        }
    }

    @Override
    public String changeTableName(String dbName, String oldTableName, String newTableName) {
        File file = new File(projectPath + dbName + "/" + oldTableName + ".xml");
        File file2 = new File(projectPath + dbName + "/" + newTableName + ".xml");

        if (file2.exists())
            return changeTableNamenameIsAlreadyUsed;
        boolean success = file.renameTo(file2);

        if (!success) {
            return changeTableNameError;
        }
        return tableNameSuccessfullyChanged;

    }

    @Override
    public String insertRecords(String dbName, String tableName, List<String> values) {
        HashMap<String, String> fields = new HashMap<>();
        int line = 0;
        int id = 1;
        int numberOfSpaces = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(projectPath + dbName + "/" + tableName + ".xml"), "utf-8"));

            while (!reader.readLine().contains("Fields")) {
                line++;
            }
            String fieldsTag = reader.readLine();
            line++;
            numberOfSpaces = fieldsTag.split("<")[0].length() + 4;
            String field;
            while (!(field = reader.readLine()).contains("/Fields")) {
                line++;
                String[] splited = field.split(">");
                String fieldName = splited[0].replace(" ", "").replace("<", "");
                String type = splited[1].split("<")[0].replace(" ", "");
                fields.put(fieldName, type);
            }
            line++;

            if (fields.size() != values.size())
                return numberOfParametersIsNotEqual;

            reader.readLine();
            line++;
            String currentEntry;
            String lastEntry = "";
            while (!(currentEntry = reader.readLine()).contains("Entryes")) {
                line++;
                if (currentEntry.contains("id")) {
                    lastEntry = currentEntry;
                }
            }
            line++;
            if (!lastEntry.equals("")) {
                id = Integer.parseInt(lastEntry.replaceAll("\\D+", "")) + 1;
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = Paths.get(projectPath + dbName + "/" + tableName + ".xml");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < numberOfSpaces; i++) {
                sb.append(" ");
            }
            lines.add(line, sb.toString() + "<Entry id=\"" + id + "\">");
            line++;
            int i = 0;
            for (Map.Entry<String, String> f : fields.entrySet()) {
                lines.add(line, sb.toString() + sb.toString().substring(0, 4) + "<" + f.getKey() + "> " + values.get(i) + " </" + f.getKey() + ">");
                line++;
                i++;
            }
            lines.add(line, sb.toString() + "</Entry>");
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ENTRYES_SUCCESSFULLY_INSERTED;
    }

    @Override
    public String deleteRecords(String dbName, String tableName, String whereClause) {
        WhereClauseValidator whereClauseValidator = new WhereClauseValidator();
        ArrayList<Entry> entryesToBeDeleted = whereClauseValidator.entryesToBeDeletedOrUpdated(projectPath, dbName, tableName, whereClause);
        Path path = Paths.get(projectPath + dbName + "/" + tableName + ".xml");

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            int deletedLines = 0;
            for (Entry entry : entryesToBeDeleted) {
                for (int i = 0; i < entry.size; i++) {
                    lines.remove(entry.line - deletedLines);
                }
                deletedLines += entry.size;
            }
            Files.write(path, lines, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return DELETE_ERROR;
        }

        return DELETE_SUCCESFULLY.replace("[number]", Integer.toString(entryesToBeDeleted.size()));
    }

    @Override
    public String updateRecords(String dbName, String tableName, String whereClause, HashMap<String, String> values) {
        WhereClauseValidator whereClauseValidator = new WhereClauseValidator();
        ArrayList<Entry> entryesToBeUpdated = whereClauseValidator.entryesToBeDeletedOrUpdated(projectPath, dbName, tableName, whereClause);
        ArrayList<Entry> newEntryes = null;
        try {
            newEntryes = EntityConvertor.updateEntryes(entryesToBeUpdated, values);
        } catch (Exception e) {
            return e.getMessage();
        }
        Path path = Paths.get(projectPath + dbName + "/" + tableName + ".xml");
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (int ind = 0; ind < entryesToBeUpdated.size(); ind++) {
                Entry entry = entryesToBeUpdated.get(ind);
                Entry newEntry = newEntryes.get(ind);
                for (int i = 1; i < entry.size - 1; i++) {
                    String lineContent = lines.get(entry.line + i);
                    String fieldName = lineContent.split(">")[0].replace(" ", "").replace("<", "");
                    lineContent = lineContent.replace(entry.fieldsAndValues.get(fieldName), newEntry.fieldsAndValues.get(fieldName));
                    lines.set(entry.line + i, lineContent);
                }
            }
            Files.write(path, lines, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return SUCCESSFULLY_UPDATED.replace("[number", Integer.toString(entryesToBeUpdated.size()));
    }

    @Override
    public List<String> selectRecords(String dbName, String tableName, String fieldsToBeDisplayed, String whereClause) {
        WhereClauseValidator whereClauseValidator = new WhereClauseValidator();
        ArrayList<Entry> entryesToBeUpdated = whereClauseValidator.entryesToBeDeletedOrUpdated(projectPath, dbName, tableName, whereClause);
        ArrayList<String> result = new ArrayList<>();
        fieldsToBeDisplayed = fieldsToBeDisplayed.replace(" ", "");
        if (fieldsToBeDisplayed.contains("*")) {
            for (Entry entry : entryesToBeUpdated) {
                StringBuilder ent = new StringBuilder();
                for (Map.Entry<String, String> values : entry.fieldsAndValues.entrySet()) {
                    ent.append("<<" + values.getKey() + " = " + values.getValue() + ">>");
                }
                result.add(ent.toString());
            }
        } else {
            for (Entry entry : entryesToBeUpdated) {
                StringBuilder ent = new StringBuilder();
                String[] fields = fieldsToBeDisplayed.toLowerCase().split(",");
                for (String field : fields) {
                    if (!entry.fieldsAndValues.containsKey(field)) {
//                        return INVALID_FIELD.replace("[field]", field);
                    } else {
                        ent.append("<<" + field + " = " + entry.fieldsAndValues.get(field) + ">>");
                    }
                }
                result.add(ent.toString());
            }
        }
        return result;
    }

    @Override
    public String downloadTable(String databaseName, String tableName, String fileFormat, String destinationPath) {
        if (fileFormat.toLowerCase().equals("xml")) {
            File source = new File(projectPath + databaseName + "/" + tableName + ".xml");
            File dest = new File(destinationPath + "/" + tableName + ".xml");
            try {
                Files.copy(source.toPath(), dest.toPath());
            } catch (IOException e) {
                e.printStackTrace();
                return tableNotFound;
            }
            return SUCCESSFULLY_DOWNLOADED;
        } else if (fileFormat.toLowerCase().equals("json")) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(projectPath + databaseName + "/" + tableName + ".xml"), "utf-8"));

}
