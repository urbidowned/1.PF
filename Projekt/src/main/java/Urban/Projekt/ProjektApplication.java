package Urban.Projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

@SpringBootApplication
public class ProjektApplication {
 //  public static void main(String[] args) throws IOException, SQLException {
//        System.out.println("start");
//        String DB_URL = "jdbc:mysql://localhost/";
//        String USER = "guest";
//        String PASS = "guest123";
//		String filePath = "Rates.xlsx";
//		FileInputStream inputStream = new FileInputStream(filePath);
//		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//		XSSFSheet sheet = workbook.getsheetAt(0);
//		Iterator<Row> iterator = sheet.iterator();
//		Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//		String sql = "INSERT INTO...";
//		Statement statement = connection.createStatement();
//        int rows = statement.executeUpdate();
//        SpringApplication.run(ProjektApplication.class, args);
//        System.out.println("end");
//    }

   public static void main(String[] args) {
        System.out.println("start");
      //ExchangeDatabase rates = new ExchangeDatabase();
       //	ExchangeDatabase.create();
       SpringApplication.run(ProjektApplication.class, args);
      System.out.println("end");
  }

}
