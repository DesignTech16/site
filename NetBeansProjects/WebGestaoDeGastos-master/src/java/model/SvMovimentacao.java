/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import ws.wsCategoria;

/**
 *
 * @author danilo
 */
public class SvMovimentacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, DatatypeConfigurationException, Exception {

        Movimentacao m = new Movimentacao();
        m.setTipo(request.getParameter("tipo"));
        m.setDescricao(request.getParameter("descricao"));

        m.setData(formataData(request.getParameter("data")));
        m.setValor(Float.parseFloat(request.getParameter("valor")));
        m.setNomeCategoria(request.getParameter("categoria"));
        String repeticao = request.getParameter("repeticao");
        if (m.getValor() < 0) {
            m.setValor(-(m.getValor()));
        }
        if (repeticao == "eventual") {
            wsCategoria ws = new wsCategoria();

            ws.salvarMovimentacao(m);
        }

    }
    
     public static Date formataData(String data) throws Exception {   
        if (data == null || data.equals(""))  
            return null;  

        Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            date = (java.util.Date)formatter.parse(data);  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    }


    private static Date converteData(String mydata) {
        Date data = null;
        try {
            DateFormat dtOutput = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            data = dtOutput.parse(mydata);
        } catch (ParseException e) {  
        e.printStackTrace();  
    }
            return data;
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (ParseException | DatatypeConfigurationException ex) {
                Logger.getLogger(SvMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(SvMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (ParseException | DatatypeConfigurationException ex) {
                Logger.getLogger(SvMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(SvMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
