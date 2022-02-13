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


        PrintWriter pw = response.getWriter();
        Scanner scanner = new Scanner(System.in);

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
            pw.println("INPUT NAME:");
            String title = scanner.nextLine();
            pw.println("INPUT AGE:");
            int pages = scanner.nextInt();
            pw.println(title + "\t\t" + pages);


            pw.println("NAME\t\tSURNAME\t\tAGE");
            pw.println();
            while (resultSet.next()){
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
        response.sendRedirect("/showCart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
