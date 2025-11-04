import java.sql.*; 

public class sqlMiddle {  
	public static void main(String[] args)
      {
        try
        (
          // create a database connection
          Connection connection = DriverManager.getConnection("jdbc:sqlite:db/test.db");
          Statement statement = connection.createStatement();
        )
        {
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
          }
        }
        catch(SQLException e)
        {
          e.printStackTrace(System.err);
        }
      }
}
