/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///comment

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author chuki
 */
public class loginChat extends HttpServlet {
    Connection conn;
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
        try {
            
            InitialContext initialcontext = new InitialContext();
              DataSource datasource;
              datasource = (DataSource) initialcontext.lookup("jdbc/swDatabase");
              Connection conn = datasource.getConnection();
              String posible_usuario = request.getParameter("username");
              String posible_password= request.getParameter("password");
              String query = "select * from tb_users where email ='"+ posible_usuario + "' and password ='" + posible_password+"';";
              Statement st;
              st = conn.createStatement();
              ResultSet rs = st.executeQuery(query);
              System.out.println("se ha ejecutado la query");
              if(rs.next()){
                  
              RequestDispatcher rd = getServletContext().getNamedDispatcher("chatServlet");
              rd.forward(request, response);
              }
              else{
                  RequestDispatcher rd = getServletContext().getNamedDispatcher("loginChat");
              rd.forward(request, response);

              }
        } catch (NamingException ex) {
            Logger.getLogger(loginChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginChat.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
            
          
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }


}
