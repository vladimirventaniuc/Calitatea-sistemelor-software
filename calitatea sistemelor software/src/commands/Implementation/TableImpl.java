package commands.Implementation;

import commands.Interfaces.Table;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableImpl implements Table {
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "\\src\\resources\\";

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
                result.add(matcherTag.group(0).replace("<","").replace(">","")
                        +" = "+matcherValue.group(0).replace("<","").replace(">",""));
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
}
