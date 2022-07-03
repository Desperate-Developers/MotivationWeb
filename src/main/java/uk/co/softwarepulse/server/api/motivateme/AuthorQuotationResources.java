package uk.co.softwarepulse.server.api.motivateme;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.AuthorQuoteDAO;


@Path("/quote/author")
public class AuthorQuotationResources {
    /**
     * Used to obtain a single random quote by a particular author
     * @param author name of the author sought
     * @return Quote object
     */
    @GET
    public Quote getQuote(@QueryParam("author") String author) {

        AuthorQuoteDAO dao = new AuthorQuoteDAO() ;
        List<Quote> quotes ;
        Random r = new Random() ;

        try {
            quotes = dao.getAuthor(author) ;
        }
        catch (Exception e) {
            return new Quote("-1", "ERROR", e.getCause().toString(), e.getLocalizedMessage()) ;
        }

        return quotes.get(r.nextInt(quotes.size())) ;
    }


    /**
     * Used to obtain all the quotes by a particular author
     * @param author name of the author sought
     * @return List of Quote objects
     */
    @GET
    @Path("/all")
    public List<Quote> getAllQuotesBy(@QueryParam("author") String author) {

        AuthorQuoteDAO dao = new AuthorQuoteDAO() ;
        List<Quote> quotes = new ArrayList<>() ;

        try {
            quotes = dao.getAuthor(author) ;
        }
        catch (Exception e) {
            quotes.add(new Quote("-1", "ERROR", e.getCause().toString(), e.getLocalizedMessage())) ;
        }

        return quotes ;
    }


    /**
     * Used to obtain the names of all the authors of stored quotes
     * @return List of Quote objects
     */
    @GET
    @Path("/list")
    public List<String> getAllAuthors() {
        AuthorQuoteDAO dao = new AuthorQuoteDAO() ;
        List<String> authors = new ArrayList<>() ;

        try {
            authors = dao.getAuthors() ;
        }
        catch (Exception e) {
            authors.add("ERROR: " + e.getCause().toString()) ;
        }

        return authors ;
    }
}
