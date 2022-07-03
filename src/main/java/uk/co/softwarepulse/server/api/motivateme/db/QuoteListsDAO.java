/**
 * copyright (c) SoftwarePulse 2022
 */
package uk.co.softwarepulse.server.api.motivateme.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Gets unique lists of Categories and Authors 
 * from the quotations database
 * @author John Mc
 * version: 1.0.0.0
 * since: 20 Feb 2022
 */
public class QuoteListsDAO {

    public List<String> getCategories() throws SQLException {
        List<String> list = new ArrayList<>();
        String query = "SELECT DISTINCT category FROM motivate.quotations";
        String category;

        DatabaseAccess dbAccess = new DatabaseAccess();
        ResultSet resultSet;

        try (Connection connection = dbAccess.createConnection(); Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                category = resultSet.getString("category");
                list.add(category);
            }
        } catch (Exception e) {
            throw new SQLException();
        }

        return list;
    }

	
    public List<String> getAuthors() throws SQLException {
        List<String> list = new ArrayList<>();
        String query = "SELECT DISTINCT author FROM motivate.quotations";
        String author;

        DatabaseAccess dbAccess = new DatabaseAccess();
        ResultSet resultSet;

        try (Connection connection = dbAccess.createConnection(); Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                author = resultSet.getString("author");
                list.add(author);
            }
        } catch (Exception e) {
            throw new SQLException();
        }

        return list;
    }

	
}
