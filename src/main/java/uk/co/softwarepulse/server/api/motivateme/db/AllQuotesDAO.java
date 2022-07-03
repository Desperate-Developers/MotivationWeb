package uk.co.softwarepulse.server.api.motivateme.db;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AllQuotesDAO {

    public List<Quote> getAllQuotes() throws Exception {
        List<Quote> quoteList = new ArrayList<>();
        String id, author, category, quotation, query ;

        Connection connection ;
        Statement statement ;
        ResultSet resultSet;

        DatabaseAccess dbAccess = new DatabaseAccess() ;
        Quote quote = new Quote() ;

        query = "SELECT * FROM  motivate.quotations;" ;

        connection = dbAccess.createConnection() ;
        statement = connection.createStatement() ;

        resultSet = statement.executeQuery(query) ;

        while (resultSet.next()) {
            id = resultSet.getString("id") ;
            author = resultSet.getString("author") ;
            category = resultSet.getString("category") ;
            quotation = resultSet.getString("quote") ;

            quote = new Quote(id, author, category, quotation) ;

            quoteList.add(quote);
        }

        return quoteList ;
    }
}
