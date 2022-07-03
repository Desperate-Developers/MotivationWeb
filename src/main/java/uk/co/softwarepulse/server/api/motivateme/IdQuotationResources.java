package uk.co.softwarepulse.server.api.motivateme ;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.IdQuoteDAO;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.IdQuoteDAO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;


@Path("/quote/id")
public class IdQuotationResources {

    /**
     * Used to fetch a quote with a specific id from the database
     * @param id the id sought
     * @return a Quote object
     */
    @GET
    public Quote showQuoteBasedOnID(@QueryParam("id") String id) {
        IdQuoteDAO quoteDAO = new IdQuoteDAO() ;
        Quote quote;

        try {
            quote = quoteDAO.getId(id) ;
        } catch (Exception e) {
            quote = new Quote("-1", "ERROR", e.getCause().toString(), e.getLocalizedMessage()) ;
        }

        return quote ;

        IdQuoteDAO quoteDAO = new IdQuoteDAO();
        Quote quote;

        try {
            quote = quoteDAO.getId(id).get(0);
        } catch (Exception e) {
            quote = new Quote("-1", "", e.getCause().toString(), e.getLocalizedMessage());
        }

        return quote;
    }
}
