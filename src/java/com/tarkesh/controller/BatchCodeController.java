/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.controller;

import com.tarkesh.dao.BatchCodedao;
import com.tarkesh.daoImp.BatchCodeImp;
import com.tarkesh.entity.BatchCodes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abhishek.Sehgal
 */
@WebServlet(name = "BatchCodeController", urlPatterns = {"/BatchCodeController"})
public class BatchCodeController extends HttpServlet {
     private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/editBatchCode.jsp";
    private static final String LIST_USER = "/addBatchCode.jsp";
    private final BatchCodedao dao;
    public BatchCodeController() {
        super();
        dao=new BatchCodeImp();
    }

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
       Long id = Long.parseLong(request.getParameter("id"));
        String batchCode = request.getParameter("batchCode");
        String facebookGroup = request.getParameter("facebookGroup");
        String scheduleDay = request.getParameter("scheduledDay");
        String content = request.getParameter("content");
        BatchCodes batchCodes=new BatchCodes();
        batchCodes.setBatchCode(batchCode);
        batchCodes.setContent(content);
        batchCodes.setFacebookGroup(facebookGroup);
        batchCodes.setId(id);
        batchCodes.setScheduledDay(scheduleDay);
        
dao.editRecord(batchCodes);
//        if (action.equalsIgnoreCase("delete")){
//            long id = Long.parseLong(request.getParameter("id"));
//            dao.deleteRecord(id);
//            forward = LIST_USER;
//            request.setAttribute("all", dao.getAll());    
//        } else if (action.equalsIgnoreCase("edit")){
//            forward = INSERT_OR_EDIT;
//           long id = Long.parseLong(request.getParameter("userId"));
//             BatchCodes record = dao.getRecord(id);
//            request.setAttribute("user", record);
//        } else if (action.equalsIgnoreCase("listUser")){
//            forward = LIST_USER;
//            request.setAttribute("users", dao.getAll());
//        } else {
//            forward = INSERT_OR_EDIT;
//        }.jsp

        RequestDispatcher view = request.getRequestDispatcher("/addBatchCode.jsp");
        view.forward(request, response);
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
