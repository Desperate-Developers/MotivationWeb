package uk.co.softwarepulse.server.api.motivateme.db;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RandomQuoteDAO {

    public List<Quote> showRandomQuote()
    {
        List<Quote> listOfQuotes = new ArrayList<>() ;
        String query = "SELECT * FROM motivate.quotations;" ;
        String category, quotation, author ;

        Connection connection ;
        Statement statement ;
        ResultSet resultSet ;
        Quote quote ;

        try {
            connection = DatabaseAccess.createConnection();

            statement = connection.createStatement() ;

            resultSet = statement.executeQuery(query) ;

            while(resultSet.next()) {
                author = resultSet.getString("author") ;
                category = resultSet.getString("category") ;
                quotation = resultSet.getString("quote") ;

                quote = new Quote(author, category, quotation) ;

                listOfQuotes.add(quote) ;
            }
        }
        catch (Exception e) {
            e.printStackTrace() ;
        }

        return listOfQuotes ;
    }

}
