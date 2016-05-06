package command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionprovider.ConnectionProvider;

public class DeleteListCommand {

	public boolean execute() {

		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("delete from  t_students  ");
			int row = stmt.executeUpdate();
			if (row >= 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
