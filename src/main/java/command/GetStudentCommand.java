package command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import connectionprovider.ConnectionProvider;

public class GetStudentCommand {

	public Student execute(int id) {
		Student s = new Student();
		try {
			Connection connection = ConnectionProvider.getConnection();
			// Statement stmt = connection.createStatement();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM t_students WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				s = new Student(rs.getInt("id"), rs.getString("name"),
						rs.getString("email"), rs.getString("phone"),
						rs.getString("sex"), rs.getInt("age"),
						rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(new GetStudentCommand().execute(1));
	}

}
