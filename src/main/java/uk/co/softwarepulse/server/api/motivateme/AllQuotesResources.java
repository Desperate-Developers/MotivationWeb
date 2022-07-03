package uk.co.softwarepulse.server.api.motivateme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.AllQuotesDAO;

import java.util.ArrayList;
import java.util.List;


@Path("/quotes/all")
public class AllQuotesResources {

    /**
     * Used to obtain all the quotes stored in the database
     * @return a List of Quote objects
     */
    @GET
    public List<Quote> getAllQuotes() {

        List<Quote> quoteList = new ArrayList<>() ;
        AllQuotesDAO dao = new AllQuotesDAO() ;

        try {
            quoteList = dao.getAllQuotes() ;
        }
        catch (Exception e) {
            quoteList.add(new Quote("-1", "ERROR", e.getCause().toString(), e.getLocalizedMessage())) ;
        }

        return quoteList ;
    }
}
