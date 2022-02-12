import somePackage.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        if (cart == null){
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);


        }
            session.setAttribute("cart", cart);



        getServletContext().getRequestDispatcher("/showCart.index.jsp").forward(request, response);

//        PrintWriter pw = response.getWriter();
//        pw.println("<html>");
//        pw.println("<h1>Your count is: " + + "</h1>");
//        pw.println("<h1>Privet, " + name + " " + surname + "</h1>");
//        pw.println("</html>");

//        response.sendRedirect("/index.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
