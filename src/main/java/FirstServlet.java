import somePackage.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

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
            ResultSet resultSet = statement.executeQuery("SELECT * from people");
            pw.println("ID\t\tNAME\t\tSURNAME\t\tAGE");
            pw.println();
            while (resultSet.next()){
                pw.print(resultSet.getString("id"));
                pw.print("\t\t");
                pw.print(resultSet.getString("name"));
                pw.print("\t\t");
                pw.print(resultSet.getString("surname" ));
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
