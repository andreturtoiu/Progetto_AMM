/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Gruppi;
import amm.nerdbook.Classi.GruppiFactory;
import amm.nerdbook.Classi.UtentiRegistrati;
import amm.nerdbook.Classi.UtentiRegistratiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andreea
 */
public class Profilo extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession  session = request.getSession(false);
        UtentiRegistrati user;
        if(session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)){
            int loggedId = (Integer)session.getAttribute("loggedId");

        //Cancellazione account
        if(request.getParameter("deleteAccount")!=null){
            UtentiRegistratiFactory.getInstance().deleteUser(loggedId);
            request.getRequestDispatcher("login.html?logout=true").forward(request,response);
            return;
        }

        //Update profilo
        if(request.getParameter("update")!=null){
            user = new UtentiRegistrati();
            user.setNome(request.getParameter("firstname"));
            user.setCognome(request.getParameter("lastname"));
            user.setPassword(request.getParameter("psw"));
            user.setUrlFotoProfilo(request.getParameter("profilePic"));         
            user.setEmail(request.getParameter("email"));
            user.setFraseDescrizione(request.getParameter("textPost"));
            user.setDataNascita(request.getParameter("bDay"));
            user.setId(loggedId);
            UtentiRegistratiFactory.getInstance().updateProfilo(user);
        }

        user = UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(loggedId);
        request.setAttribute("loggedUser", user);
        List<UtentiRegistrati> amici =UtentiRegistratiFactory.getInstance().getListaAmiciByUser(loggedId);
        request.setAttribute("amici", amici);
        List<Gruppi> gruppi =GruppiFactory.getInstance().getGruppiByUser(user);
        request.setAttribute("gruppi", gruppi);
        request.getRequestDispatcher("profilo.jsp").forward(request, response);
            
        }else{
             try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Errore : accesso negato</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Errore : accesso negato</h1>");
                out.println("</body>");
                out.println("</html>");
             }
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
