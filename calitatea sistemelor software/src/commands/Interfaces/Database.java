package commands.Interfaces;

import java.util.List;

public interface Database {
    List<String> getAllDabaseNames() throws Exception;
    List<String> getAllTableNamesForDb(String dbName) throws Exception;
    String createDatabase(String newDbName);
    String deleteDatabase(String dbNameToDel);

}
