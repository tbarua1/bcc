/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.operation;

import com.tarkesh.entity.BatchSchedule;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abhishek.Sehgal
 */
@WebServlet(name = "AddScheduleWeb", urlPatterns = {"/AddScheduleWeb"})
public class AddScheduleWeb extends HttpServlet {

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
        String university = request.getParameter("university");
        String trainer = request.getParameter("trainer");
        String batchcode = request.getParameter("batchcode");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        //String year = request.getParameter("year");
        String starthour = request.getParameter("starthour");
        String startminute = request.getParameter("startminute");
        String endhour = request.getParameter("endhour");
        String endminute = request.getParameter("endminute");
        System.out.println("University" + university);
        System.out.println("trainer" + trainer);
        System.out.println("Batch Code" + batchcode);
        System.out.println("day" + day);
        System.out.println("month" + month);
        System.out.println("Start Hour" + starthour);
        System.out.println("start Minute" + startminute);
        System.out.println("end Hour" + endhour);
        System.out.println("endMinute" + endminute);
        String schedule[] = new String[16];
        BatchSchedule batch=null;
        for (int i = 0; i < schedule.length; i++) {
            if (request.getParameter("day"+ i) != null) {
               starthour= request.getParameter("sh"+i);
               startminute= request.getParameter("sm"+i);
                endhour=request.getParameter("eh"+i);
                endminute=request.getParameter("em"+i);
                System.out.println(starthour+" "+startminute+" "+endhour+" "+endminute);
                batch = new BatchSchedule();
                batch.setBatchcode(batchcode);
                batch.setDate(new Utility().getCalender(day, month, starthour, startminute, request.getParameter("day" + i)));
                batch.setTill(new Utility().getCalender(day, month, endhour, endminute, request.getParameter("day" + i )));
                batch.setStatus("scheduled");
                batch.setTrainer(trainer.replace(" ", "_"));
                batch.setUniversity(university.replace(" ", "_"));
Operations.addBatchSchedule(batch);
                System.out.println("done");
            }
            //schedule[i]=;
        }
        for (String i : schedule) {
            System.out.println(i + "");
        }
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("addBatchSchedule.jsp");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddScheduleWeb</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AddScheduleWeb at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
