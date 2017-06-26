package context;

import java.sql.SQLException;
import java.util.List;

import entities.*;

/**
 * @author TTen
 *
 */
public interface IDatabaseContext {
	
	public List<User> getUsers() throws SQLException;
	
}
