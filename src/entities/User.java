package entities;

public class User {

	String login;
	String password;
	boolean isBlocked;
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setBlocked(boolean blocked){
		this.isBlocked = blocked;
	}
	
	public boolean getBlocked(){
		return this.isBlocked;
	}
	
}
