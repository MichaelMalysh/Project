package toOOP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class ConnectionToSQL {
	private static final String url = "jdbc:mysql://localhost:3306/student" + // підключення
																				// до
																				// БД
			"?verifyServerCertificate=false" + // з'єднується без потреби
												// клієнтської пам'яті клієнта
												// та довірчого сервера
			"&useSSL=false" + // відключення SSL Secure Sockets Layer – рівень
								// захищених сокетов
			"&requireSSL=false" + // не дозволяє серверу встановлювати тільки
									// зашифровані за допомогою протоколу SSL
									// з'єднання
			"&useLegacyDatetimeCode=false" + // встановлення параметру з'єднання
			"&amp" + // технологія прискорених мобільних сторінок
			"&serverTimezone=UTC";// встановлення часового поясу
	private static final String userID = "student";// UserId to BD
	private static final String password = "student";// password to BD

	// init connection Object
	private Connection connection;
	// init properties Object
	private Properties properties;
	// init statement Object
	private Statement statement;
	// init resultSet Object;
	private ResultSet resultSet;
	// init PrepareStatement Object
	private PreparedStatement prepareStmt;

	public ConnectionToSQL(Connection connection) {
		super();
		this.connection = connection;
	}

	public ConnectionToSQL() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			properties.setProperty("user", userID);
			properties.setProperty("password", password);
		}
		return properties;
	}

	// connect database
	public Connection connect() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, getProperties());
				// System.out.println("Database was connected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	// disconnect database
	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
				// System.out.println("Database was disconnect");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// create statement
	public Statement statement() {
		if (connection != null) {
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				System.out.println("Unable to create statement");
			}
		}
		return statement;
	}

	// create ResultSet
	// output result of certain columnIndex
	public ResultSet resultSet(int number) {
		if (statement != null) {
			try {
				resultSet = statement.executeQuery("SELECT * FROM student.info");
			} catch (SQLException e) {
				System.out.println("Unable to create statement");
			}
		}
		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					System.out.println("SELECT " + number + " FROM student.info : " + resultSet.getString(number));
				}
			} catch (SQLException e) {
				System.out.println("Unable to iterate over resultset");
			}
		}
		return resultSet;
	}

	// create ResultSet
	// output result of certain columnName
	public ResultSet resultSet(String name) {
		if (statement != null) {
			try {
				resultSet = statement.executeQuery("SELECT * FROM student.info");
			} catch (SQLException e) {
				System.out.println("Unable to create statement");
			}
		}
		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					System.out.println("SELECT " + name + " FROM student.info : " + resultSet.getString(name));
				}
			} catch (SQLException e) {
				System.out.println("Unable to iterate over resultset");
			}
		}
		return resultSet;
	}

	public PreparedStatement preparedStatement(String faculty, String speciality, int course, String formOfStudy) {
		if (statement != null) {
			try {
				prepareStmt = connection.prepareStatement(
						"SELECT * FROM student.info where Faculty = ? and Speciality = ? and Cours = ? and Form_of_study = ?");
				prepareStmt.setString(1, faculty);
				prepareStmt.setString(2, speciality);
				prepareStmt.setInt(3, course);
				prepareStmt.setString(4, formOfStudy);

				resultSet = prepareStmt.executeQuery();
				display(resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return prepareStmt;
	}

	public PreparedStatement preparedStatement(String speciality, int course, String formOfStudy) {
		if (statement != null) {
			try {
				prepareStmt = connection.prepareStatement(
						"SELECT * FROM student.info where  (Speciality = ? or Faculty = ?) and Cours = ? and Form_of_study = ?");
				prepareStmt.setString(1, speciality);
				prepareStmt.setString(2, speciality);
				prepareStmt.setInt(3, course);
				prepareStmt.setString(4, formOfStudy);

				resultSet = prepareStmt.executeQuery();
				display(resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return prepareStmt;
	}

	public PreparedStatement preparedStatement(int course, String formOfStudy) {
		if (statement != null) {
			try {
				prepareStmt = connection
						.prepareStatement("SELECT * FROM student.info where Cours = ? and Form_of_study = ?");
				prepareStmt.setInt(1, course);
				prepareStmt.setString(2, formOfStudy);

				resultSet = prepareStmt.executeQuery();
				display(resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return prepareStmt;
	}

	private static StringBuffer display(ResultSet resultSet) throws SQLException {
		StringBuffer sb = new StringBuffer();
		while (resultSet.next()) {
			int num = resultSet.getInt("#");
			String pib = resultSet.getString("PIB");
			String faculty = resultSet.getString("Faculty");
			String speciality = resultSet.getString("Speciality");
			int course = resultSet.getInt("Cours");
			Date date = resultSet.getDate("Start_education");
			String formOfStudy = resultSet.getString("Form_of_study");
			// System.out.printf("%o\t %s\t %s\t %s\t %o\t %s\t %tF\n", num,
			// pib, faculty, speciality, course, formOfStudy, date);

			sb.append(num + "\t").append(pib + "\t").append(faculty + "\t").append(speciality + "\t")
					.append(course + "\t").append(formOfStudy + "\t").append(date + "\t");
		}
		System.out.println(sb);
		//JOptionPane.showMessageDialog(null, sb);
		return sb;
	}

}
