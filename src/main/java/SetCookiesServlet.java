import logic.User;
import logic.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "SetCookiesServlet", value = "/SetCookiesServlet")
public class SetCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDAO;
    private HttpServletRequest request;

    public void init() {
        userDAO = new UserDao();
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        this.request = request;
//        doGet(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        User book = new User(name, surname, age);
        try {
            userDAO.updateUser(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("list");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
