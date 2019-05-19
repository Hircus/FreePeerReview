/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author antonio
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

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
        
        HttpSession session= request.getSession();
        
        if(request.getParameter("login")!=null){
            //l'utente ha premuto il tasto login
            String email= request.getParameter("email");
            String password= request.getParameter("password");
            
            Utente utente= AutoriFactory.getInstance().
                    getUtenteEmailPassword(password, email);
            
            if(utente !=null){
                session.setAttribute("utenteId", utente.getId());
            }
            
        }
        
        //qui l'utente ha loggato sicuramente e autoreID è inizializzato
        
        if(session.getAttribute("utenteId")!=null){
            int utenteId=(int) session.getAttribute("autoreId");
            
            Utente utente= AutoriFactory.getInstance().
                    getUtentebyID(utenteId);
            //passo alla jsp una variabile di nome autore, con un id riferito all'oggetto
            
            List<Articolo> articoli= ArticoliFactory.getInstance()
                    .getArticoliByAutore(utente);
            
            session.setAttribute("utente", utente);
            session.setAttribute("articoli", articoli);
            //carica una jsp
            request.getRequestDispatcher("articoli.html").forward(request, response);
        }else{ //sennò l'utente non è autenticato
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
