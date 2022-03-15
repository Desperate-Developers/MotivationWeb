package uk.co.softwarepulse.server.api.motivateme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.CategoryQuoteDAO;

@Path("/quote/category")
public class CategoryQuotationResources {

    @GET
    public Quote showQuoteBasedOnAuthor(@QueryParam("category") String category) {
        CategoryQuoteDAO quoteDAO = new CategoryQuoteDAO();
		List<Quote> quotes = new ArrayList<Quote>();

        try {
            quotes = quoteDAO.getCategory(category);
        } catch (Exception e) {
            Quote quote = new Quote("-1", "", e.getCause().toString(), e.getLocalizedMessage());
            return quote;
        }
        
		Random r = new Random();
		int ids = r.nextInt(quotes.size());
		return quotes.get(ids);

	}
	
}
