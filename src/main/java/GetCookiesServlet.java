import logic.User;
import logic.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet(name = "GetCookiesServlet", value = "/GetCookiesServlet")
public class GetCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDAO;

    public void init() {
        userDAO = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        for (int i = 0; i < listUser.size(); i++) {
            pw.println(listUser.get(i).getName() + " " + listUser.get(i).getSurname() + " " + listUser.get(i).getAge());
        }

//            RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//            dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
