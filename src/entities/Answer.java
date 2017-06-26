package entities;

public class Answer {

	int code;
	String text;
	boolean isRight;
	String comment; 
	
	public Answer(String text, boolean isRight, String comment){
		this.text = text;
		this.isRight = isRight;
		this.comment = comment;
	}
	
	public Answer(){}
	
	public String getText(){
		return this.text;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setRight(boolean right){
		this.isRight = right;
	}
	
	public boolean isRight(){
		return this.isRight;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}
	
	public String getComment(){
		return this.comment;
	}
}
