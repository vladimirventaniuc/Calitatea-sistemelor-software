package com.faculty.qss.project.unit;

import com.faculty.qss.project.comands.Implementation.DatabaseImpl;
import com.faculty.qss.project.comands.Implementation.TableImpl;
import com.faculty.qss.project.comands.Interfaces.Database;
import com.faculty.qss.project.comands.Interfaces.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TableTest {
    private Table table;
    private Database database;
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "/src/main/resources/";
    private final String tableSuccessfullyCreated = "Table successfully created";
    private final String createTableError = "Could not create table";
    private final String tableAlreadyExists = "Table already exists";
    private final String tableSuccessfullyDeleted = "Table has been successfully deleted";
    private final String deleteTableError = "Could not delete table";
    private final String tableNotFound = "Table not found";
    private final String tableNameSuccessfullyChanged = "Table was successfully renamed";
    private final String changeTableNamenameIsAlreadyUsed = "File already exists";
    private final String changeTableNameError = "Table was not successfully renamed";
    private final String numberOfParametersIsNotEqual = "Incorrect number of arguments";
    private final String ENTRYES_SUCCESSFULLY_INSERTED = "Entries successfully inserted";
    private final String DELETE_SUCCESFULLY = "[number] entries deleted";
    private final String DELETE_ERROR = "Could not delete entries";
    private final String SUCCESSFULLY_UPDATED = "[number] entries modified";
    private final String INVALID_FIELD = "Field [field] does not exist in the database";
    private final String SUCCESSFULLY_DOWNLOADED = "Table was successfully downloaded";
    private final String UNSUPPORTED_FILE_FORMAT = "Unsupported file format : [format]";
    private final String SUCCESSFULLY_ALTERED = "Table successfully altered";
    private final String DATABASE_NAME = "table_test_db";
    private final String INVALID_DATABASE_NAME = "table_test_db2";

    @Before
    public void _init() {
        this.table = new TableImpl();
        this.database = new DatabaseImpl();
        database.createDatabase(DATABASE_NAME);
    }

    @Test
    public void a0_createTableWithSuccess() {
        String tableName = "testtable";
        HashMap<String, String> columnAndType = new HashMap<>();
        columnAndType.put("firstName", "String");
        columnAndType.put("lastName", "String");
        columnAndType.put("age", "integer");
        String output = this.table.createTable(DATABASE_NAME, "testtable", columnAndType);
        assertEquals(this.tableSuccessfullyCreated, output);
        File tmpDir = new File(projectPath + DATABASE_NAME + "/" + tableName + ".xml");
        assertTrue(tmpDir.exists());
    }

    @Test
    public void a1_createTableInvalidPath() {
        String tableName = "testtable";
        HashMap<String, String> columnAndType = new HashMap<>();
        columnAndType.put("firstName", "String");
        columnAndType.put("lastName", "String");
        columnAndType.put("age", "integer");
        String output = this.table.createTable(INVALID_DATABASE_NAME, "testtable", columnAndType);
        assertEquals(this.tableNotFound, output);
        File tmpDir = new File(projectPath + INVALID_DATABASE_NAME + "/" + tableName + ".xml");
        assertFalse(tmpDir.exists());

    }

    @Test
    public void a2_getTableSchemaForDbAndTable() {
        String tableName = "testtable";
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("firstName = String");
        expectedOutput.add("lastName = String");
        expectedOutput.add("age = integer");
        List<String> actualOutput = this.table.getTableSchemaForDbAndTable(DATABASE_NAME, tableName);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void a3_getTableSchemaForDbAndInvalidTable() {
        String tableName = "testtable2";
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("firstName = String");
        expectedOutput.add("lastName = String");
        expectedOutput.add("age = integer");
        List<String> actualOutput = this.table.getTableSchemaForDbAndTable(DATABASE_NAME, tableName);
        assertEquals(0, actualOutput.size());
    }

    @Test
    public void a4_getTableSchemaForDbAndInvalidTable() {
        String tableName = "testtable2";
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("firstName = String");
        expectedOutput.add("lastName = String");
        expectedOutput.add("age = integer");
        List<String> actualOutput = this.table.getTableSchemaForDbAndTable(DATABASE_NAME, tableName);
        assertEquals(0, actualOutput.size());
    }

    @Test
    public void a4_deleteTableError() {
        String invalidTableName = "invalid_table_name";
        assertEquals(this.deleteTableError, this.table.deleteTable(DATABASE_NAME, invalidTableName));
    }

    @Test
    public void a5_deleteTable() {
        String tableName = "testtable";
        String output = this.table.deleteTable(DATABASE_NAME, tableName);
        assertEquals(this.tableSuccessfullyDeleted, output);
        File file = new File(projectPath + DATABASE_NAME + "/" + tableName + ".xml");
        assertFalse(file.exists());
    }


//    @After
//    public void destroy(){
//        database.deleteDatabase(DATABASE_NAME);
//    }
}
