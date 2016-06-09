/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.ModelCategoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ws.wsGestaodeGastos;

/**
 *
 * @author danilo
 */
public class ServletCategoria extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");
        wsGestaodeGastos ws = new wsGestaodeGastos();
        int excluirCategoria = Integer.parseInt(request.getParameter("excluircategoria").replaceAll("/", ""));
        if (excluirCategoria > 0) {

            ws.deleteCategoria(excluirCategoria);
            request.setAttribute("sucesso", "Operação realizada com sucesso!");
            request.getRequestDispatcher("categorias.jsp").forward(request, response);

        }
        wsGestaodeGastos ws1 = new wsGestaodeGastos();
        String novaCategoria = request.getParameter("novacategoria");
        if ("".equals(novaCategoria)) {
        } else {

            ModelCategoria c = new ModelCategoria();
            c.setNomeCategoria(novaCategoria);
            ws1.saveCategoria(c);
            request.setAttribute("sucesso", "Operação realizada com sucesso!");
            request.getRequestDispatcher("categorias.jsp").forward(request, response);
        }
        wsGestaodeGastos ws2 = new wsGestaodeGastos();
        int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
        String categoriaEditada = request.getParameter("categoriaeditada");
        if (idcategoria > 0) {

            ModelCategoria c = new ModelCategoria();
            c.setIdCategoria(idcategoria);
            c.setNomeCategoria(categoriaEditada);
            ws2.atualizaCategoria(c);
            request.setAttribute("sucesso", "Operação realizada com sucesso!");
            request.getRequestDispatcher("categorias.jsp").forward(request, response);

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
