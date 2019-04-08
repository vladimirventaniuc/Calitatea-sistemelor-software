package commands;

import org.w3c.dom.Element;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithoutLibrary {
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "\\src\\resources\\";

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
}


