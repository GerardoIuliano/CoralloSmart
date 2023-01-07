package org.corallosmart.managers;

import java.io.FileNotFoundException;
import java.sql.SQLException;

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