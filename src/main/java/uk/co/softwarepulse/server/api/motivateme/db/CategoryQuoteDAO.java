package uk.co.softwarepulse.server.api.motivateme.db;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoryQuoteDAO {

    public List<Quote> getCategory(String category) throws Exception {

        List<Quote> listOfQuotes = new ArrayList<>() ;
        String id, quotation, author, query ;

        Connection connection ;
        Statement statement ;
        ResultSet resultSet ;

        DatabaseAccess da = new DatabaseAccess();
        Quote quote;

        query = "SELECT * FROM motivate.quotations WHERE category LIKE '" + category + "%' ;";

        connection = da.createConnection();
        statement = connection.createStatement() ;
        resultSet = statement.executeQuery(query) ;

        if (!resultSet.next()) {
            listOfQuotes.add(new Quote("-", "-", "-", "<<< no quotes on " + category + " >>>")) ;
        }
        else {
            while(resultSet.next()) {
                id = resultSet.getString("id") ;
                author = resultSet.getString("author") ;
                category = resultSet.getString("category") ;
                quotation = resultSet.getString("quote") ;

                quote = new Quote(id, author, category, quotation) ;

                listOfQuotes.add(quote) ;
            }
        }

        return listOfQuotes ;
    }


    public List<String> getAllCategories() throws Exception {
        List<String> categories = new ArrayList<>() ;
        String category, query ;

        Connection connection ;
        Statement statement ;
        ResultSet resultSet ;

        DatabaseAccess da = new DatabaseAccess() ;

        query = "SELECT DISTINCT category FROM motivate.quotations ;" ;

        connection = da.createConnection();
        statement = connection.createStatement() ;
        resultSet = statement.executeQuery(query) ;

        while(resultSet.next()) {
            category = resultSet.getString("category");
            categories.add(category) ;
        }

        return categories ;
    }
}
