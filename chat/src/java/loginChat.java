/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///comment

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chuki
 */
public class loginChat extends HttpServlet {

    String usuario_valido = "benzo3";
    String contrasena_valido = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        PrintWriter out;
        out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form name='loginForm' method='post' action='loginChat'>");
        out.println("Username: <input type=\"text\" name=\"username\"/><br/>");
        out.println("Password: <input type=\"password\" name=\"password\"/><br/> ");

        out.println("<input type=\"submit\" value=\"Login\"/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("username").equals(usuario_valido) && request.getParameter("password").equals(contrasena_valido)) {
            response.sendRedirect("http://localhost:8080/chat/chatServlet");
        } else {
            response.sendRedirect("http://localhost:8080/chat/loginChat");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
