/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.progetto;

import amm.progetto.Classi.Group;
import amm.progetto.Classi.GroupFactory;
import amm.progetto.Classi.Post;
import amm.progetto.Classi.PostFactory;
import amm.progetto.Classi.User;
import amm.progetto.Classi.UserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martina
 */
@WebServlet(urlPatterns = {"/bacheca.html"})

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
        HttpSession session = request.getSession(false);
        
        //se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true
        if(session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true)){
            //si procura l'utente
            String utente = request.getParameter("id");
            int utenteID;
            if(utente!=null){
                utenteID = Integer.parseInt(utente);
            } else{
                Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                utenteID = loggedUserID;
            }
      
            User user = UserFactory.getInstance().getUserById(utenteID);
            if (user!=null){ //se l'utente esiste 
                //fa la barra laterale e i post
                request.setAttribute("user",user);
                ArrayList<User> utenti = UserFactory.getInstance().getListaUtenti();
                request.setAttribute("utenti",utenti);
                ArrayList<Post> posts = PostFactory.getInstance().getPostById_destinatario(utenteID);
                request.setAttribute("posts",posts);
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                
            }
            
      
            
        }
        else{
                //response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                request.setAttribute("nonAutenticato", true);
                request.setAttribute("logout", true);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
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
