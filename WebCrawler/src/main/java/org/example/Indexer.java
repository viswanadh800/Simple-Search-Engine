/*
Indexer receives web pages(html pages) from crawler.
Then it selects important part of web page and saves it to database.
How do we define "important" - things that are used by web server
In our case, this indexer's important part of web page are: Page title, Page link, Page text
page title and page link are used by web server to return in response to client, whereas
page text is used in ranking algorithm for selecting top30 most relevant web pages.

*/
package org.example;

import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Indexer {
    static Connection connection=null;
    Indexer(Document document, String url){ //document object is the one we got by parsing the webpage using jsoup
        //Select important elements of document
        String title = document.title();
        String link = url;
        String text = document.text();
        //Save these elements to database
        try {
            connection = DatabaseConnection.getConnection();
            //values of preparedStatement are dynamic and not static, so we have "?,?,?"
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into pages values(?, ?, ?);");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, link);
            preparedStatement.setString(3, text);
            preparedStatement.executeUpdate();
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }

}
