package command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionprovider.ConnectionProvider;

public class DeleteStudentCommand {

	public boolean execute(int id) {

		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("delete from  t_students  where id = ? ");
			stmt.setInt(1, id);
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
