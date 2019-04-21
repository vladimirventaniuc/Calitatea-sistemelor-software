package commands.Helpers;

import commands.TableWithoutLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class WhereClauseValidator {
    public ArrayList<Entry> entryesToBeDeletedOrUpdated(String projectPath,String databaseName, String tableName, String whereClause){
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

    private boolean checkEntityAgainsConditions(HashMap<String, String> entity,ArrayList<ArrayList<Condition>> conditions ){
        for(ArrayList<Condition> andCondition : conditions){
            if(andCondition.size()==1){
                if(entity.get(andCondition.get(0).field).equals(andCondition.get(0).value.replace(" ","")) != andCondition.get(0).equal)
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
                    elements.add(resolveCondition(orCondition.replace(" ","")));
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
}
