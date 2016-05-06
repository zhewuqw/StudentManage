package command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Student;
import connectionprovider.ConnectionProvider;

public class UpdateStudentCommand {

	public boolean execute(Student s) {

		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("update  t_students set name =? , email =?, phone=?, sex=? ,age =?,address=? where id = ? ");
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getPhone());
			stmt.setString(4, s.getSex());
			stmt.setInt(5, s.getAge());
			stmt.setString(6, s.getAddress());
			stmt.setInt(7, s.getId());
			int row = stmt.executeUpdate();
			if (row == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
