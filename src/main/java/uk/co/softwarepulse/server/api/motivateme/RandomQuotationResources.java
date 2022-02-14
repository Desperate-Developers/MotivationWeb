package uk.co.softwarepulse.server.api.motivateme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.RandomQuoteDAO;

import java.util.List;
import java.util.Random;

@Path("/quote")
public class RandomQuotationResources
{
    @GET
    public String showRandomQuote()
    {
        Random random = new Random() ;
        RandomQuoteDAO randomQuoteDAO = new RandomQuoteDAO() ;
        List<Quote> quoteList = randomQuoteDAO.showRandomQuote() ;

        int randomNum = random.nextInt(quoteList.size()) ;

        return quoteList.get(randomNum).toString() ;
    }
}
