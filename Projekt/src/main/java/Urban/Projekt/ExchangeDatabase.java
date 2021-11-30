package Urban.Projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//public class ExchangeDatabase {
//    static final String DB_URL = "jdbc:mysql://localhost/";
//    static final String USER = "guest";
//    static final String PASS = "guest123";
//
//    public static void create() {
//        // Open a connection
//        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement stmt = conn.createStatement()
//        ) {
//            String sql = "CREATE DATABASE EXCHANGERATES";
//            stmt.executeUpdate(sql);
//            System.out.println("Database created successfully...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//             Statement stmt = conn.createStatement()
//        ) {
//            String sql = "create table dateRates(\n" +
//                    "date DATE NOT NULL,\n" +
//                    "content VARCHAR(5000) NOT NULL,\n" +
//                    "PRIMARY KEY ( date )";
//            stmt.executeUpdate(sql);
//            System.out.println("Table created successfully...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//
//
//    }
//}