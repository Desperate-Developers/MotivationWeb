package uk.co.softwarepulse.server.api.motivateme.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseAccess {

    public Connection createConnection() throws NamingException, SQLException {

        InitialContext initialContext = new InitialContext() ;

        DataSource dataSource = (DataSource) initialContext.lookup("jdbc/motivate") ;

        return dataSource.getConnection() ;
    }

}