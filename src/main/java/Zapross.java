import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Zapross {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://localhost:3306/new_schema";

		Properties props = new Properties();
		props.load(new FileReader("cod.properties"));

		//Database Username
		String username = props.getProperty("login");


		//Database Password
		String password = props.getProperty("pass");

		//Query to Execute
		String query = "select *\n" +
				"from new_table\n" +
				"limit 1;";

		//Load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");

		//Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs= stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		//while (rs.next()){
		rs.next();
			String email = rs.getString(1);
			String pass = rs.getString(2);
			System. out.println(email+"  "+pass);
		//}
		// closing DB Connection
		String qvery2 = "select password \n" +
				"from new_table\n" +
				"where password != "+pass+";";
		rs = stmt.executeQuery(qvery2);
		rs.next();
		String badPass = rs.getString(1);
		System.out.println(badPass);
		con.close();
	}


	}



