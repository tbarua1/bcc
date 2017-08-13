/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.operation;

import com.tarkesh.entity.BatchSchedule;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author tarkeshwar
 */
@MultipartConfig
@WebServlet(name = "uploadSchedule", urlPatterns = {"/uploadSchedule"})
public class uploadSchedule extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        System.out.println("i am getting Schedule");
        Part part = request.getPart("uploadFile");
        InputStream inputStream = part.getInputStream();
         File f=new File("/home/tarkeshwar/NetBeansProjects/bht/web/photo/data.csv");
          int read = 0;
        final byte[] bytes = new byte[1024];
OutputStream output = new FileOutputStream(f);
        while ((read = inputStream.read(bytes)) != -1) {
            output.write(bytes, 0, read);
        }
        BufferedReader br=new BufferedReader(new FileReader(f));
        String s = null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       
        BatchSchedule batch = new BatchSchedule();
        System.out.println("Line "+br.readLine());
        while((s=br.readLine())!=null){
            String[] split = s.split(",");
           // Date parse = sdf.parse(split[5]);
            System.out.println(split[5].substring(1, split[5].length()-1)+" Received Date - ");
            batch.setStatus("scheduled");
            Calendar c=Calendar.getInstance();
            c.setTime(sdf.parse(split[5].substring(1, split[5].length()-1)));
             batch.setBatchcode(split[2].substring(1, split[2].length()-1).replace(" ", "_"));
             batch.setDate(c);
          //  batch.setDate(c.setTime(sdf.parse(split[5].substring(1, split[5].length()-1))));
            batch.setFacebookURL(split[9].substring(1, split[9].length()-1).replace(" ", "_"));
            c.setTime(sdf.parse(split[16].substring(1, split[16].length()-1)));
            batch.setTill(c);
          //  batch.setTill(sdf.parse(split[16].substring(1, split[16].length()-1)));
            batch.setTrainer(split[18].substring(1, split[18].length()-1).replace(" ", "_"));
            batch.setUniversity(split[19].substring(1, split[19].length()-1).replace(" ", "_"));
            Operations.addBatchSchedule(batch);
        }
        //new UploadData().readFromFileTrainer("/home/tarkeshwar/EY/bht/consolidated/trainer.csv");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet uploadSchedule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet uploadSchedule at " + request.getContextPath() + "</h1>");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(uploadSchedule.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(uploadSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
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
