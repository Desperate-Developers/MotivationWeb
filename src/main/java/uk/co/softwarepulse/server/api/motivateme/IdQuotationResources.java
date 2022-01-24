package uk.co.softwarepulse.server.api.motivateme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/quote")
public class IdQuotationResources {

    @GET
    public String showQuoteBasedOnID(@QueryParam("id") int id) {
        return "A quote is only as good at quote " + id + ".";
    }
}
