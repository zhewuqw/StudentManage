package command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;
import connectionprovider.ConnectionProvider;

public class ListStudentsCommand {

	public ArrayList<Student> execute() {
		ArrayList<Student> ret = new ArrayList<Student>();
		try {
			Connection connection = ConnectionProvider.getConnection();
			// Statement stmt = connection.createStatement();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM t_students");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("name"),
						rs.getString("email"), rs.getString("phone"),
						rs.getString("sex"), rs.getInt("age"),
						rs.getString("address"));
				ret.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new ListStudentsCommand().execute());
	}

}
