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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.matchers.JUnitMatchers.*;

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
    private String downloadPath = Paths.get("").toAbsolutePath().toString() + "/src/test/downloadFolder/";

    @Before
    public void _init() {
        this.table = new TableImpl();
        this.database = new DatabaseImpl();
        database.createDatabase(DATABASE_NAME);
        HashMap<String, String> columnAndType = new HashMap<>();
        columnAndType.put("firstName", "String");
        columnAndType.put("lastName", "String");
        columnAndType.put("age", "integer");
        table.createTable(DATABASE_NAME, TABLE_NAME, columnAndType);
//        new File(Paths.get("").toAbsolutePath().toString() + "/src/test/").mkdirs();
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
        for (int i = 0; i < expectedOutput.size(); i++)
            assertEquals(expectedOutput.get(i), actualOutput.get(i));
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
    public void a7_changeTableNameWithSuccess() {
        String currentTableName = "testtable";
        String newTableName = "testtable_v2";
        String output = this.table.changeTableName(DATABASE_NAME, currentTableName, newTableName);
        assertEquals(this.tableNameSuccessfullyChanged, output);
    }

    //    insertRecords(String dbName, String tableName, List<String> values);
    @Test
    public void a8_insertRecordsWrongNumberOfParameters() {
        List<String> valuesToBeInserted = new ArrayList<>();
        valuesToBeInserted.add("ana");
        valuesToBeInserted.add("craciun");
        String output = this.table.insertRecords(DATABASE_NAME, TABLE_NAME, valuesToBeInserted);
        assertEquals(this.numberOfParametersIsNotEqual, output);
    }

    @Test
    public void a9_insertRecords() {
        List<String> valuesToBeInserted = new ArrayList<>();
        valuesToBeInserted.add("ana");
        valuesToBeInserted.add("craciun");
        valuesToBeInserted.add("20");
        String output = this.table.insertRecords(DATABASE_NAME, TABLE_NAME, valuesToBeInserted);
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
        valuesToBeCompared.add(document.getElementsByTagName("firstName").item(1).getTextContent().replace(" ", ""));
        valuesToBeCompared.add(document.getElementsByTagName("lastName").item(1).getTextContent().replace(" ", ""));
        valuesToBeCompared.add(document.getElementsByTagName("age").item(1).getTextContent().replace(" ", ""));

        for (int i = 0; i < valuesToBeInserted.size(); i++) {
            assertEquals(valuesToBeInserted.get(i), valuesToBeCompared.get(i));
        }
    }
//    deleteRecords(String dbName, String tableName, String whereClause)

    @Test
    public void b1_deleteRecordsInvalidTable() {
        String whereClause = "id=1";
        String output = this.table.deleteRecords(DATABASE_NAME, "invalid_table", whereClause);
        assertEquals(this.DELETE_ERROR, output);
    }

    @Test
    public void b2_deleteRecords() {
        List<String> values = new ArrayList<>();
        values.add("ana");
        values.add("craciun");
        values.add("20");
        this.table.insertRecords(DATABASE_NAME, TABLE_NAME, values);
        String whereClause = "id=1";
        String output = this.table.deleteRecords(DATABASE_NAME, TABLE_NAME, whereClause);
        String expectedOutput = DELETE_SUCCESFULLY.replace("[number]", "1");

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

    //String updateRecords(String dbName, String tableName, String whereClause, HashMap<String, String> values);
    //SUCCESSFULLY_UPDATED.replace("[number]", Integer.toString(entryesToBeUpdated.size()))
    @Test
    public void b3_updateRecords() {
        List<String> values = new ArrayList<>();
        values.add("ana");
        values.add("craciun");
        values.add("20");
        this.table.insertRecords(DATABASE_NAME, TABLE_NAME, values);
        String whereClause = "id=1";
        String expectedOutput = SUCCESSFULLY_UPDATED.replace("[number]", Integer.toString(1));
        HashMap<String, String> valuesToUpdate = new HashMap<>();
        valuesToUpdate.put("firstName", "ana2");
        valuesToUpdate.put("lastName", "craciun2");
        valuesToUpdate.put("age", "40");
        String output = this.table.updateRecords(DATABASE_NAME, TABLE_NAME, whereClause, valuesToUpdate);
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

        assertEquals("ana2", document.getElementsByTagName("firstName").item(1).getTextContent().replace(" ", ""));
        assertEquals("craciun2", document.getElementsByTagName("lastName").item(1).getTextContent().replace(" ", ""));
        assertEquals("40", document.getElementsByTagName("age").item(1).getTextContent().replace(" ", ""));
    }

    @Test
    public void b4_updateRecordsInvalidField() {
        List<String> values = new ArrayList<>();
        values.add("ana");
        values.add("craciun");
        values.add("20");
        this.table.insertRecords(DATABASE_NAME, TABLE_NAME, values);
        String whereClause = "id=1";
        String expectedOutput = SUCCESSFULLY_UPDATED.replace("[number]", Integer.toString(1));
        HashMap<String, String> valuesToUpdate = new HashMap<>();
        valuesToUpdate.put("invalidField", "ana2");
        valuesToUpdate.put("lastName", "craciun2");
        valuesToUpdate.put("age", "40");
        String output = this.table.updateRecords(DATABASE_NAME, TABLE_NAME, whereClause, valuesToUpdate);
        assertEquals("Invalid field invalidField", output);
    }

    //    selectRecords(String dbName, String tableName, String fieldsToBeDisplayed, String whereClause)
    @Test
    public void b5_selectRecords() {
        List<String> keys = new ArrayList<>();
        keys.add("firstName");
        keys.add("lastName");
        keys.add("age");
        List<String> values1 = new ArrayList<>();
        values1.add("ana");
        values1.add("craciun");
        values1.add("20");
        List<String> values2 = new ArrayList<>();
        values2.add("ana");
        values2.add("craciun2");
        values2.add("202");
        this.table.insertRecords(DATABASE_NAME, TABLE_NAME, values1);
        this.table.insertRecords(DATABASE_NAME, TABLE_NAME, values2);
        String whereClause = "firstName=ana";
        List<String> output = this.table.selectRecords(DATABASE_NAME, TABLE_NAME, "firstName,lastName,age", whereClause);
        List<String> expectedOutput = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
//        ent.append("<<" + values.getKey() + " = " + values.getValue() + ">>");
        for (int i = 0; i < values1.size(); i++) {
            sb1.append("<<" + keys.get(i) + " = " + values1.get(i) + ">>");
            sb2.append("<<" + keys.get(i) + " = " + values2.get(i) + ">>");
        }
        expectedOutput.add(sb1.toString());
        expectedOutput.add(sb2.toString());
        assertEquals(expectedOutput.size(), output.size());
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertEquals(expectedOutput.get(i), output.get(i));
        }
    }

    //    String downloadTable(String databaseName, String tableName, String fileFormat, String destinationPath)
    @Test
    public void b6_downloadTableInvalidName() {
        String output = this.table.downloadTable(DATABASE_NAME, "Invalid_table", "xml", ".");
        assertEquals(tableNotFound, output);
    }

    @Test
    public void b7_downloadTableUnsupported() {
        String fileFormat = "csv";
        String output = this.table.downloadTable(DATABASE_NAME, TABLE_NAME, fileFormat, ".");
        assertEquals(UNSUPPORTED_FILE_FORMAT.replace("[format]", fileFormat), output);
    }

    @Test
    public void b8_downloadInvalidTable() {
        String fileFormat = "xml";
        String output = this.table.downloadTable(DATABASE_NAME, "invalid_table", fileFormat, ".");
        assertEquals(tableNotFound, output);
    }

    @Test
    public void b9_downloadTableAsXML() {
        String fileFormat = "xml";
        String output = this.table.downloadTable(DATABASE_NAME, TABLE_NAME, fileFormat, downloadPath);
        assertEquals(SUCCESSFULLY_DOWNLOADED, output);
        File createdFile = new File(downloadPath + "/" + TABLE_NAME + "." + fileFormat);
        assertTrue(createdFile.exists());
    }

    @Test
    public void c0_downloadTableAsJSON() {
        String fileFormat = "json";
        String output = this.table.downloadTable(DATABASE_NAME, TABLE_NAME, fileFormat, downloadPath);
        assertEquals(SUCCESSFULLY_DOWNLOADED, output);
        File createdFile = new File(downloadPath + "/" + TABLE_NAME + "." + fileFormat);
        assertTrue(createdFile.exists());
    }

    //    addNewColumns(String dbName, String tableName, HashMap<String, String> newColumns)
    @Test
    public void c1_addNewColumns() {
        HashMap<String, String> newColumns = new HashMap<>();
        newColumns.put("newCol1", "String");
        newColumns.put("newCol2", "String");
        List<String> expectedOutput = new ArrayList<>();
        for (Map.Entry<String, String> entry : newColumns.entrySet()) {
            expectedOutput.add(entry.getKey() + " = " + entry.getValue());
        }
        String output = this.table.addNewColumns(DATABASE_NAME, TABLE_NAME, newColumns);
        assertEquals(this.SUCCESSFULLY_ALTERED, output);
        Set<String> actualOutput = this.table.getTableSchemaForDbAndTable(DATABASE_NAME, TABLE_NAME).stream().collect(Collectors.toSet());
        for (String expected : expectedOutput) {
            assertTrue(actualOutput.contains(expected));
        }
    }

    //    deleteColumns(String dbName, String tableName, String columnToBeDeleted)
    @Test
    public void c2_deleteColumns() {
        String columns = "firstName";
        String output = this.table.deleteColumns(DATABASE_NAME, TABLE_NAME, columns);
        assertEquals(SUCCESSFULLY_ALTERED, output);
        List<String> tableSchema = this.table.getTableSchemaForDbAndTable(DATABASE_NAME, TABLE_NAME);

        Set<String> actualOutput = this.table.getTableSchemaForDbAndTable(DATABASE_NAME, TABLE_NAME).stream().collect(Collectors.toSet());
        for(String str : actualOutput){
            assertFalse(str.contains("firstName"));
        }

    }


//    @After
//    public void destroy(){
//        database.deleteDatabase(DATABASE_NAME);
//    }
}
