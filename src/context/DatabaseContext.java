package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.*;

public class DatabaseContext implements IDatabaseContext{
	
	private final Connection connection;
	
	public DatabaseContext(String url, String login, String password) throws SQLException {
		
		url = url.trim();
		login = login.trim();
		password = password.trim();
		
		connection = DriverManager.getConnection(url, login, password);
	}
	
	/**
	 * ѕолучение всех пользователей 
	 * @return - список пользователей
	 * @throws SQLException
	 */
	@Override
	public List<User> getUsers() throws SQLException{
		
		List<User> userList = new ArrayList<>();
		
		ResultSet usersSet = 
				connection.createStatement().executeQuery("SELECT * FROM tester.users");
			
		while(usersSet.next()){
			
			try
			{
				User user = new User();
				user.setLogin(usersSet.getString("login"));				
				user.setPassword(usersSet.getString("password"));
				
				boolean isBlocked = usersSet.getInt("isBlocked") == 0 ? false : true;
				user.setBlocked(isBlocked);
				userList.add(user);
				
				List<Departament> departaments = getDepartamentsOf(user);
				user.addDepartament(departaments);
				
			}
			catch(SQLException e){
				
			}
		}
		
		return userList;	
	}
	
	/**
	 * ѕолучение отделов некоторого пользовател€
	 * @param user - пользователь
	 * @return - список отделов, в котрые входит пользователь
	 * @throws SQLException
	 */
	public List<Departament> getDepartamentsOf(User user) throws SQLException{
		
		ResultSet userDepartamentsSet = 
				connection.createStatement().executeQuery("SELECT * FROM users_departaments "
															+ "WHERE user_login = '"+user.getLogin()+"'");
		
		List<Departament> userDepartaments = new ArrayList<>();
		
		while(userDepartamentsSet.next()){
			
			try
			{
				Departament departament = new Departament(userDepartamentsSet.getString("title"));
				userDepartaments.add(departament);
			}
			catch(SQLException e){
				
			}
			
		}
		
		return userDepartaments;
		
	}
	
	/**
	 * ѕолучение варианта ответа
	 * @param code - идентификатор варианта ответа
	 * @return - вариант ответа
	 * @throws SQLException
	 */
	public Answer getAnswer(int code) throws SQLException{
		
		if(code<=0)
		{
			throw new IllegalArgumentException(" од варианта ответа - целое положительное число.");
		}
		
		ResultSet answerSet = connection.createStatement().executeQuery("SELECT * FROM answers "
																			+ "WHERE code = "+code+"");
		Answer answer = new Answer();
		answer.setText(answerSet.getString("text"));
		
		return answer;
	}
	
	/**
	 * ѕолучение вариантов ответов на вопрос
	 * @param question
	 * @return список вариантов ответов на вопрос
	 * @throws SQLException
	 */
	public List<Answer> getAnswersOf(Question question) throws SQLException{
		
		ResultSet questionAnswersSet = 
				connection.createStatement().executeQuery("SELECT * FROM questions_answers "
															+ "WHERE question_code = "+question.getCode()+" ");
		List<Answer> questionAnswers = new ArrayList<>();
		
		while(questionAnswersSet.next())
		{
			boolean isAnswerRight = questionAnswersSet.getInt("isRight") != 0;
			
			Answer answer = getAnswer(questionAnswersSet.getInt("answer_code"));
			answer.setRight(isAnswerRight);
			answer.setComment(questionAnswersSet.getString("comment"));
			
			questionAnswers.add(answer);
		}
		
		return questionAnswers;
	}
	
	/**
	 * ѕолучение вопроса
	 * @param code - идентификатор вопроса
	 * @return - вопрос
	 * @throws SQLException
	 */
	public Question getQuestion(int code) throws SQLException{
		
		if(code<=0)
		{
			throw new IllegalArgumentException(" од вопроса - положительное целое число.");
		}
		
		ResultSet questionSet = connection.createStatement().executeQuery("SELECT * FROM questions "
																			+ "WHERE code = "+code+"");
		Question question = new Question(questionSet.getString("question"));
		return question;
	}
	
	
	/**
	 * ѕолучение вопросов теста
	 * @param test - тест
	 * @return - список вариантов ответа
	 * @throws SQLException
	 */
	public List<Question> getQuestionsOf(Test test) throws SQLException{
		
		ResultSet testQuestionsSet = 
				connection.createStatement().executeQuery("SELECT * FROM tests_questions "
															+ "WHERE test_title = '"+test.getTitle()+"' ");
		List<Question> testQuestions = new ArrayList<>();
		
		while(testQuestionsSet.next())
		{
			
			Question question = getQuestion(testQuestionsSet.getInt("question_code"));
			question.setQuestionValue(testQuestionsSet.getInt("question_value"));
			
			int subquestionCode = testQuestionsSet.getInt("subquestion_code");
			Question currentSubquestion = null;
			
			if(subquestionCode==0)
			{
				currentSubquestion = getQuestion(testQuestionsSet.getInt("subquestion_code"));
				question.setSubquestion(currentSubquestion);
				subquestionCode = currentSubquestion.getSubquestion().getCode();
			}
						
			testQuestions.add(question);
		}
		
		return testQuestions;
		
	}
	
	public Test getTest(String testTitle) throws SQLException{
		
		if(testTitle==null || testTitle!=null && testTitle.equals(""))
		{
			throw new IllegalArgumentException("Ќе указано название теста.");
		}
		
		ResultSet testSet = connection.createStatement().executeQuery("SELECT * FROM test "
																		+ "WHERE title = '"+testTitle+"'");
		
		Test test = new Test();
		
		
		return test;
		
	}
	
	public List<Test> getTestsOf(Departament departament) throws SQLException{
		
		ResultSet testsSet = 
				connection.createStatement().executeQuery("SELECT * FROM departaments_tests "
															+ "WHERE departaments_title = '"+departament.getTitle()+"'");
		List<Test> tests = new ArrayList<>();
		
		while(testsSet.next()){
			
			
			
		}
		
		return tests;
	}
	
}
