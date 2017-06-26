package entities;

import java.util.ArrayList;
import java.util.List;

public class User {

	String login;
	String password;
	boolean isBlocked;
	List<Departament> departaments;
	
	public User(){
		
		departaments = new ArrayList<>();
		
	}
	
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
	
	public void addDepartament(List<Departament> departament){
		this.departaments.addAll(departament);
	}
	
	public List<Departament> getDepartaments(){
		return this.departaments;
	}
	
}
