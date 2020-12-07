import javax.xml.transform.Result;
import java.sql.*;

public class Students {
    // JDBC driver name and database URL
    static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/school?useTimezone=true&serverTimezone=UTC";
    //  Database credentials
    static final String user = "root";
    static final String password = "";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("Connecting to database........");
            connection = DriverManager.getConnection(url, user, password);
            //STEP 4: Execute a query
            System.out.println("Display students in aScending Oder......");
            Statement statement = connection.createStatement();
            String sql;
            //Query for name in Ascending Orders
            sql = "SELECT * FROM students ORDER BY name ASC";

            ResultSet rs = statement.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int student_Id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");

                //Display Values
                System.out.println("Student_Id " + student_Id +" name " + name +" address " + address);
            }
            //STEP 6: Clean-up environment
            rs.close();
            statement.close();
        } catch (SQLException sqlException)
        //Handle errors for JDBC
        {
            sqlException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end sqlExample
