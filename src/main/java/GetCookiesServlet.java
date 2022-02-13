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
        PrintWriter pw = response.getWriter();
        pw.println("<head>");
        for (Cookie cookie : cookies) {
            pw.println("<h1>" + cookie.getName() + "  " + cookie.getValue() + "</h1>");
        }
        pw.println("</head>");


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
