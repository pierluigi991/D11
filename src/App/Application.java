package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Application {
	
	public class StudentDatabase {
	    private Connection connection;

	    public StudentDatabase() {
	        // Connessione al database
	    	String url = "jdbc:postgresql://localhost:5432/d11?useSSL=false";
			String username = "postgres";
			String password = "10085684Aa";

	        try {
	            connection = DriverManager.getConnection(url, username, password);
	        } catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    }

	    public void insertStudent(Student student) {
	        String s = "INSERT INTO students (id, name, lastname, gender, birthday, avg, min_vote, max_vote) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	        try {
	            PreparedStatement statement = connection.prepareStatement(s);
	            statement.setInt(1, student.getId());
	            statement.setString(2, student.getName());
	            statement.setString(3, student.getLastname());
	            statement.setString(4, student.getGender());
	            statement.setString(5, student.getBirthday());
	            statement.setDouble(6, student.getAvg());
	            statement.setDouble(7, student.getMinVote());
	            statement.setDouble(8, student.getMaxVote());

	            statement.execute();
	        } catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    }
	    
	    //metodo per cancellare
	    
	    public void deleteStudent(int id) {
	        String d= "DELETE FROM students WHERE id = ?";

	        try {
	            PreparedStatement statement = connection.prepareStatement(d);
	            statement.setInt(1, id);

	            statement.execute();
	        }  catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    }
	    
	    public Student getBest() {
	        String query = "SELECT id, name, lastname, gender, birthday, avg, min_vote, max_vote FROM students " +
	                "ORDER BY avg DESC LIMIT 1";

	        try {
	            PreparedStatement statement = connection.prepareStatement(query);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                String lastname = resultSet.getString("lastname");
	                String gender = resultSet.getString("gender");
	                String birthday = resultSet.getString("birthday");
	                double avg = resultSet.getDouble("avg");
	                double minVote = resultSet.getDouble("min_vote");
	                double maxVote = resultSet.getDouble("max_vote");

	                return new Student(id, name, lastname, gender, birthday, avg, minVote, maxVote);
	            }
	        } catch (Exception e) {
				System.out.println(e.getMessage());
			}

	        return null;
	    }
	    
	    
	}
}
