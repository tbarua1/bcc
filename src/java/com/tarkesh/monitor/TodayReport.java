/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.monitor;

import com.mysql.jdbc.Util;
import com.tarkesh.entity.BatchSchedule;
import com.tarkesh.operation.Operations;
import com.tarkesh.operation.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tarkeshwar
 */
@WebServlet(name = "TodayReport", urlPatterns = {"/TodayReport"})
public class TodayReport extends HttpServlet {

    private double workhour, start, end;

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
        List<BatchSchedule> todayScheduledBatches = Operations.todayScheduledBatches();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html><head><title>DAR Report</title> <link rel=\"stylesheet\" href=\"css/design.css\" type=\"text/css\"></head><body><h1>" + g.format(new Date()) + "</h1><table border='1'>");
            out.println("<tr><th>Sr.</th><th>TrainerName</th><th>Batch Code</th><th>Start Time</th><th>End Time</th><th>Total</th><th>University</th><th>Status</th><th>Action</th></tr>");
            int totalHours = 0, counter = 0;
            for (BatchSchedule b : todayScheduledBatches) {
                counter++;
                out.println("<tr><td>" + counter + "</td>");
                out.println("<td>" + b.getTrainer() + "</td>");
                out.println("<td>" + b.getBatchcode() + "</td>");
                out.println("<td>" + f.format(b.getDate().getTime()) + "</td>");
                out.println("<td>" + f.format(b.getTill().getTime()) + "</td>");
               

                workhour = b.getTill().getTimeInMillis() - b.getDate().getTimeInMillis();
                if (workhour < 0) {
                    workhour = -workhour;
                }
//                long seconds= workhour/1000;
//                long minute = workhour/1000*60;
                out.println("<td>" + workhour / 3600000 + "</td>");
                out.println("<td>" + b.getUniversity() + "</td>");
                out.println("<td>" + b.getStatus() + "</td>");
                 out.println("<td><a href='editSchedule.jsp?id="+b.getId()+"'>Edit</a></td></tr>");
                totalHours += workhour / 3600000;
            }

            out.println("</table><h1>Total Working Hours : " + totalHours + "</h1></body></html>");
        }
    }
    private SimpleDateFormat f = new SimpleDateFormat("HH:mm");
     private SimpleDateFormat g = new SimpleDateFormat("dd-MM-yyyy");

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
