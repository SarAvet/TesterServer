package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseContext {
	
	private final Connection connection;
	
	public DatabaseContext(String url, String login, String password) throws SQLException {
		
		url = url.trim();
		login = login.trim();
		password = password.trim();
		
		connection = DriverManager.getConnection(url, login, password);
	}
	
}
