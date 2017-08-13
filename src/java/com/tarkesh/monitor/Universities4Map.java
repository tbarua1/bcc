/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.monitor;

import com.tarkesh.entity.BatchSchedule;
import com.tarkesh.entity.University;
import com.tarkesh.operation.Operations;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author tarkeshwar
 */
@WebServlet(name = "Universities4Map", urlPatterns = {"/Universities4Map"})
public class Universities4Map extends HttpServlet {

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
            throws ServletException, IOException, ParseException, ParseException {
        System.out.println("i am from monitor Universities4Map");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(Operations.getAllUniversities4Map3());
//            List<BatchSchedule> allUniversities4Map2 = Operations.getAllUniversities4Map2();
//            List<University> list1 = new ArrayList<>();
//            int i = 0;
////             SessionFactory sessionFactory = Operations.getsessionFactory();
////                Session openSession = sessionFactory.openSession();
////                Transaction beginTransaction = openSession.beginTransaction();
//            allUniversities4Map2.forEach((b) -> {
//                out.println(b);
//            });
        }
//       for (BatchSchedule b:allUniversities4Map2) {
//           i++;
//        
//            System.out.println("Record No "+i); 
//            System.out.println(b.getId()+" Status "+b.getStatus());
//                Criteria createCriteria = openSession.createCriteria(University.class);
//            String replace = b.getUniversity().replace("_", " ");
//            System.out.println("Looking for "+replace);
//            createCriteria.add(Restrictions.eq("name", replace));
//            System.out.println(replace+" Record Retrived for "+b.getUniversity());
//            
//              List<University> list2 = createCriteria.list();
//              University get = list2.get(0);
//              get.setDate(b.getDate());
//              get.setStatus(b.getStatus());
//            boolean add = list1.add(get);
//            System.out.println("Status "+add);
//            if(i%20==0){
//              System.out.println("Cleaning ");openSession.flush();openSession.clear();}
//            
//        }beginTransaction.commit();
//            openSession.close();
//         System.out.println("out of for loop" );
//            
//             out.println(allUniversities4Map2.size());
//           
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Universities4Map.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Universities4Map.class.getName()).log(Level.SEVERE, null, ex);
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
