/**
 * copyright (c) SoftwarePulse 2022
 */
package uk.co.softwarepulse.server.api.motivateme;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import uk.co.softwarepulse.server.api.motivateme.db.QuoteListsDAO;

/**
 * Returns a list of quotation categories 
 * @author John McNeil
 * version: 1.0.0.0
 * since: 20 Feb 2022
 */
@Path("/quote")
public class CatergoryListResources {

    @GET
    @Path("/category/list")
    public List<String> showCategoryList() {
        QuoteListsDAO listsDAO = new QuoteListsDAO();
        List<String> list = new ArrayList<>();

        try {
            list = listsDAO.getCategories();
        } catch (Exception e) {
            list.add(e.getCause().toString());
            list.add(e.getLocalizedMessage());
        }

        return list;
    }

    @GET
    @Path("/author/list")
    public List<String> showAuthorList() {
        QuoteListsDAO listsDAO = new QuoteListsDAO();
        List<String> list = new ArrayList<>();

        try {
            list = listsDAO.getAuthors();
        } catch (Exception e) {
            list.add(e.getCause().toString());
            list.add(e.getLocalizedMessage());
        }

        return list;
    }

}
