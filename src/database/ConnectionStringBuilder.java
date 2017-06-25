package database;

/**
 * @author TTen
 *
 */
public class ConnectionStringBuilder implements IConnectionStringBuilder{

	/**
	 * 
	 */
	@Override
	public String build(String type, String host, int port, String name){
		
		if(port<=0)
		{
			throw new IllegalArgumentException("Порт должен быть > 0.");
		}
		
		type = type.trim();
		host = host.trim();
		name = name.trim();
		
		return String.format("jdbc:%s://%s:%d/%s", type, host, port, name);	
		
	}

}
