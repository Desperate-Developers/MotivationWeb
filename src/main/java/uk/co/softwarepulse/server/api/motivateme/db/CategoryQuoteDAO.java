package uk.co.softwarepulse.server.api.motivateme.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;

public class CategoryQuoteDAO {

    public List<Quote> getCategory(String category)
    {
        List<Quote> listOfQuotes = new ArrayList<>() ;
        String query = "SELECT * FROM motivate.quotations WHERE category=" + category;
        String id, cat, quotation, author ;

        Connection connection ;
        Statement statement ;
        ResultSet resultSet ;
        Quote quote ;
        DatabaseAccess da = new DatabaseAccess();
        try {
            connection = da.createConnection();
            statement = connection.createStatement() ;
            resultSet = statement.executeQuery(query) ;

            while(resultSet.next()) {
                id = resultSet.getString("id") ;
                author = resultSet.getString("author") ;
                cat = resultSet.getString("category") ;
                quotation = resultSet.getString("quote") ;

                quote = new Quote(id, author, cat, quotation) ;

                listOfQuotes.add(quote) ;
            }
        }
        catch (Exception e) {
            e.printStackTrace() ;
        }

        return listOfQuotes ;
    }

}
