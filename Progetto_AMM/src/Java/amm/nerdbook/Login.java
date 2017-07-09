/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.GruppiFactory;
import amm.nerdbook.Classi.PostFactory;
import amm.nerdbook.Classi.UtentiRegistratiFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andreea
 */

@WebServlet(loadOnStartup = 0)
public class Login extends HttpServlet {
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
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
        response.setContentType("text/html;charset=UTF-8");//Apertura della sessione
        HttpSession session = request.getSession();
        
        //Richiesta di logout
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        //Utente loggato
        if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) {
            int userId = (Integer)session.getAttribute("loggedId");
            if(UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(userId).completo())
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                  else 
                     request.getRequestDispatcher("Profilo").forward(request, response);
            return;
        
        //Se l'utente non è loggato.
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("pswd");
        
            if (username != null && password != null){
                int loggedId = UtentiRegistratiFactory.getInstance().getIdByUserAndPassword(username, password);

                if(loggedId!=-1){
                    session.setAttribute("loggedIn", true); //imposta che sia loggato
                    session.setAttribute("loggedId", loggedId); //imposta chi è loggato
                    session.setAttribute("utenteLoggato", UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(loggedId));
                    
                    
                if(UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(loggedId).completo())
                        request.getRequestDispatcher("Bacheca").forward(request, response);
                      else 
                         request.getRequestDispatcher("Profilo").forward(request, response);
                return;
                
                } else { //Se l'utente che cerca di loggare non è presente
                    
                    //ritorno al form del login informandolo che i dati non sono validi
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
        
    }
    
    @Override
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        UtentiRegistratiFactory.getInstance().setConnectionString(dbConnection);
        GruppiFactory.getInstance().setConnectionString(dbConnection);
        PostFactory.getInstance().setConnectionString(dbConnection);
   
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