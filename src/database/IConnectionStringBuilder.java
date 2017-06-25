/**
 * 
 */
package database;

/**
 * @author TTen
 *
 */
public interface IConnectionStringBuilder {

	public String build(String type, String host, int port, String name);
	
}
