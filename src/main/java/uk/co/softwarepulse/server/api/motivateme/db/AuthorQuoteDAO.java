package uk.co.softwarepulse.server.api.motivateme.db;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorQuoteDAO {

    public List<Quote> getAuthor(String author) throws Exception
    {
        List<Quote> listOfQuotes = new ArrayList<>() ;
        String id, category, quotation, query ;

public class AuthorQuoteDAO {

    public List<Quote> getAuthor(String authorName)
    {
        List<Quote> listOfQuotes = new ArrayList<>() ;
        String query = "SELECT * FROM motivate.quotations WHERE author="+authorName ;
        String id, category, quotation, author ;

        Connection connection ;
        Statement statement ;
        ResultSet resultSet ;

        DatabaseAccess da = new DatabaseAccess();
        Quote quote ;

        query = "SELECT * FROM motivate.quotations WHERE author LIKE '" + author + "%';" ;

        connection = da.createConnection();

        statement = connection.createStatement() ;

        resultSet = statement.executeQuery(query) ;


        if(!resultSet.next()) {
            listOfQuotes.add(new Quote("-", "-", "-", "<<< no quotes by " + author + " >>>")) ;
        }
        else {
            while (resultSet.next()) {
                id = resultSet.getString("id");
                author = resultSet.getString("author");
                category = resultSet.getString("category");
                quotation = resultSet.getString("quote");

                quote = new Quote(id, author, category, quotation);

                listOfQuotes.add(quote);
            }
        }

        return listOfQuotes ;
    }


    public List<String> getAuthors() throws Exception {
        List<String> listOfQuotes = new ArrayList<>() ;
        String author, query ;

        Connection connection ;
        Statement statement ;
        ResultSet resultSet ;

        DatabaseAccess da = new DatabaseAccess();

        query = "SELECT DISTINCT author FROM motivate.quotations ;" ;

        connection = da.createConnection() ;

        statement = connection.createStatement() ;

        resultSet = statement.executeQuery(query) ;

        while (resultSet.next()) {
            author = resultSet.getString("author");
            listOfQuotes.add(author);

        Quote quote ;
        DatabaseAccess da = new DatabaseAccess();
        try {
            connection = da.createConnection();

            statement = connection.createStatement() ;

            resultSet = statement.executeQuery(query) ;

            while(resultSet.next()) {
                id = resultSet.getString("id") ;
                author = resultSet.getString("author") ;
                category = resultSet.getString("category") ;
                quotation = resultSet.getString("quote") ;

                quote = new Quote(id, author, category, quotation) ;

                listOfQuotes.add(quote) ;
            }
        }
        catch (Exception e) {
            e.printStackTrace() ;
        }

        return listOfQuotes ;
    }
}
