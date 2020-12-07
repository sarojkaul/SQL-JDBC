import java.sql.*;
public class Courses {
    // JDBC driver name and database URL

    static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/school" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    static final String user = "root";
    static final String password = "";


    public static void main(String[] args) {
        Connection connection = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(url,user,password);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            Statement statement = connection.createStatement();
            String sql;

            sql= "SELECT * FROM courses";
            ResultSet rs = statement.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                int Id = rs.getInt("Id");
                String name = rs.getString("name");

                //Display values
                System.out.println("course_Id: " + Id + " Course_name: " + name);
            }
                rs.close();
                statement.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(connection!=null)
                        connection.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
            System.out.println("Goodbye!");
        }//end main
    }//end JDBCExample




