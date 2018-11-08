/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chuki
 */
public class chatServlet extends HttpServlet {

    List<Object> e = new ArrayList<>();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
          out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>chatServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>mensajes</h1>");
            
            out.println("<form name='loginForm' method='post' action='chatServlet'>");
            out.println("Mensaje<input type='text' name='message'/><br/>");

            out.println("<input type='submit' value='Send'/>");
            out.println("</form>");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        e.add(request.getParameter("message"));
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>chatServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>mensajes</h1>");
            
            out.println("<form name='loginForm' method='post' action='chatServlet'>");
            out.println("Mensaje<input type='text' name='message'/><br/>");

            out.println("<input type='submit' value='Send'/>");
            out.println("</form>");

            for (Object msj : e) {
                String mensaje = msj.toString();
                out.println(mensaje);
                out.println("<br>");
                out.println();
            }

            out.println("</body>");
            out.println("</html>");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
