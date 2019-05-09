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
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
    private final String TABLE_NAME = "table_for_insert";
    @Before
    public void _init() {
        this.table = new TableImpl();
        this.database = new DatabaseImpl();
        database.createDatabase(DATABASE_NAME);
        HashMap<String, String> columnAndType = new HashMap<>();
        columnAndType.put("firstName", "String");
        columnAndType.put("lastName", "String");
        columnAndType.put("age", "integer");
        table.createTable(DATABASE_NAME,TABLE_NAME,columnAndType);
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
    public void a4_getTableSchema() {
        String tableName = "testtable";
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("firstName = String");
        expectedOutput.add("lastName = String");
        expectedOutput.add("age = integer");
        List<String> actualOutput = this.table.getTableSchemaForDbAndTable(DATABASE_NAME, tableName);
        assertEquals(expectedOutput.size(), actualOutput.size());
        for(int i=0;i<expectedOutput.size();i++)
            assertEquals(expectedOutput.get(i),actualOutput.get(i));
    }

    @Test
    public void a5_deleteTableError() {
        String invalidTableName = "invalid_table_name";
        assertEquals(this.deleteTableError, this.table.deleteTable(DATABASE_NAME, invalidTableName));
    }

    @Test
    public void a6_deleteTable() {
        String tableName = "testtable";
        String output = this.table.deleteTable(DATABASE_NAME, tableName);
        assertEquals(this.tableSuccessfullyDeleted, output);
        File file = new File(projectPath + DATABASE_NAME + "/" + tableName + ".xml");
        assertFalse(file.exists());
    }
//    changeTableName(String dbName, String oldTableName, String newTableName)
    @Test
    public void a7_changeTableNameWithSuccess(){
        String currentTableName = "testtable";
        String newTableName = "testtable_v2";
        String output = this.table.changeTableName(DATABASE_NAME, currentTableName, newTableName);
        assertEquals(this.tableNameSuccessfullyChanged, output);
    }
//    insertRecords(String dbName, String tableName, List<String> values);
    @Test
    public void a8_insertRecordsWrongNumberOfParameters(){
        List<String> valuesToBeInserted = new ArrayList<>();
        valuesToBeInserted.add("ana");
        valuesToBeInserted.add("craciun");
        String output = this.table.insertRecords(DATABASE_NAME,TABLE_NAME, valuesToBeInserted);
        assertEquals(this.numberOfParametersIsNotEqual, output);
    }
    @Test
    public void a9_insertRecords(){
        List<String> valuesToBeInserted = new ArrayList<>();
        valuesToBeInserted.add("ana");
        valuesToBeInserted.add("craciun");
        valuesToBeInserted.add("20");
        String output = this.table.insertRecords(DATABASE_NAME,TABLE_NAME, valuesToBeInserted);
        assertEquals(this.ENTRYES_SUCCESSFULLY_INSERTED, output);
        File file = new File(projectPath + DATABASE_NAME + "/" + TABLE_NAME + ".xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = documentBuilder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List valuesToBeCompared = new ArrayList<>();
        valuesToBeCompared.add(document.getElementsByTagName("firstName").item(1).getTextContent().replace(" ",""));
        valuesToBeCompared.add(document.getElementsByTagName("lastName").item(1).getTextContent().replace(" ",""));
        valuesToBeCompared.add(document.getElementsByTagName("age").item(1).getTextContent().replace(" ",""));

        for(int i=0; i<valuesToBeInserted.size();i++){
            assertEquals(valuesToBeInserted.get(i), valuesToBeCompared.get(i));
        }
    }
//    deleteRecords(String dbName, String tableName, String whereClause)

    @Test
    public void b1_deleteRecordsInvalidTable(){
        String whereClause = "id=1";
        String output = this.table.deleteRecords(DATABASE_NAME,"invalid_table",whereClause);
        assertEquals(this.DELETE_ERROR, output);
    }

    @Test
    public void b2_deleteRecords(){
        List<String> values = new ArrayList<>();
        values.add("ana");
        values.add("craciun");
        values.add("20");
        this.table.insertRecords(DATABASE_NAME,TABLE_NAME,values);
        String whereClause = "id=1";
        String output = this.table.deleteRecords(DATABASE_NAME,TABLE_NAME,whereClause);
        String expectedOutput = DELETE_SUCCESFULLY.replace("[number]","1");

        assertEquals(expectedOutput, output);

        File file = new File(projectPath + DATABASE_NAME + "/" + TABLE_NAME + ".xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = documentBuilder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNull(document.getElementsByTagName("firstName").item(1));
        assertNull(document.getElementsByTagName("lastName").item(1));
        assertNull(document.getElementsByTagName("age").item(1));
    }


//    @After
//    public void destroy(){
//        database.deleteDatabase(DATABASE_NAME);
//    }
}
