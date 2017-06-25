package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import database.ConnectionStringBuilder;
import database.IConnectionStringBuilder;

public class ConnectionStringBuilderTest {

	@Test
	public void withNegativePort() {
		
		IConnectionStringBuilder connectionString = new ConnectionStringBuilder();
		
		try
		{
			connectionString.build("mysql", "localhost", -1234, "test");
			assertFalse(true);
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}	
	}
	
	@Test
	public void withNullType() {
		
		IConnectionStringBuilder connectionString = new ConnectionStringBuilder();
		
		try
		{
			connectionString.build(null, "localhost", 1234, "test");
			assertFalse(true);
		}
		catch(NullPointerException e){
			assertTrue(true);
		}	
		
	}
	
	@Test
	public void withNullHost() {
		
		IConnectionStringBuilder connectionString = new ConnectionStringBuilder();
		
		try
		{
			connectionString.build("oracle", null, 1234, "test");
			assertFalse(true);
		}
		catch(NullPointerException e){
			assertTrue(true);
		}	
		
	}

	@Test
	public void withNullName() {
		
		IConnectionStringBuilder connectionString = new ConnectionStringBuilder();
		
		try
		{
			connectionString.build("oracle", "localhost", 1234, null);
			assertFalse(true);
		}
		catch(NullPointerException e){
			assertTrue(true);
		}	
		
	}
	
}
