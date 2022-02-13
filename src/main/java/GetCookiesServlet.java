import somePackage.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

@WebServlet(name = "GetCookiesServlet", value = "/GetCookiesServlet")
public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie name = cookies[0];
        Cookie surname = cookies[1];
        Cookie age = cookies[2];
        HttpSession session = request.getSession();
//        String name = (String) session.getAttribute("name");
//        String surname = (String) session.getAttribute("surname");
//        Integer age = (Integer) session.getAttribute("age");


        PrintWriter pw = response.getWriter();
        pw.println("<head>");
        pw.println("<h1>" + name + "  " + surname + " " + age + "</h1>");
        pw.println("<head>");

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
//        pw.println("<head>");
//        for (Cookie cookie : cookies) {
//            pw.println("<h1>" + cookie.getName() + "  " + cookie.getValue() + "</h1>");
//        }
//        pw.println("</head>");
//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
//
//
//        RequestDispatcher dispatcher =  request.getRequestDispatcher("/showCart.jsp");
//        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
