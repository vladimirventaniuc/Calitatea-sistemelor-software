package com.faculty.qss.project.unit;

import com.faculty.qss.project.comands.Implementation.DatabaseImpl;
import com.faculty.qss.project.comands.Implementation.TableImpl;
import com.faculty.qss.project.comands.Interfaces.Database;
import com.faculty.qss.project.comands.Interfaces.Table;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DatabaseTest {
    private Table table;
    private Database database;
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "/src/main/resources/";
    private final String databaseSuccessfullyCreated = "Database successfully created";
    private final String databaseAlreadyExists = "Database already exists";
    private final String databaseSuccessFullyDeleted = "Database has been successfully deleted";
    private final String dropDatabaseError = "Database not found";

    @Before
    public void init() {
        this.table = new TableImpl();
        this.database = new DatabaseImpl();
    }

    @Test
    public void a_createDatabaseWithSuccess() {
        String databaseName = "testdb";
        assertEquals(this.databaseSuccessfullyCreated, this.database.createDatabase(databaseName));
    }

    @Test
    public void b_getAllDabaseNames() {
        String databaseName = "testdb";
        try {
            List<String> databases = this.database.getAllDabaseNames();
            assertThat(databases, hasItem(databaseName));
        } catch (Exception e) {
            String message = "Incorrect database or table";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void c_getAllTableNamesForDbInvaliDatabaseName() {
        String databaseName = "testdb2";
        try {
            this.database.getAllTableNamesForDb(this.projectPath + databaseName);
        } catch (Exception e) {
            String message = "Incorrect database or table";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void d_getAllTableNamesForDbValiDatabaseName() {
        String databaseName = "testdb";
        try {
            List<String> tables = this.database.getAllTableNamesForDb(this.projectPath + databaseName);
            assertEquals(0, tables.size());
        } catch (Exception e) {
            String message = "Incorrect database or table";
            assertEquals(message, e.getMessage());
        }
    }


    @Test
    public void e_errorOnDatabaseCreation() {
        String databaseName = "testdb";
        assertEquals(this.databaseAlreadyExists, this.database.createDatabase(databaseName));
    }

    @Test
    public void f_checkIfDatabaseExistsValidDatabase() {
        String databaseName = "testdb";
        assertTrue(this.database.checkIfDatabaseExists(databaseName));
    }

    @Test
    public void g_checkIfDatabaseExistsInvalidDatabase() {
        String databaseName = "testdb2";
        assertFalse(this.database.checkIfDatabaseExists(databaseName));

    }

    @Test
    public void h_errorOnDatabaseDeletion() {
        String databaseName = "testdb2";
        assertEquals(this.dropDatabaseError, this.database.deleteDatabase(databaseName));
    }

    @Test
    public void i_successOnDatabaseDeletion() {
        String databaseName = "testdb";
        assertEquals(this.databaseSuccessFullyDeleted, this.database.deleteDatabase(databaseName));
    }
}
