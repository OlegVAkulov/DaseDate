import somePackage.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "SetCookiesServlet", value = "/SetCookiesServlet")
public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        PrintWriter pw = response.getWriter();


        pw.println("<head>");
        pw.println("<body>");
        pw.println("<h3>Input new element</h3>");
        pw.println("<form>");
        pw.println("<strong>User Name</strong>:<input type=\"text\" name=\"name\"><br>");
        pw.println("<strong>User Surname</strong>:<input type=\"text\" name=\"surname\"><br>");
        pw.println("<strong>User Age</strong>:<input type=\"number\" name=\"age\"><br>");
        pw.println("<input type=\"submit\" value=\"INSERT\">");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</head>");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");

        Cookie cookie1 = new Cookie("name", name);
        Cookie cookie2 = new Cookie("surname", surname);
        Cookie cookie3 = new Cookie("age", age);
        cookie1.setMaxAge(24 * 60 * 60);
        cookie2.setMaxAge(24 * 60 * 60);
        cookie3.setMaxAge(24 * 60 * 60);

        HttpSession session = request.getSession();
        String name1 = (String) session.getAttribute("name");
        String surname1 = (String) session.getAttribute("surname");
        Integer age1 = (Integer) session.getAttribute("age");



        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        user.setName(name1);
        user.setSurname(surname1);
        user.setAge(age1);

        pw.println("<head>");
        pw.println("<h1>" +user.getName() + "  " + user.getSurname() + "  " + user.getAge() + " </h1>");

        pw.println("<a href=\"GetCookiesServlet\">Add to Base</a>");
        pw.println("</head>");



//        Cookie[] cookies = request.getCookies();
//        pw.println("<head>");
//        for (Cookie cookie : cookies) {
//            pw.println("<h1>" + cookie.getName() + "  " + cookie.getValue() + "</h1>");
//        }
//        pw.println("</head>");
//        pw.println("<a href=\"GetCookiesServlet\">Add to Base</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
