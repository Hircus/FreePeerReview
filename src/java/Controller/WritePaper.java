/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

/**
 *
 * @author antonio
 */
//@WebServlet(name = "WritePaper", urlPatterns = {"/scriviArticolo.html"})
public class WritePaper extends HttpServlet {

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

        HttpSession session = request.getSession();

        Utente utente = (Utente) session.getAttribute("utente");
        List<String> categorie = CategorieFactory.getInstance().getCategorie();
        String head = null, title = null, immagine = null, data = null, testo = null;
        Articolo articolo = null;

        if (utente.getTipo() == false) {
            request.getRequestDispatcher("M1/error.jsp").forward(request, response);
        }

        if (request.getParameter("scriviArticolo") != null) {
            List<Articolo> articoli = null;

            head = "SCRIVI ARTICOLO";
        }
        if (request.getParameter("pid") != null) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            articolo = ArticoliFactory.getInstance().getArticoloId(pid);
            request.setAttribute("articolo", articolo);

            head = "MODIFICA ARTICOLO";
            title = articolo.getTitolo();
            immagine = articolo.getImmagine();
            data = articolo.getData();
            testo = articolo.getTesto();
        }

        if (request.getParameter("salva") != null) {
            String autore = request.getParameter("autori");
            if (AutoriFactory.getInstance().searchUtente(autore)) {
                head = "SCRIVI ARTICOLO";
                String titolo = request.getParameter("titolo");
                String foto = request.getParameter("immagine");
                String date = request.getParameter("data");
                String text = request.getParameter("testo");
                String[] cat = request.getParameterValues("cat");
                articolo = new Articolo();
                if (titolo != null && autore != null && foto != null && date != null && text != null) {

                    for (int i = 0; i < cat.length; i++) {
                        articolo.addCategoria(cat[i]);
                    }
                    articolo.setTitolo(titolo);
                    articolo.setImmagine(foto);
                    articolo.setDataByString(date);
                    articolo.setTesto(testo);
                    if(request.getParameter("pid") != null) 
                   ArticoliFactory.getInstance().insertArticolo(articolo, utente);
                }
            }
        }

        request.setAttribute("categorie", categorie);
        request.setAttribute("head", head);
        request.setAttribute("title", title);
        request.setAttribute("immagine", immagine);
        request.setAttribute("data", data);
        request.setAttribute("testo", testo);

        request.getRequestDispatcher("M1/scriviArticolo.jsp").forward(request, response);

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
