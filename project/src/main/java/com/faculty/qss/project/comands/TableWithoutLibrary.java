package com.faculty.qss.project.comands;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithoutLibrary {
    class Condition {
        String field;
        String value;
        boolean equal;
        public void setValues(String field, String value, boolean equal) {
            this.field = field;
            this.value = value;
            this.equal = equal;
        }
    }
    class Entry{
        HashMap<String, String> fieldsAndValues;
        int line;
        int size;
        public Entry(HashMap<String, String> map, int line){
            this.fieldsAndValues = map;
            this.line = line;
            this.size = map.size()+1;
        }
    }

    private String projectPath = Paths.get("").toAbsolutePath().toString() + "\\src\\main\\resources\\";

    public boolean createTable(String databaseName, String tableName, HashMap<String, String> fields) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(projectPath + databaseName + "/" + tableName + ".xml"), "utf-8"))) {
            String spaces = "                         ";
            int nrOfSpaces = 0;
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            writer.newLine();
            writer.write("<TableInfo>");
            writer.newLine();
            nrOfSpaces += 4;
            writer.write(spaces.substring(0, nrOfSpaces) + "<Name> " + tableName + " </Name>");
            writer.newLine();
            writer.write(spaces.substring(0, nrOfSpaces) + "<NumberOfFields> " + fields.size() + " </NumberOfFields>");
            writer.newLine();
            writer.write(spaces.substring(0, nrOfSpaces) + "<Fields> ");
            nrOfSpaces += 4;
            writer.newLine();
            for (Map.Entry<String, String> entry : fields.entrySet()) {
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
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertRecord(String databaseName, String tableName, ArrayList<String> entry) {
        HashMap<String, String> fields = new HashMap<>();
        int line = 0;
        int id = 1;
        int numberOfSpaces = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(projectPath + databaseName + "/" + tableName + ".xml"), "utf-8"));

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

            if (fields.size() != entry.size())
                return false;

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
            System.out.println(id);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = Paths.get(projectPath + databaseName + "/" + tableName + ".xml");
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
                lines.add(line, sb.toString() + sb.toString().substring(0, 4) + "<" + f.getKey() + "> " + entry.get(i) + " </" + f.getKey() + ">");
                line++;
                i++;
            }
            lines.add(line, sb.toString() + "</Entry>");
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean deleteRecord(String databaseName, String tableName, String whereClause) {
        ArrayList<Entry> entryesToBeDeleted = entryesToBeDeletedOrUpdated(databaseName, tableName, whereClause);
        Path path = Paths.get(projectPath + databaseName + "/" + tableName + ".xml");

        try {
            List<String> lines  = Files.readAllLines(path, StandardCharsets.UTF_8);
            int deletedLines=0;
            for(Entry entry : entryesToBeDeleted){
                for(int i=0; i<entry.size;i++){
                    lines.remove(entry.line-deletedLines);
                }
                deletedLines+=entry.size;
            }
            Files.write(path, lines, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
    public boolean updateRecord(String databaseName, String tableName,String fieldsToBeChanged, String whereClause){
        ArrayList<Entry> entryesToBeUpdated = entryesToBeDeletedOrUpdated(databaseName, tableName, whereClause);
        ArrayList<Entry> newEntryes = updateEntryes(entryesToBeUpdated, fieldsToBeChanged);
        Path path = Paths.get(projectPath + databaseName + "/" + tableName + ".xml");
        try {
            List<String> lines  = Files.readAllLines(path, StandardCharsets.UTF_8);
            for(int ind=0; ind<entryesToBeUpdated.size();ind++){
                Entry entry = entryesToBeUpdated.get(ind);
                Entry newEntry = newEntryes.get(ind);
                for(int i=1; i<entry.size-1;i++){
                    String lineContent = lines.get(entry.line+i);
                    String fieldName = lineContent.split(">")[0].replace(" ","").replace("<","");
                    lineContent = lineContent.replace(entry.fieldsAndValues.get(fieldName),newEntry.fieldsAndValues.get(fieldName));
                    lines.set(entry.line+i, lineContent);
                }
            }
            Files.write(path, lines, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
    public ArrayList<Entry>  updateEntryes(ArrayList<Entry> entryesToBeUpdated, String fieldsToBeChanged){
        ArrayList<Entry> newEntryes = cloneEntryes(entryesToBeUpdated);
        String[] fieldsWithValues = fieldsToBeChanged.split(",");
        for(Entry entry : newEntryes) {
            for (String fieldAndValue : fieldsWithValues) {
                String[] splitByEqual = fieldAndValue.split("=");
                String field = splitByEqual[0];
                String value = splitByEqual[1];
                if(entry.fieldsAndValues.containsKey(field)){
                    entry.fieldsAndValues.put(field, value);
                }else{
                    //TO DO -> Throw error, show message, etc.
                }
            }
        }
        return newEntryes;
    }
    private ArrayList<Entry> cloneEntryes(ArrayList<Entry> entryes){
        ArrayList<Entry> newEntryes = new ArrayList<>();
        for(Entry entry : entryes){
            HashMap<String, String> fields = new HashMap<>();
            for(Map.Entry<String, String> ent : entry.fieldsAndValues.entrySet()){
                fields.put(ent.getKey(), ent.getValue());
            }
            int line = entry.line;
            newEntryes.add(new Entry(fields, line));
        }
        return newEntryes;
    }
    public ArrayList<ArrayList<Condition>> resolveConditions(String whereClause) {
        ArrayList<ArrayList<Condition>> conditions = new ArrayList<>();
        String[] andConditions = whereClause.split("and");
        for (String andCondition : andConditions) {
            if (!andCondition.contains("or")) {
                ArrayList<Condition> element = new ArrayList<>();
                element.add(resolveCondition(andCondition));
                conditions.add(element);
            } else {
                String[] orConditions = andCondition.split("or");
                ArrayList<Condition> elements = new ArrayList<>();
                for (String orCondition : orConditions) {
                    elements.add(resolveCondition(orCondition));
                }
                conditions.add(elements);
            }
        }
        return conditions;
    }

    private Condition resolveCondition(String condition) {
        Condition cond = new Condition();
        if (condition.contains("!=")) {
            String[] splited = condition.split("!=");
            cond.setValues(splited[0], splited[1], false);
        } else if (condition.contains("=")) {
            String[] splited = condition.split("=");
            cond.setValues(splited[0], splited[1], true);
        }
        return cond;
    }
    private boolean checkEntityAgainsConditions(HashMap<String, String> entity,ArrayList<ArrayList<Condition>> conditions ){
        for(ArrayList<Condition> andCondition : conditions){
            if(andCondition.size()==1){
                if(entity.get(andCondition.get(0).field).equals(andCondition.get(0).value) != andCondition.get(0).equal)
                    return false;
            }
            else{
                boolean atLeastOneConditionIsTrue = false;
                for(Condition condition : andCondition){
                    if(entity.get(condition.field).equals(condition.value) == condition.equal) {
                        atLeastOneConditionIsTrue = true;
                        break;
                    }
                }
                if(!atLeastOneConditionIsTrue)
                    return false;
            }
        }
        return true;
    }
    private ArrayList<Entry> entryesToBeDeletedOrUpdated(String databaseName, String tableName, String whereClause){
        int line = 0;
        ArrayList<ArrayList<Condition>> conditions = resolveConditions(whereClause);
        ArrayList<Entry> entryesToBeDeletedOrUpdated = new ArrayList<>();
        HashMap<String, String> fields = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(projectPath + databaseName + "/" + tableName + ".xml"), "utf-8"));

            while (!reader.readLine().contains("Fields")) {
                line++;
            }
            reader.readLine();
            line++;
            String field;
            while (!(field = reader.readLine()).contains("/Fields")) {
                line++;
                String[] splited = field.split(">");
                String fieldName = splited[0].replace(" ", "").replace("<", "");
                String type = splited[1].split("<")[0].replace(" ", "");
                fields.put(fieldName, type);
            }
            // insert verification of fields
            line++;
            reader.readLine();
            line++;
            String currentEntry;
            String lastEntry = "";
            while (!(currentEntry = reader.readLine()).contains("Entryes")) {
                line++;
                if (currentEntry.contains("id")) {
                    int firstLine = line;
                    HashMap<String, String> fieldsAndValues = new HashMap<>();
                    String id = currentEntry.replaceAll("\\D+", "");
                    fieldsAndValues.put("id", id);
                    int remainingLinesFromEntity = fields.size();
                    while(remainingLinesFromEntity!=0){
                        remainingLinesFromEntity--;
                        currentEntry = reader.readLine();
                        line++;
                        String[] splited = currentEntry.split(">");
                        String fieldName = splited[0].replace(" ", "").replace("<", "");
                        String value = splited[1].split("<")[0].replace(" ", "");
                        fieldsAndValues.put(fieldName, value);
                    }
                    if(checkEntityAgainsConditions(fieldsAndValues,conditions)){
                        Entry entry = new Entry(fieldsAndValues, firstLine);
                        entryesToBeDeletedOrUpdated.add(entry);
                    }
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entryesToBeDeletedOrUpdated;
    }
}


