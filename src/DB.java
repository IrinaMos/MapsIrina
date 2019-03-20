import java.sql.*;

public class DB {
        private static Connection con;

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            connectToDB();
            readDBTable();
        }

        public static void connectToDB() throws ClassNotFoundException, SQLException {

            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC", "root", "!im09061102!");

        }

        private static void readDBTable() throws SQLException {
            //Execute a query
            String statementToExecute = "";
            Statement stmt = con.createStatement();
            statementToExecute = "SELECT * FROM ir_schema.first_table;";

            // iterate over query results
            ResultSet rs = stmt.executeQuery(statementToExecute);
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("name");
                int age = rs.getInt("age");

                //Display values
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            rs.close();
            // close db connections
        }

        public static void insertfirst_table() throws SQLException {
            //Execute a query
//        con.setAutoCommit(true);
            Statement stmt1 = con.createStatement();
            //   String statementToExecute1 = "INSERT INTO `ir_schema`.`first_table` (`name`, `age`) VALUES ('" + "Dana" + "', '" + 1 + "'');";
            String statementToExecute1 = "INSERT INTO `ir_schema`.`first_table`(`name`,`age`)VALUES('abc',8);";
            stmt1.execute(statementToExecute1);
            stmt1.close();
            con.close();
        }

        public static void updatefirst_table() throws SQLException {
            //Execute a query
//        con.setAutoCommit(true);
            Statement stmt2 = con.createStatement();
            String statementToExecute2 = "UPDATE `ir_schema`.`first_table`SET`name` = ('Sean'),`age` = (14) WHERE age=8;";
            stmt2.executeUpdate(statementToExecute2);
            stmt2.close();
            con.close();
        }

        public static void deleteName() throws SQLException {
            //Execute a query
            String statementToExecute = "";
            Statement stmt = con.createStatement();
            statementToExecute = "DELETE FROM `ir_schema`.`first_table` WHERE `name`='sean';";
            stmt.execute(statementToExecute);

            stmt.close();
            con.close();
        }

    }
