package uk.co.softwarepulse.server.api.motivateme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.AuthorQuoteDAO;

@Path("/quote/author")
public class AuthorQuotationResources {
	@GET
	public Quote getQuote(@QueryParam("author") String author) {
		
		AuthorQuoteDAO dao = new AuthorQuoteDAO();
		List<Quote> quotes = new ArrayList<Quote>();

		quotes = dao.getAuthor(author);

		// Return random category value
		// This is a Java 8 option
		Random r = new Random();
		int ids = r.nextInt(quotes.size());
		return quotes.get(ids);
	}

}
