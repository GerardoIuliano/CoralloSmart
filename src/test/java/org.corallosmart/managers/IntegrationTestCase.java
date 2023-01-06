package org.corallosmart.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.corallosmart.utils.MockConnection;

public class IntegrationTestCase {

    protected static MockConnection mockDb = MockConnection.getInstance();

    /**
     * inizializza il database
     *
     * @throws SQLException
     * @throws FileNotFoundException
     */
    @BeforeAll
    public static void setup() throws SQLException, FileNotFoundException {
        mockDb.initeDb();
    }

    /**
     * cancella il database
     *
     * @throws SQLException
     */
    @AfterAll
    public static void tearDown() throws SQLException {
        mockDb.clearDb();
    }
}