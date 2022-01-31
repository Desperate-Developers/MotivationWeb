package uk.co.softwarepulse.server.api.motivateme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;



@Path("/quote")
public class AuthorQuotationResources {

    @GET
    public String showQuoteBasedOnAuthor(@QueryParam("author") String author) {
        return "A quote is only as good as quote " + author + ".";
    }
}