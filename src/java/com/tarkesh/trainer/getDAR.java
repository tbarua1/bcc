/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.trainer;

import com.tarkesh.entity.BatchSchedule;
import com.tarkesh.operation.Operations;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abhishek.Sehgal
 */
@WebServlet(name = "getDAR", urlPatterns = {"/getDAR"})
public class getDAR extends HttpServlet {

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
        String trainerName = request.getParameter("trainer");
        String sday = request.getParameter("sday");
        String smonth = request.getParameter("smonth");
        String syear = request.getParameter("syear");
        String eday = request.getParameter("eday");
        String emonth = request.getParameter("emonth");
        String eyear = request.getParameter("eyear");

        List<BatchSchedule> batchSchedule = Operations.getBatchSchedule(trainerName,sday,smonth,syear,eday,emonth,eyear);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html><head><title>DAR Report</title> <link rel=\"stylesheet\" href=\"css/design.css\" type=\"text/css\"></head><body><h1>" + trainerName + "</h1><table border='1'>");
           out.println("<tr><th>Sr.</th><th>Batch Code</th><th>Start Time</th><th>End Time</th><th>Total</th><th>Status</th><th>University</th></tr>");
            
            int totalHours = 0,counter=0;
            for (BatchSchedule b : batchSchedule) {
                counter++;
                out.println("<tr><td>" +counter + "</td>");
                out.println("<td>" + b.getBatchcode() + "</td>");
                out.println("<td>" + f.format(b.getDate().getTime()) + "</td>");
                out.println("<td>" + f.format(b.getTill().getTime()) + "</td>");
                
                workhour = b.getTill().getTimeInMillis() - b.getDate().getTimeInMillis();
                 //                long seconds= workhour/1000;
//                long minute = workhour/1000*60;
                if (workhour < 0) {
                    workhour = -workhour;
                }
                out.println("<td>" + workhour / 3600000 + "</td>");
                out.println("<td>" + b.getStatus() + "</td>");
                out.println("<td>" + b.getUniversity() + "</td></tr>");

                totalHours += workhour / 3600000;
            }
            out.println("<td>" + totalHours + "</td>");
            out.println("</table></body></html>");

        }
    }private SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm");

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
