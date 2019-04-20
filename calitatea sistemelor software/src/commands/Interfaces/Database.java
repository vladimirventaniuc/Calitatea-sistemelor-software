package commands.Interfaces;

import java.util.List;

public interface Database {
    public List<String> getAllDabaseNames() throws Exception;
    public List<String> getAllTableNamesForDb(String dbName) throws Exception;
}
