package entities;

public class Question {
	int code;
	String question;
	int questionValue;
	Question subquestion;
	
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
}
