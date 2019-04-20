package commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

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
        printFiles(projectPath);
    }

    public void showTablesFromDatabase(String databaseName) {
        printFiles(projectPath + databaseName);
    }

    private void printFiles(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("Table: " + listOfFiles[i].getName().replace(".xml", ""));
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Database " + listOfFiles[i].getName());
            }
        }
        System.out.println();
    }
}
