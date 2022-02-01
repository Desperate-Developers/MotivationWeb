package uk.co.softwarepulse.server.api.motivateme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/quote")
public class RandomQuotationResources
{
    @GET
    public String showRandomQuote()
    {
        return "An A student manages time, an A* student makes time." ;
    }
}
