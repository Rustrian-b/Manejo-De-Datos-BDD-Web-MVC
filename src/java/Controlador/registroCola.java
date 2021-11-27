/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.registroDeUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author H4HG
 */
@WebServlet(name = "registroCola", urlPatterns = {"/registroCola"})
public class registroCola extends HttpServlet {

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
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registroCola</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registroCola at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
            throws ServletException, IOException {
        processRequest(request, response);
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
            throws ServletException, IOException 
            {
                response.setContentType("text/html;charset=UTF-8");
                
                String vCarnet = request.getParameter("ctCarnet");
                String vContinuar = "./main.html";
                String vRegresar = "./colaInscripcion.jsp";
                int vResultado = 0;
                
                registroDeUsuarios r = new registroDeUsuarios();                
                
                vResultado = r.Cola(vCarnet);
                                      
                if(vResultado == 1)
                {

                    try (PrintWriter out = response.getWriter()) 
                    {                
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<link rel=\"stylesheet\" href=\"./css/styleRegistroUsuarios.css\">");
                        out.println("<title>Servlet registroUsuarios</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Se ha añadido al estudiante con numero de carnet: " + vCarnet + " a la cola de inscripción </h1>");
                        out.println("<h2><a href="+vContinuar+">Click para continuar</a></h2></br>");
                        out.println("</body>");
                        out.println("</html>");
                    }  
                }
                else
                {
                    try (PrintWriter out = response.getWriter()) 
                    {                
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet registroUsuarios</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Registro de usuario fallido, reintente nuevamente estimado " + "" + "</h1>");
                        out.println("<h2><a href="+ vRegresar+">Click para reintentar</a></h2></br>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
                                    
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
