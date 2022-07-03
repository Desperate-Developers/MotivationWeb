package uk.co.softwarepulse.server.api.motivateme ;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.RandomQuoteDAO;


@Path("/quote")
public class RandomQuotationResources
{
    /**
     * Used to return a random quote from the database
     * @return a Quote object
     */
    @GET
    public Quote showRandomQuote()
    {
        RandomQuoteDAO randomQuoteDAO = new RandomQuoteDAO() ;
        Quote quote ;

        try {
            quote = randomQuoteDAO.showRandomQuote() ;
        }
        catch (Exception e) {
            quote = new Quote("-1", "ERROR", e.getCause().toString(), e.getLocalizedMessage()) ;
        }

        return quote ;
    }
}
