package uk.co.softwarepulse.server.api.motivateme.db;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomQuoteDAO {

    public Quote showRandomQuote() throws Exception
    {
        AllQuotesDAO dao = new AllQuotesDAO() ;
        List<Quote> listOfQuotes = new ArrayList<>() ;
        Quote quote ;
        Random random ;
        int randomNum ;

        listOfQuotes = dao.getAllQuotes() ;

        //DatabaseAccess da = new DatabaseAccess();
        try {
            
            dbAccess = new DatabaseAccess();
            connection = dbAccess.createConnection();

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

            quote = new Quote() ;
            quote.setCategory(e.toString());
            quote.setQuotation(e.getMessage());


        // pick a random quote from the list of quotes obtained
        random = new Random() ;
        randomNum = random.nextInt(listOfQuotes.size()) ;
        quote = listOfQuotes.get(randomNum) ;

        return quote ;
    }
}
