package entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


/**
 * ����� �������������� ������ �� ������� � �������
 * 
 */
public class Test {

	String title;
	String description;
	LocalTime time;
	LocalDateTime createDatetime;
	LocalDateTime updateDatetime;
	List<Question> questions;
	
	public Test(){
		questions = new ArrayList<>();
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	public LocalTime getTime(){
		return this.time;
	}
	
	public void setCreateDateTime(LocalDateTime createDateTime){
		this.createDatetime = createDateTime;
	}
	
	public LocalDateTime getCreateDateTime(){
		return this.createDatetime;
	}
	
	public void setUpdaetDateTime(LocalDateTime updateDateTime){
		this.updateDatetime = updateDateTime;
	}
	
	public LocalDateTime getUpdateDateTime(){
		return this.updateDatetime;
	}
	
	public void addQuestion(List<Question> questions){
		this.questions.addAll(questions);
	}
	
	public List<Question> getQuestions(){
		return this.questions;
	}
	
}
