package commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Database {
    private String name;
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "\\src\\resources\\";

    public boolean createDatabase(String name) {
        if (!new File(projectPath + name).exists()) {
            new File(projectPath + name).mkdir();
            return true;
        }
        return false;
    }

    public String getDatabaseName() {
        return this.name;
    }

    public boolean changeDatabaseName(String name) {
        if (new File(projectPath + name).exists()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public boolean deleteDatabase(String name) {
        try {
            Files.walk(Paths.get(projectPath + name))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void showDatabases() {
        List<String> databases = getDatabasesOrTables(projectPath);
    }

    public void showTablesFromDatabase(String databaseName) {
       List<String> tables = getDatabasesOrTables(projectPath + databaseName);
    }

    private List<String> getDatabasesOrTables(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                result.add(listOfFiles[i].getName().replace(".xml", ""));
            } else if (listOfFiles[i].isDirectory()) {
                result.add(listOfFiles[i].getName());
            }
        }
        return result;
    }
    public List<String> getAllDabaseNames(){
        return getDatabasesOrTables(projectPath);
    }
    public List<String> getAllTableNamesForDb(String dbName){
        return getDatabasesOrTables(projectPath + dbName);
    }
}
