package commands.Implementation;

import commands.Interfaces.Database;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database {
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "\\src\\resources\\";

    @Override
    public List<String> getAllDabaseNames() throws Exception {
        return getDatabasesOrTables(projectPath);
    }

    @Override
    public List<String> getAllTableNamesForDb(String dbName) throws Exception {
        return getDatabasesOrTables(projectPath + dbName);
    }

    private List<String> getDatabasesOrTables(String path) throws Exception {
        File folder = new File(path);
        List<String> result = new ArrayList<>();
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles == null)
            throw new Exception("Incorrect database or table");
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                result.add(listOfFiles[i].getName().replace(".xml", ""));
            } else if (listOfFiles[i].isDirectory()) {
                result.add(listOfFiles[i].getName());
            }
        }

        return result;
    }
}
