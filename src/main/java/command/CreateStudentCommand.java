package command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Student;
import connectionprovider.ConnectionProvider;

public class CreateStudentCommand {

	public boolean execute(Student s) {
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO t_students VALUES(null,?,?,?,?,?,?)");
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getPhone());
			stmt.setString(4, s.getSex());
			stmt.setInt(5, s.getAge());
			stmt.setString(6, s.getAddress());
			int row = stmt.executeUpdate();
			if (row == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new CreateStudentCommand().execute(new Student()));
	}
}
