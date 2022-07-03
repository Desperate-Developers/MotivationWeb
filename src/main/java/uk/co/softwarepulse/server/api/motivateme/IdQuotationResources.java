package uk.co.softwarepulse.server.api.motivateme;

import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.IdQuoteDAO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/quote/id")
public class IdQuotationResources {

    @GET
    public Quote showQuoteBasedOnID(@QueryParam("id") String id) {
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
