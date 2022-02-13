import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "GetCookiesServlet", value = "/GetCookiesServlet")
public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
//        Cookie[] cookies = request.getCookies();
//        String name = String.valueOf(cookies[0]);
//        String surname = String.valueOf(cookies[1]);
//        int age = Integer.parseInt(String.valueOf(cookies[2]));
        pw.println("<head>");
//        pw.println("cookies length: " + cookies.length);


//        pw.println("<h1>"+ user.toString +"</h1>");

        pw.println("</head>");
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
            statement.executeQuery("INSERT into people(name, surname,age) VALUES (name, surname, age)");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        HttpSession session = request.getSession();
//        String name = (String) session.getAttribute("name");
//        String surname = (String) session.getAttribute("surname");
//        Integer age = (Integer) session.getAttribute("age");


//
//        pw.println("<head>");
//        pw.println("<h1>" + name + "  " + surname + " " + age + "</h1>");
//        pw.println("<head>");

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
//            statement.executeQuery("INSERT into people(name, surname,age) VALUES (name, surname, age)");
            ResultSet resultSet = statement.executeQuery("SELECT * from people");
            pw.println("ID\tNAME\t\tSURNAME\t\tAGE");
            pw.println();
            while (resultSet.next()) {
                pw.print(resultSet.getString("id"));
                pw.print("\t");
                pw.print(resultSet.getString("name"));
                pw.print("\t\t");
                pw.print(resultSet.getString("surname"));
                pw.print("\t\t");
                pw.println(resultSet.getString("age"));
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
