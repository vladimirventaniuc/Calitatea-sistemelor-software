package commands.Helpers;

import java.util.HashMap;

public class Entry {
    public HashMap<String, String> fieldsAndValues;
    public int line;
    public int size;
    public Entry(HashMap<String, String> map, int line){
        this.fieldsAndValues = map;
        this.line = line;
        this.size = map.size()+1;
    }
}
