package uk.co.softwarepulse.server.api.motivateme.db;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class IdQuoteDAO {
    
    public List<Quote> getId(String id) throws SQLException {
        List<Quote> listOfQuotes = new ArrayList<>();
        String query = "SELECT * FROM motivate.quotations WHERE id=" + id;
        String category;
        String quotation;
        String author;

        DatabaseAccess dbAccess = new DatabaseAccess();
        ResultSet resultSet;
        Quote quote;

        try (Connection connection = dbAccess.createConnection(); Statement statement = connection.createStatement()) {

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                author = resultSet.getString("author");
                category = resultSet.getString("category");
                quotation = resultSet.getString("quote");
                
                quote = new Quote(id, author, category, quotation);

                listOfQuotes.add(quote);
            }
        } catch (Exception e) {
            throw new SQLException();
        }

    public Quote getId(String id) throws Exception {
        String category, quotation, author, query ;

        Connection connection ;
        Statement statement ;
        ResultSet resultSet ;

        DatabaseAccess da = new DatabaseAccess();
        Quote quote = new Quote() ;

        query = "SELECT * FROM motivate.quotations WHERE id = '" + id + "';";

        connection = da.createConnection();
        statement = connection.createStatement() ;
        resultSet = statement.executeQuery(query) ;

        while (resultSet.next()) {
            id = resultSet.getString("id") ;
            author = resultSet.getString("author") ;
            category = resultSet.getString("category") ;
            quotation = resultSet.getString("quote") ;

            quote = new Quote(id, author, category, quotation);
        }

        return quote ;
        return listOfQuotes;
    }
}
