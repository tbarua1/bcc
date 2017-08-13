/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.controller;

import com.sun.corba.se.spi.orb.Operation;
import com.tarkesh.entity.BatchCodes;
import com.tarkesh.entity.BatchSchedule;
import com.tarkesh.operation.Operations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tarkeshwar
 */
@WebServlet(name = "BatchScheduleUpdate", urlPatterns = {"/BatchScheduleUpdate"})
public class BatchScheduleUpdate extends HttpServlet {

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
        String trainer = request.getParameter("trainer");
        String status = request.getParameter("status");
        String university = request.getParameter("university");
        int day = Integer.parseInt(request.getParameter("day"));
        int month = Integer.parseInt(request.getParameter("month"));
        int year = Integer.parseInt(request.getParameter("year"));
        
         int starthour = Integer.parseInt(request.getParameter("starthour"));
        int startminute = Integer.parseInt(request.getParameter("startminute"));
        int endhour = Integer.parseInt(request.getParameter("endhour"));
         int endminute = Integer.parseInt(request.getParameter("endminute"));
         
         Calendar cstart,cend;
        cstart=cend=Calendar.getInstance();
        cstart.set(Calendar.DAY_OF_MONTH,day);
        cstart.set(Calendar.MONTH,month);
        cstart.set(Calendar.YEAR,year);
        cstart.set(Calendar.HOUR_OF_DAY,starthour);
        cstart.set(Calendar.MINUTE,startminute);
          cend.set(Calendar.DAY_OF_MONTH,day);
        cend.set(Calendar.MONTH,month);
        cend.set(Calendar.YEAR,year);
        cend.set(Calendar.HOUR_OF_DAY,endhour);
        cend.set(Calendar.MINUTE,endminute);
        
        BatchSchedule batchCodes=new  BatchSchedule();
        batchCodes.setId(id);
        batchCodes.setBatchcode(batchCode);
        batchCodes.setTrainer(trainer);
        batchCodes.setStatus(status);
        batchCodes.setUniversity(university);
        
        batchCodes.setDate(cstart);
        batchCodes.setTill(cend);
        Operations.updateSchedule(batchCodes);
RequestDispatcher view = request.getRequestDispatcher("/TodayReport");
        view.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BatchScheduleUpdate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BatchScheduleUpdate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
