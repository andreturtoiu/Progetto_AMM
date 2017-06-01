/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Gruppi;
import amm.nerdbook.Classi.GruppiFactory;
import amm.nerdbook.Classi.Post;
import amm.nerdbook.Classi.PostFactory;
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
public class Bacheca extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession  session = request.getSession(false);
        
        if(session != null && session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)){
            String paramUser = request.getParameter("user");
            int userId;
            int idGroup;
            String paramGroup = request.getParameter("group");
            
            if(paramGroup != null){
                idGroup = Integer.parseInt(paramGroup);
            }else{
                idGroup = -1;
            }
            int loggedUserID = (Integer)session.getAttribute("loggedId");
            UtentiRegistrati loggedUser = UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(loggedUserID);
            if(paramUser != null){
                userId = Integer.parseInt(paramUser);
            }else{
                userId = loggedUserID;
            }
 
            UtentiRegistrati user = UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(userId);
           
            if(user != null){
                List<Post> posts;
                if(idGroup != -1 ){
                    Gruppi gruppo = GruppiFactory.getInstance().getGruppiById(idGroup);
                    posts =PostFactory.getInstance().getPostListByGroup(gruppo);
                    request.setAttribute("gruppo", gruppo);
                    request.setAttribute("tipoBacheca","bachecaGruppo");
                    request.setAttribute("nomeDest",gruppo.getNome());
                }else{
                    posts =PostFactory.getInstance().getPostList(user);
                    request.setAttribute("user", user);     
                    request.setAttribute("tipoBacheca","bachecaUtente");
                    request.setAttribute("nomeDest",user.getNome());
                }
                request.setAttribute("posts", posts);
                List<UtentiRegistrati> amici = UtentiRegistratiFactory.getInstance().getListaAmiciByUser(loggedUserID);
                request.setAttribute("amici", amici);
                List<Gruppi> gruppi =GruppiFactory.getInstance().getGruppiByUser(loggedUser);
                request.setAttribute("gruppi", gruppi);
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                
            }else{
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }   
        }else{
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Errore: accesso negato</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Errore: accesso negato</h1>");
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
