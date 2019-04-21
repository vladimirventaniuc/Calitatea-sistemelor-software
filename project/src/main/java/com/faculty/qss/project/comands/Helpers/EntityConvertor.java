package com.faculty.qss.project.comands.Helpers;

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

    public static ArrayList<Entry> updateEntryes(ArrayList<Entry> entryesToBeUpdated, HashMap<String, String> fieldsToBeChanged) throws Exception {
        ArrayList<Entry> newEntryes = cloneEntryes(entryesToBeUpdated);
        for (Entry entry : newEntryes) {
            for (Map.Entry<String, String> fieldAndValue : fieldsToBeChanged.entrySet()) {
                String field = fieldAndValue.getKey();
                String value = fieldAndValue.getValue();
                if (entry.fieldsAndValues.containsKey(field)) {
                    entry.fieldsAndValues.put(field, value);
                } else {
                    throw new Exception("Invalid field " + field);
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
