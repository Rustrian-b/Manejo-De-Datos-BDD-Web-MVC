package Controlador;

import Modelo.ManejoBDD;
import java.io.IOException;
import java.io.PrintWriter;
/*import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */        
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
               
        String vUser = request.getParameter("user");
        String vPassword = request.getParameter("pasword");
        int vResultado = 0;
        String acceso = "./main.html";
        String acceso1 = "./index.html";        
        
        ManejoBDD m = new ManejoBDD();
        
        vResultado = m.loggin(vUser, vPassword);
        
        switch (vResultado) 
        {
            case 1:
                try (PrintWriter out = response.getWriter())
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link rel=\"stylesheet\" href=\"./css/styleLogin.css\">");
                    out.println("<title>Bienvenido</title");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1 class="+"titulo"+">Loggin exitoso, bienvenido " + vUser + "</h1>");
                    out.println("<a href="+acceso+" class="+"acceso"+">Click para continuar</a> </br>");
                    out.println("</body>");
                    out.println("</html>");
                    
                    //RequestDispatcher vista = request.getRequestDispatcher(acceso);
                    //vista.forward(request, response);
                }   break;
            case 0:
                try (PrintWriter out = response.getWriter())
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link rel=\"stylesheet\" href=\"./css/styleLoginFallido.css\">");
                    out.println("<title>ERROR!!!</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Ingreso fallido</h1>");
                    out.println("<h2>Verifique su usuario y/o contraseña</h2>");
                    out.println("<a href="+acceso1+">Click para reintentar</a> </br>");
                    out.println("</body>");
                    out.println("</html>");
                }   break;
            default:
                try (PrintWriter out = response.getWriter())
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Undifined error</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Verifique todo xd</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }   break;
        }
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        /*response.setContentType("text/html;charset=UTF-8");
        
        String vUser = request.getParameter("user");
        String vPassword = request.getParameter("pasword");
        int vResultado = 0;
        String acceso = "./Paginas/main.html";
        
        ManejoBDD m = new ManejoBDD();
        
        vResultado = m.loggin(vUser, vPassword);        
        
        switch (vResultado) {
            case 1:
                try (PrintWriter out = response.getWriter())
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Bienvenido</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Loggin exitoso, bienvenido " + vUser + "</h1>");
                    out.println("<a href="+"./Paginas/main.html"+">Click para continuar</a> </br>");
                    out.println("</body>");
                    out.println("</html>");
                    
                    //RequestDispatcher vista = request.getRequestDispatcher(acceso);
                    //vista.forward(request, response);
                }   break;
            case 0:
                try (PrintWriter out = response.getWriter())
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet login</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Verifique sus credenciales</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }   break;
            default:
                try (PrintWriter out = response.getWriter())
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet login</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Verifique todo xd</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }   break;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);*/
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
