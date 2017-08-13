/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.trainer;

import com.tarkesh.entity.BatchCodes;
import com.tarkesh.entity.Trainer;
import com.tarkesh.operation.Operations;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "AddTrainer", urlPatterns = {"/AddTrainer"})
public class AddTrainer extends HttpServlet {

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
        System.out.println("i am at AddTrainer");
        response.setContentType("text/html;charset=UTF-8");
//         BufferedReader br = new BufferedReader(new FileReader("/home/tarkeshwar/Trainer.csv"));
//         String data="";
//            while ((data = br.readLine()) != null) {
//                 Trainer t=new Trainer();         
//          
//                String split[] = data.split(",");
//                t.setEmailid(split[2]);
//                t.setExperience(split[3]);
//               t.setMobile(split[4]);
//               t.setName(split[5]);
//               t.setNatianality(split[6]);
//               t.setPassword("1234567890");
//               t.setQualification(split[8]);
//              // t.setSkillset(split[9]);
//               t.setSkype(split[10]);
//               t.setUsername(split[2]);
//               t.setRegisteredDate(new Date()) ;
////               t.setUsertype(split[13]);
//               t.setWhatsapp("");
//                Operations.addTrainer(t);
//            }
        Trainer batchCodes = new Trainer();
        batchCodes.setEmailid(request.getParameter("email"));
        batchCodes.setExperience(request.getParameter("experience"));
        batchCodes.setMobile(request.getParameter("mobile"));
        batchCodes.setName(request.getParameter("name"));
        batchCodes.setNatianality(request.getParameter("nationality"));
        batchCodes.setPassword(request.getParameter("password"));
        //batchCodes.setPhoto(request.getParameter("scheduledDay"));
        batchCodes.setQualification(request.getParameter("qualification"));
        batchCodes.setSkillset(request.getParameter("skillset"));
        batchCodes.setSkype(request.getParameter("skypeid"));
        batchCodes.setWhatsapp(request.getParameter("whatsapp"));
            
//             batchCodes.setName(request.getParameter("scheduledDay"));
//              batchCodes.setName(request.getParameter("scheduledDay"));

        
        Part part = request.getPart("photo");
        String fileName = getFileName(part);
            batchCodes.setPhoto(fileName);

        Operations.addTrainer(batchCodes);
        InputStream inputStream = part.getInputStream();
        File f = new File("/home/tarkeshwar/NetBeansProjects/bht/web/photo/" + fileName);
        //OutputStream out = null;
        InputStream filecontent = null;
        OutputStream out = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(f);

            filecontent = part.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            writer.println("Your file " + fileName + " Uploaded Successfully");
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
            System.out.println("Yes We have Added Data");
            response.sendRedirect("addTrainer.jsp");
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

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        // LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
