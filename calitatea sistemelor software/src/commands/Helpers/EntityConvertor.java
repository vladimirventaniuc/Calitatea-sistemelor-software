package commands.Helpers;

import commands.TableWithoutLibrary;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityConvertor {
//    public static void updateRecord(String projectPath, String databaseName, String tableName, String fieldsToBeChanged, String whereClause) {
//        WhereClauseValidator whereClauseValidator = new WhereClauseValidator();
//        ArrayList<Entry> entryesToBeUpdated = whereClauseValidator.entryesToBeDeletedOrUpdated(databaseName, tableName, whereClause);
//        ArrayList<Entry> newEntryes = updateEntryes(entryesToBeUpdated, fieldsToBeChanged);
//        Path path = Paths.get(projectPath + databaseName + "/" + tableName + ".xml");
//        try {
//            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
//            for (int ind = 0; ind < entryesToBeUpdated.size(); ind++) {
//                Entry entry = entryesToBeUpdated.get(ind);
//                Entry newEntry = newEntryes.get(ind);
//                for (int i = 1; i < entry.size - 1; i++) {
//                    String lineContent = lines.get(entry.line + i);
//                    String fieldName = lineContent.split(">")[0].replace(" ", "").replace("<", "");
//                    lineContent = lineContent.replace(entry.fieldsAndValues.get(fieldName), newEntry.fieldsAndValues.get(fieldName));
//                    lines.set(entry.line + i, lineContent);
//                }
//            }
//            Files.write(path, lines, StandardCharsets.UTF_8);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return true;
//    }

    public static ArrayList<Entry> updateEntryes(ArrayList<Entry> entryesToBeUpdated, HashMap<String, String> fieldsToBeChanged) throws Exception {
        ArrayList<Entry> newEntryes = cloneEntryes(entryesToBeUpdated);
        for (Entry entry : newEntryes) {
            for (Map.Entry<String,String> fieldAndValue : fieldsToBeChanged.entrySet()) {
                String field = fieldAndValue.getKey();
                String value = fieldAndValue.getValue();
                if (entry.fieldsAndValues.containsKey(field)) {
                    entry.fieldsAndValues.put(field, value);
                } else {
                    throw new Exception("Invalid field "+field);
                    //TO DO -> Throw error, show message, etc.
                }
            }
        }
        return newEntryes;
    }

    private static ArrayList<Entry> cloneEntryes(ArrayList<Entry> entryes) {
        ArrayList<Entry> newEntryes = new ArrayList<>();
        for (Entry entry : entryes) {
            HashMap<String, String> fields = new HashMap<>();
            for (Map.Entry<String, String> ent : entry.fieldsAndValues.entrySet()) {
                fields.put(ent.getKey(), ent.getValue());
            }
            int line = entry.line;
            newEntryes.add(new Entry(fields, line));
        }
        return newEntryes;
    }
}
