package conectionClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
	
	private static String path = "jdbc:mysql://localhost:3305/trainingDB";
	private static String user = "root";
	private static String password = "";
	
	public static Connection connectDB() throws SQLException {
		
		try	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(path, user, password);
			
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
	}
	
}
