package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.*;

public class DatabaseContext implements IDatabaseContext{
	
	private final Connection connection;
	
	public DatabaseContext(String url, String login, String password) throws SQLException {
		
		url = url.trim();
		login = login.trim();
		password = password.trim();
		
		connection = DriverManager.getConnection(url, login, password);
	}
	
	/**
	 * Получение всех пользователей 
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<User> getUsers() throws SQLException{
		
		List<User> userList = new ArrayList<>();
		
		ResultSet usersSet = 
				connection.createStatement().executeQuery("SELECT * FROM tester.users");
			
		while(usersSet.next()){
			
			try
			{
				User user = new User();
				user.setLogin(usersSet.getString("login"));				
				user.setPassword(usersSet.getString("password"));
				
				boolean isBlocked = usersSet.getInt("isBlocked") == 0 ? false : true;
				user.setBlocked(isBlocked);
				userList.add(user);
				
			}
			catch(SQLException e){
				
			}
		}
		
		return userList;	
	}
	
}
