import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "AddPetrIvanovServlet", value = "/AddPetrIvanovServlet")
public class AddPetrIvanovServlet extends HttpServlet {
    String name;
    String surname;
    int age;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        name = "Petr";
        surname = "Ivanov";
        age = 1986;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.0.32:5432/test_db",
                    "postgres", "123qwerty321");
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT into people(name, surname,age) VALUES (name , surname, age)");

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
