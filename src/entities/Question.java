package entities;

import java.util.List;

public class Question {
	int code;
	String question;
	int questionValue;
	Question subquestion;
	List<Answer> answers;
	
	/**
	 * 
	 * @param question - текст вопроса
	 * @param questionValue - цена вопроса
	 * @param subquestion - подвопрос
	 */
	public Question(String question, int questionValue, Question subquestion){
		this.question = question;
		this.questionValue = questionValue;
		this.subquestion = subquestion;
	}
	
	/**
	 * 
	 * @param question - тест вопроса
	 */
	public Question(String question){
		this.question = question;
	}
	
	public String getQuestion(){
		return this.question;
	}
	
	public void setQuestion(String question){
		this.question = question;
	}
	
	public void setCode(int code){
		this.code = code;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public int getQuestionValue(){
		return this.questionValue;
	}
	
	public void setQuestionValue(int questionValue){
		this.questionValue = questionValue;
	}
	
	public void setSubquestion(Question subquestion){
		this.subquestion = subquestion;
	}
	
	public Question getSubquestion(){
		return this.subquestion;
	}
	
	public void setAnswers(List<Answer> answers){
		this.answers = answers;
	}
	
	public List<Answer> getAnswers(){
		return this.answers;
	}
}
