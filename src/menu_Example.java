import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class menu_Example {

    public static Scanner scanner= new Scanner(System.in);

    public static int menu(){
        System.out.println("1. Display all Products");
        System.out.println("2. Display all orders");
        System.out.println("3. Display all Order_status");
        System.out.println("4. Display all customers");
        System.out.println("5. Quit");
        System.out.println("Enter your menu choice: ");
        int value = scanner.nextInt();
        return  value;
    }
    static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/cr5_famazon_sarojkaul" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    Connection connection = null;


    public void products(){
        try {
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("All products...");
            connection = DriverManager.getConnection(url,USERNAME,PASSWORD);
            System.out.println("Creating statement...");
            Statement statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM products";
            ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
              int Id = rs.getInt("product_Id");
              int category_Id = rs.getInt("fk_product_category_Id");
              String name = rs.getString("product_name");
              int stock = rs.getInt("stock");
             //Display all values

             System.out.println("Id: " +Id +" category: " +category_Id +" name: " +name +" Stock: " +stock);

                    }
        }catch (SQLException sql){
            sql.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void orders() {
        try {
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("All orders...");
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM orders";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt("order_Id");
                int customer_id = rs.getInt("fk_customer_Id");
                String date = rs.getString("order_date");
                int quantity = rs.getInt("quantity");
                //Display all values

                System.out.println("order Id: " + Id + " category: " + customer_id + " name: " + date + " Stock: " + quantity);

            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void allcustomers() {
        try {
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("All Customers...");
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM cutomers";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt("coustmer_Id");
                String firstname = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String gender = rs.getString("gender");
                String email = rs.getString("email");

                //Display all values

                System.out.println("Customer_Id: " +Id  +" First_name " +firstname +" last_name " +last_name +" gender: " +gender +" Email: " +email);

            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void UserInput() {
        int n = 0;
        try {
            do {
                Scanner userinput = new Scanner(System.in);
                System.out.println("Enter Your Choice");
                int x = userinput.nextInt();
                if (x >= 0 && x <= 5) {
                    switch (x) {
                        case 1: {
                            menu_Example menu_example = new menu_Example();
                            menu_example.products();
                            break;
                        }
                        case 2: {
                            menu_Example menu_example = new menu_Example();
                            menu_example.orders();
                            break;
                        }
                        case 3: {
                            menu_Example menu_example = new menu_Example();
                            menu_example.status();
                            break;
                        }
                        case 4: {
                            menu_Example menu_example = new menu_Example();
                            menu_example.allcustomers();
                            break;
                        }
                        case 5: {
                            System.out.println("Exit");
                            n =-1;
                        }

                    }
                } else {
                    System.out.println("Enter Valid number");
                }
            } while (n == 0);
            System.out.println("End");
        } catch (NumberFormatException e) {
            System.out.println("Enter numeric value");
        }
    }
    public void status(){
        try {
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("All Shipment_status...");
            connection = DriverManager.getConnection(url,USERNAME,PASSWORD);

            Statement statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM shipment_status";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int order_Id = rs.getInt("fk_order_Id");
                Date sent_date = rs.getDate("sent_date_Time");
                Date delivery_date = rs.getDate("delivery_date");
                String shipped = rs.getString("shipped");
                //Display all values

                System.out.println("order_Id: " +order_Id +" shipped_status " +shipped +" Sent_date: " +sent_date +" Delivery_date " +delivery_date);

            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}


