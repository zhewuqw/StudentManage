package connectionprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.PropertiesLookup;

/**
 * Database tools (access to the database connection, close the database
 * connection)
 */
public class ConnectionProvider {

	/**
	 * Access to the database connection
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() {
		try {
			PropertiesLookup p = new PropertiesLookup();

			return getConnection(p.getProperty("ipport"), p.getProperty("db"),
					p.getProperty("username"), p.getProperty("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Release the database connection
	 * 
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void closeDb(Connection conn, Statement stat, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stat != null) {
				stat.close();
				stat = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Through JDBC access to the corresponding database link connection
	 * 
	 * @param ipport
	 *            The database server IP
	 * @param dbName
	 *            The name of the database
	 * @param username
	 *            The database connection user name
	 * @param password
	 *            Connection to the database password
	 * @param type
	 *            The database type
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection(String ipport, String dbName,
			String username, String password) throws ClassNotFoundException,
			SQLException {
		String jdbcString = null;
		/**
		 * Load database driver class
		 */
		jdbcString = "jdbc:mysql://" + ipport + "/" + dbName;
		Class.forName("org.gjt.mm.mysql.Driver");
		Connection connection = null;
		connection = DriverManager
				.getConnection(jdbcString, username, password);
		return connection;
	}

}