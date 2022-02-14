package logic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class UserDao {
	private String jdbcURL = "jdbc:postgresql://192.168.0.32:5432/test_db";
	private String jdbcUsername = "postgres";
	private String jdbcPassword = "123qwerty321";

	private static final String INSERT_USERS_SQL = "INSERT INTO people" + "  (name, surname, age) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,surname, age from people where id =?;";
	private static final String SELECT_ALL_USERS = "select * from people;";
	private static final String DELETE_USERS_SQL = "delete from people where id = ?;";
	private static final String UPDATE_USERS_SQL = "update people set name = ?,surname= ?, age =? where id = ?;";

	public UserDao() {
	}

	protected java.sql.Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = java.sql.DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(logic.User user) throws java.sql.SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (java.sql.Connection connection = getConnection();
				java.sql.PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setInt(3, user.getAge());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (java.sql.SQLException e) {
			printSQLException(e);
		}
	}

	public logic.User selectUser(int id) {
		logic.User user = null;
		// Step 1: Establishing a Connection
		try (java.sql.Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				java.sql.PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			java.sql.ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int age = Integer.parseInt(rs.getString("age"));
				user = new logic.User(name, surname, age);
			}
		} catch (java.sql.SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public java.util.List<logic.User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		java.util.List<logic.User> users = new java.util.ArrayList<>();
		// Step 1: Establishing a Connection
		try (java.sql.Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			java.sql.ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int age = Integer.parseInt(rs.getString("age"));
				users.add(new logic.User(name, surname, age));
			}
		} catch (java.sql.SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws java.sql.SQLException {
		boolean rowDeleted;
		try (java.sql.Connection connection = getConnection();
				java.sql.PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(logic.User user) throws java.sql.SQLException {
		boolean rowUpdated;
		try (java.sql.Connection connection = getConnection();
				java.sql.PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getSurname());
			statement.setInt(3, user.getAge());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(java.sql.SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof java.sql.SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((java.sql.SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((java.sql.SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
