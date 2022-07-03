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

        // pick a random quote from the list of quotes obtained
        random = new Random() ;
        randomNum = random.nextInt(listOfQuotes.size()) ;
        quote = listOfQuotes.get(randomNum) ;

        return quote ;
    }
}
