package commands.Implementation;

import commands.Interfaces.Database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DatabaseImpl implements Database {
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "\\src\\resources\\";
    private final String databaseSuccessfullyCreated="Database successfully created";
    private final String databaseAlreadyExists="Database already exists";
    private final String databaseSuccessFullyDeleted = "Database has been successfully deleted";
    private final String dropDatabaseError = "Database not found";
    @Override
    public List<String> getAllDabaseNames() throws Exception {
        return getDatabasesOrTables(projectPath);
    }

    @Override
    public List<String> getAllTableNamesForDb(String dbName) throws Exception {
        return getDatabasesOrTables(projectPath + dbName);
    }

    @Override
    public String createDatabase(String newDbName) {
        if (!new File(projectPath + newDbName).exists()) {
            new File(projectPath + newDbName).mkdir();
            return databaseSuccessfullyCreated;
        }
        return databaseAlreadyExists;
    }

    @Override
    public String deleteDatabase(String dbNameToDel) {
        try {
            Files.walk(Paths.get(projectPath + dbNameToDel))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
            return databaseSuccessFullyDeleted;
        }
        return dropDatabaseError;
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
