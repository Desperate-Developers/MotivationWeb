package uk.co.softwarepulse.server.api.motivateme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import uk.co.softwarepulse.server.api.motivateme.data.Quote;
import uk.co.softwarepulse.server.api.motivateme.db.CategoryQuoteDAO;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


@Path("/quote/category")
public class CategoryQuotationResources {

    /**
     * Used to obtain a single random quote based on a particular category
     * @param category the name of the category sought
     * @return Quote
     */
    @GET
    public Quote getQuote(@QueryParam("category") String category) {

        CategoryQuoteDAO quoteDAO = new CategoryQuoteDAO() ;
        List<Quote> quotes ;
        Random r = new Random() ;

        try {
            quotes = quoteDAO.getCategory(category) ;
        }
        catch (Exception e) {
            return new Quote("-1", "ERROR", e.getCause().toString(), e.getLocalizedMessage()) ;
        }

        return quotes.get(r.nextInt(quotes.size())) ;
    }


    /**
     * Used to obtain all the Quotes on a particular category from the database
     * @param category name of the category
     * @return List of Quote objects
     */
    @GET
    @Path("/all")
    public List<Quote> getAllQuotesOn(@QueryParam("category") String category) {

        CategoryQuoteDAO quoteDAO = new CategoryQuoteDAO() ;
        List<Quote> quotes = new ArrayList<>() ;

        try {
            quotes = quoteDAO.getCategory(category) ;
        }
        catch (Exception e) {
            quotes.add(new Quote("-1", "ERROR", e.getCause().toString(), e.getLocalizedMessage())) ;
        }

        return quotes ;
    }


    /**
     * Used to obtain a list of all the categories of the quotes
     * @return List of Quote objects
     */
    @GET
    @Path("/list")
    public List<String> getAllCategories() {
        CategoryQuoteDAO quoteDAO = new CategoryQuoteDAO() ;
        List<String> categories = new ArrayList<>() ;

        try {
            categories = quoteDAO.getAllCategories() ;
        }
        catch (Exception e) {
            categories.add("ERROR: " + e.getCause().toString()) ;
        }

        return categories ;
    }
}
