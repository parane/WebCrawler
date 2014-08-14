

import java.sql.*;
import java.util.Calendar;
import java.util.List;
 
/**
 * A Java MySQL PreparedStatement INSERT example.
 * Demonstrates the use of a SQL INSERT statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 * 
 * Created by Alvin Alexander, <a href="http://devdaily.com" title="http://devdaily.com">http://devdaily.com</a>
 */
public class DBInsert 
{
 
  public void  insert(List<Review> reviewList)
  {
    try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost/web_craw";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
     
      // create a sql date object so we can use it in our INSERT statement
      Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
 
      // the mysql insert statement
      String query = " insert into detail (resturant, review)"
        + " values (?, ?)";
 
     
      // create the mysql insert preparedstatement
      
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      for(int i=0; i<reviewList.size();i++)
      {
      preparedStmt.setString (1, reviewList.get(i).getResturant());
      preparedStmt.setString (2, reviewList.get(i).getReview());
 
      // execute the preparedstatement
      preparedStmt.execute();
      }
       
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}