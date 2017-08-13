package com.tarkesh.operation;

import com.tarkesh.entity.BatchCodes;
import com.tarkesh.entity.BatchSchedule;
import com.tarkesh.entity.CompletedTraining;
import com.tarkesh.entity.tracker;
import com.tarkesh.entity.University;
import com.tarkesh.entity.GetSetFinalAssessment;
import com.tarkesh.entity.GetSetPlacementGraph;
import com.tarkesh.entity.GetSetTopup;
import com.tarkesh.entity.Trainer;
import com.tarkesh.entity.Version;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Operations {

    private static Number numbers;
    private static SessionFactory sessionFactory;
    private static Session openSession;
    private static Transaction beginTransaction;
    private static ObjectMapper objectMapper;

    public static List<BatchSchedule> getBatchSchedule(String trainerName) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.addOrder(Order.desc("trainer"));
        createCriteria.add(Restrictions.eq("trainer", trainerName.replace(" ", "_")));
        List<BatchSchedule> list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }
    public static BatchSchedule getBatchScheduleById(Long id) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.add(Restrictions.eq("id", id));
        List<BatchSchedule> list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        return list.get(0);
    }

    public static List<BatchSchedule> getBatchSchedule(String trainerName, String sday, String smonth, String syear, String eday, String emonth, String eyear) {
        Calendar from = Calendar.getInstance();
        from.set(Calendar.DAY_OF_MONTH, Integer.parseInt(sday));
        from.set(Calendar.MONTH, Integer.parseInt(smonth));
        from.set(Calendar.YEAR, Integer.parseInt(syear));
        from.set(Calendar.HOUR_OF_DAY, 0);
        from.set(Calendar.MINUTE, 0);
        from.set(Calendar.SECOND, 0);
        Calendar to = Calendar.getInstance();
        to.set(Calendar.DAY_OF_MONTH, Integer.parseInt(eday));
        to.set(Calendar.MONTH, Integer.parseInt(emonth));
        to.set(Calendar.YEAR, Integer.parseInt(eyear));
        to.set(Calendar.HOUR_OF_DAY, 23);
        to.set(Calendar.MINUTE, 59);
        to.set(Calendar.SECOND, 59);
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
        // createCriteria.add(Restrictions.)
        createCriteria.addOrder(Order.asc("date"));
        createCriteria.add(Restrictions.eq("trainer", trainerName.replace(" ", "_")));
        List<BatchSchedule> temp = createCriteria.list();
        List<BatchSchedule> list = new ArrayList<>();
        for (BatchSchedule b : temp) {
            if (b.getDate().after(from) && b.getTill().before(to)) {
                list.add(b);
            }
        }
        beginTransaction.commit();
        openSession.close();
        return list;
    }
public static String getAllUniversities4Map1() throws IOException, ParseException {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 8);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 19);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        System.out.println(calendar1.getTime()+" "+calendar2.getTime());
        sessionFactory = Operations.getsessionFactory();
        openSession = sessionFactory.openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria, createCriteria1;
        createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.add(Restrictions.ge("date", calendar1));
        createCriteria.add(Restrictions.le("date", calendar2));
        List<BatchSchedule> list = createCriteria.list();
        List<University> list1 = new ArrayList<>();
        int i = 0;
        for (BatchSchedule b : list) {
            i++;
            System.out.println("Record No " + i);
            System.out.println("" + b);
            createCriteria1 = openSession.createCriteria(University.class);
            String replace = b.getUniversity().replace("_", " ");
            System.out.println("Looking for " + replace);
            createCriteria1.add(Restrictions.eq("name", replace));
            System.out.println(replace + " Record Retrived for " + b.getUniversity());
            University get = (University)createCriteria1.list().get(0);
            //boolean add = ;
            get.setDate(b.getDate());
             get.setStatus(b.getStatus());
            list1.add( get);
           // System.out.println("Status " + add);
        }
        System.out.println("out of for loop" + list.size());
       beginTransaction.commit();
        //openSession.close();
        return getObjectMapper().writeValueAsString(list1);
    }
    public static List<BatchSchedule> getAllUniversities4Map2() throws IOException {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
         List<BatchSchedule> list=new ArrayList<>();
        try {
            sessionFactory = Operations.getsessionFactory();
            if (sessionFactory == null) {
                System.out.println("Session Factory Closed or null");
            }
            openSession = sessionFactory.openSession();
            if (openSession == null) {
                System.out.println("Current Session null");
            }
            beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
            createCriteria.add(Restrictions.ge("date", calendar1));
            createCriteria.add(Restrictions.le("date", calendar2));
            list = createCriteria.list();
        
           
           
        } catch (HibernateException e) {
            System.out.println("Error " + e.getMessage());
            beginTransaction.commit();
            openSession.close();
        } 
        beginTransaction.commit();
        openSession.flush();
        openSession.close();
//      int i=0;
//       for (BatchSchedule b:list) {
//           i++;
//            System.out.println("Record No "+i); 
//            System.out.println(b.getId()+" Status "+b.getStatus());
//           sessionFactory = Operations.getsessionFactory();
//       openSession = sessionFactory.openSession();
//       openSession.beginTransaction();
//            createCriteria = openSession.createCriteria(University.class);
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
//            beginTransaction.commit();
//            openSession.close();
//        }
        // System.out.println("out of for loop" + list.size());
 System.out.println("Record Received " + list.size());
        return list;//getObjectMapper().writeValueAsString(list1);
    }

    public static String getAllUniversities4Map3() throws IOException {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        sessionFactory = Operations.getsessionFactory();
        openSession = sessionFactory.openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria, createCriteria1;
        createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.add(Restrictions.ge("date", calendar1));
        createCriteria.add(Restrictions.le("date", calendar2));
        List<BatchSchedule> list = createCriteria.list();
        List<University> list1 = new ArrayList<>();
        int i = 0;
        for (BatchSchedule d : list) {
            i++;
            System.out.println("Record No " + i);
             createCriteria1 = openSession.createCriteria(University.class);
            String replace = d.getUniversity().replace("_", " ");
            System.out.println("Looking for " + replace);
            createCriteria1.add(Restrictions.eq("name", replace));
            System.out.println(replace + " Record Retrived for " + d.getUniversity());
               University get = (University)createCriteria1.list().get(0);
            //boolean add = ;
            System.out.println(get.getStatus()+" university " + d.getStatus());
            get.setDate(d.getDate());
             get.setStatus(d.getStatus());
             System.out.println(get.getId()+" After Change Status "+get.getStatus());
            list1.add( get);
//            boolean add = list1.add((University) createCriteria1.list().get(0));
//            System.out.println("Status " + add);
        }
        System.out.println("out of for loop" + list.size());
        beginTransaction.commit();
        //openSession.close();
        return getObjectMapper().writeValueAsString(list1);
    }

    public static String getAllUniversities4Map4() throws IOException {
         Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        sessionFactory = Operations.getsessionFactory();
        openSession = sessionFactory.openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria, createCriteria1;
        createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.add(Restrictions.ge("date", calendar1));
        createCriteria.add(Restrictions.le("date", calendar2));
        List<BatchSchedule> list = createCriteria.list();
        List<University> list1 = new ArrayList<>();
        int i = 0;
        for (BatchSchedule b : list) {
            i++;
            System.out.println("Record No " + i);
            System.out.println("" + b);
            createCriteria1 = openSession.createCriteria(University.class);
            String replace = b.getUniversity().replace("_", " ");
            System.out.println("Looking for " + replace);
            createCriteria1.add(Restrictions.eq("name", replace));
            System.out.println(replace + " Record Retrived for " + b.getUniversity());
              University get = (University)createCriteria1.list().get(0);
            //boolean add = ;
            get.setDate(b.getDate());
             get.setStatus(b.getStatus());
            list1.add( get);
        }
        System.out.println("out of for loop" + list.size());
        //beginTransaction.commit();
        //openSession.close();
        return getObjectMapper().writeValueAsString(list1); }

    public static List<BatchCodes> getAllBatchCodeList() {
       openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchCodes.class);
        List<BatchCodes> list = createCriteria.list();
        beginTransaction.commit();
        //openSession.close();
        return list; }

    public static boolean deleteBatchCode(Long id) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        BatchCodes batchCodeById = Operations.getBatchCodeById(id);
        openSession.delete(batchCodeById);
        beginTransaction.commit();
     //   openSession.close();
        return true; }

    public static BatchCodes getBatchCodeById(Long id) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchCodes.class);
        createCriteria.add(Restrictions.eq("id", id));
        List<BatchCodes> list = createCriteria.list();
        beginTransaction.commit();
       openSession.close();
        return list.get(0);
    }

    public static boolean editBatchCode(BatchCodes batchCode) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.update(batchCode);
        beginTransaction.commit();
        openSession.close();
        return true; }

    public static void updateSchedule(BatchSchedule batchSchedule) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.update(batchSchedule);
        beginTransaction.commit();
        openSession.close();
         }

    private Operations() {
        // sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getsessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            //sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
        } else {
            return sessionFactory;
        }
    }

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            return objectMapper;
        } else {
            return objectMapper;
        }
    }

    public static boolean addUniversity(University university) {

        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.save(university);
        beginTransaction.commit();
        openSession.close();
        return false;
    }

    public static List<University> getUniversity() {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(University.class);
        createCriteria.addOrder(Order.asc("name"));
        List list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }

    public static boolean addTrainer(Trainer university) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.save(university);
        beginTransaction.commit();
        openSession.close();
        return false;
    }
    public static boolean editTrainer(Trainer university) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.update(university);
        beginTransaction.commit();
        openSession.close();
        return false;
    }
 public static Trainer getTrainerById(Long id) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(Trainer.class);
        createCriteria.add(Restrictions.eq("id", id));
        List<Trainer> list = createCriteria.list();       
        beginTransaction.commit();
        openSession.close();
        return list.get(0);
    }

    public static void addBatchCode(BatchCodes batchCodes) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.save(batchCodes);
        beginTransaction.commit();
        openSession.close();
    }

    public static List<BatchCodes> getBatchCode() {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchCodes.class);
        createCriteria.addOrder(Order.asc("batchCode"));
        List list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }

    public static List<Trainer> getBatchTrainer() {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(Trainer.class);
        createCriteria.addOrder(Order.asc("name"));
        List list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }

    public static List<BatchSchedule> getBatchSchedule() {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.addOrder(Order.desc("date"));
        List<BatchSchedule> list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }

    public static void addBatchSchedule(BatchSchedule batchCodes) {
        if (!batchCodes.getUniversity().equalsIgnoreCase("Select_University/Institute/College")) {
            openSession = Operations.getsessionFactory().openSession();
            beginTransaction = openSession.beginTransaction();
            openSession.save(batchCodes);
            beginTransaction.commit();
            openSession.close();
            System.out.println("Done");
        } else {
            System.out.println("Wrong University");
        }
    }

    public static List getDivisions(String query) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        List list = openSession.createQuery(query).list();
        beginTransaction.commit();
        // beginTransaction.commit();openSession.close();
        return list;
    }

    public static String batchServeToTrainer(String skypeid) {
        System.out.println("Looking for the trainer " + skypeid);
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(Trainer.class);
        createCriteria.add(Restrictions.eq("skype", skypeid));
        List<Trainer> list = createCriteria.list();
        System.out.println("First Method Done " + list.size());
        if (list.size() > 0) {
            try {
                return serveSchedule(list.get(0).getName());
            } catch (IOException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    public static String serveSchedule(String name) throws IOException {

        String replace = name.replace(" ", "_");
        System.out.println(replace + " Second Method Started " + name);
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date fromDate = calendar.getTime();
        calendar1.set(Calendar.HOUR_OF_DAY, 23);
        calendar1.set(Calendar.MINUTE, 59);
        calendar1.set(Calendar.SECOND, 59);
        Date toDate = calendar.getTime();
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
//         createCriteria.add(Restrictions.ge("date", fromDate.getTime()));
//          createCriteria.add(Restrictions.le("till", toDate.getTime()));
        // createCriteria.add(Restrictions.between("date", fromDate, toDate));
        createCriteria.add(Restrictions.like("Status", "s%"));
        // createCriteria.add(Restrictions.eq("Status", "started"));
        createCriteria.add(Restrictions.eq("trainer", replace));
        List<BatchSchedule> list = createCriteria.list();
        List<BatchSchedule> list1 = new ArrayList<>();
        for (BatchSchedule b : list) {
            if (b.getDate().after(calendar) && b.getDate().before(calendar1)) {
                list1.add(b);
            }
        }
        System.out.println("Record List " + list1.size());
        // beginTransaction.commit();
        // openSession.close();
        return Operations.getObjectMapper().writeValueAsString(list1);
    }

    public static void statusUpdate(Long id, String status, String comment) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        BatchSchedule employee = (BatchSchedule) openSession.get(BatchSchedule.class, id);
        employee.setStatus(status);
        employee.setComment(comment);
        openSession.update(employee);
        beginTransaction.commit();
        //openSession.close();
    }

    public static String checkLogin(String emailid, String password, String usertype) throws IOException {

        //Starts with the criteria...!!
//        Criteria createCriteria = null;
//        createCriteria = session.createCriteria(info.class        );
//        createCriteria.add(Restrictions.eq("Login_ID", data));
//        list = createCriteria.list();
//        if (list.size() > 0) {
//            System.out.println("Login_ID Found" + list.size());
//            return list;
//        } 
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = null;
        createCriteria = openSession.createCriteria(Trainer.class);
        System.out.println("Looking for mobile Number");
        createCriteria.add(Restrictions.eq("mobile", emailid));
        createCriteria.add(Restrictions.eq("password", password));
        List list = createCriteria.list();
        if (list.size() < 1) {
            System.out.println("Looking for emailid");
            createCriteria.add(Restrictions.eq("emailid", emailid));
            createCriteria.add(Restrictions.eq("password", password));
            list = createCriteria.list();
            if (list.size() < 1) {
                System.out.println("Looking for skype");
                createCriteria.add(Restrictions.eq("skype", emailid));
                createCriteria.add(Restrictions.eq("password", password));
                list = createCriteria.list();
                if (list.size() < 1) {
                    System.out.println("Looking for skype");
                    createCriteria.add(Restrictions.eq("username", emailid));
                    createCriteria.add(Restrictions.eq("password", password));
                    list = createCriteria.list();
                }
            }

            //return "No Record Found";
        } else {
            // List list = openSession.createQuery(query).list();
            //ObjectMapper mapper = new ObjectMapper();
            return Operations.getObjectMapper().writeValueAsString(list);
        }
        beginTransaction.commit();
        openSession.close();
        return "No Data";

//        beginTransaction.commit();
//        beginTransaction.commit();openSession.close();
    }

    public static boolean addCompletedTraining(CompletedTraining university) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.save(university);
        beginTransaction.commit();
        beginTransaction.commit();
        openSession.close();
        return false;
    }
//     public boolean addUniversity(University university) {
//        openSession = sessionFactory.openSession();
//        beginTransaction = openSession.beginTransaction();
//        openSession.save(university);
//        beginTransaction.commit();
//        beginTransaction.commit();openSession.close();
//        return false;
//    }

    public static boolean addTracker(tracker tracker) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.save(tracker);
        beginTransaction.commit();
        beginTransaction.commit();
        openSession.close();
        return false;
    }

    public static Number getRecordCount(String query) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        numbers = (Number) openSession.createQuery(query).uniqueResult();

        //beginTransaction.commit();openSession.close();
        // return (Number) openSession.createCriteria("Book").setProjection(Projections.rowCount()).uniqueResult();
        return numbers;
    }

    public static String getPlacement(String query1, String Keyword1, String query2, String Keyword2) throws IOException {
        Number topup = getRecordCount(query1);
        Number ites = getRecordCount(query2);
        GetSetPlacementGraph placementGraph = new GetSetPlacementGraph();
        placementGraph.setITES(ites);
        placementGraph.setTOPUP(topup);
        beginTransaction.commit();
        openSession.close();
        return new ObjectMapper().writeValueAsString(placementGraph);
    }

    public static String getTopup(String query1, String Keyword1, String query2, String Keyword2, String query3, String Keyword3, String query4, String Keyword4) throws IOException {
        Number completed = getRecordCount(query1);
        Number ongoing = getRecordCount(query2);
        Number scheduled = getRecordCount(query3);
        Number projected = getRecordCount(query4);
        GetSetTopup placementGraph = new GetSetTopup();
        placementGraph.setCompleted(completed);
        placementGraph.setOngoing(ongoing);
        placementGraph.setScheduled(scheduled);
        placementGraph.setProjected(projected);
        // openSession.close();
        return new ObjectMapper().writeValueAsString(placementGraph);
    }

    public static String getFoundationSkills(String query1, String Keyword1, String query2, String Keyword2, String query3, String Keyword3, String query4, String Keyword4) throws IOException {
        Number completed = getRecordCount(query1);
        System.out.println("Query 1 working");
        Number ongoing = getRecordCount(query2);
        System.out.println("Query 2 working");
        Number scheduled = getRecordCount(query3);
        System.out.println("Query 3 working");
        Number projected = getRecordCount(query4);
        System.out.println("Query 4 working");
        GetSetTopup placementGraph = new GetSetTopup();
        placementGraph.setCompleted(completed);
        placementGraph.setOngoing(ongoing);
        placementGraph.setScheduled(scheduled);
        placementGraph.setProjected(projected);
        // beginTransaction.commit();openSession.close();
        return new ObjectMapper().writeValueAsString(placementGraph);
    }

    public static String getOverAll(String query1, String Keyword1, String query2, String Keyword2, String query3, String Keyword3, String query4, String Keyword4) throws IOException {
        Number completed = getRecordCount(query1);
        Number ongoing = getRecordCount(query2);
        Number scheduled = getRecordCount(query3);
        Number projected = getRecordCount(query4);
        GetSetTopup placementGraph = new GetSetTopup();
        placementGraph.setCompleted(completed);
        placementGraph.setOngoing(ongoing);
        placementGraph.setScheduled(scheduled);
        placementGraph.setProjected(projected);
        // beginTransaction.commit();openSession.close();
        return new ObjectMapper().writeValueAsString(placementGraph);
    }
//public static String getTopupDivision(String query1,String Keyword1,String query2,String Keyword2,String query3,String Keyword3,String query4,String Keyword4) throws IOException{
//        Number topup=getRecordCount(query1);
//        Number ites=getRecordCount(query2);
//        GetSetPlacementGraph placementGraph=new GetSetPlacementGraph();
//        placementGraph.setITES(ites);
//        placementGraph.setTOPUP(topup); 
//        return new ObjectMapper().writeValueAsString(placementGraph);
//  }

    public static String getITESFSFinalAssessment(String query1, String Keyword1, String query2, String Keyword2, String query3, String Keyword3) throws IOException {
        Number male = getRecordCount(query1);
        System.out.println("Query1 Done");
        Number female = getRecordCount(query2);
        System.out.println("Query2 Done");
        Number total = getRecordCount(query3);
        System.out.println("Query3 Done");
        GetSetFinalAssessment placementGraph = new GetSetFinalAssessment();
        placementGraph.setFemale(female);
        placementGraph.setMale(male);
        placementGraph.setTotal(total);
//beginTransaction.commit();openSession.close();
        return new ObjectMapper().writeValueAsString(placementGraph);
    }

    public static String getTopupFinalAssessment(String query1, String Keyword1, String query2, String Keyword2, String query3, String Keyword3) throws IOException {
        Number male = getRecordCount(query1);
        Number female = getRecordCount(query2);
        Number total = getRecordCount(query3);
        GetSetFinalAssessment placementGraph = new GetSetFinalAssessment();
        placementGraph.setFemale(female);
        placementGraph.setMale(male);
        placementGraph.setTotal(total);
//beginTransaction.commit();openSession.close();
        return new ObjectMapper().writeValueAsString(placementGraph);
    }

    public static String getDivision(String query1) throws IOException {
        List divisions = getDivisions(query1);

//        Number topup=getRecordCount(query1);
//        Number ites=getRecordCount(query2);
//        GetSetPlacementGraph placementGraph=new GetSetPlacementGraph();
//        placementGraph.setITES(ites);
//        placementGraph.setTOPUP(topup); 
//beginTransaction.commit();openSession.close();
        return new ObjectMapper().writeValueAsString(divisions);
    }

    public static String getITESFSDivision(String query1, String Keyword1, String query2, String Keyword2, String query3, String Keyword3, String query4, String Keyword4) throws IOException {
        Number topup = getRecordCount(query1);
        Number ites = getRecordCount(query2);
        GetSetPlacementGraph placementGraph = new GetSetPlacementGraph();
        placementGraph.setITES(ites);
        placementGraph.setTOPUP(topup);
        //  beginTransaction.commit();openSession.close();
        return new ObjectMapper().writeValueAsString(placementGraph);
    }

    public static String getUniversitiesBatchList(String university) throws IOException {
        //Map<Integer, University> linkedHashMap = new LinkedHashMap<Integer, University>();
        /**/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date fromDate = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date toDate = calendar.getTime();
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = null;
        createCriteria = openSession.createCriteria(BatchSchedule.class);
        // System.out.println("Looking for mobile Number");
        createCriteria.add(Restrictions.eq("university", university));
        createCriteria.add(Restrictions.between("date", fromDate, toDate));
        // createCriteria.add(Restrictions.eq("date", new Date()));
        List<BatchSchedule> list = createCriteria.list();

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("going to print Data" + list.size());
        beginTransaction.commit();
        openSession.close();
        return mapper.writeValueAsString(list);

    }

    public static String getAllUniversities() throws IOException, ParseException {

        //Map<Integer, University> linkedHashMap = new LinkedHashMap<Integer, University>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Date now=new Date();
//        int day = now.getDay();
//        int month=now.getMonth();
//        int year = now.getYear();
//            Date end = sdf.parse(year+"-"+month+"-"+day+" 23:59");
//        
//        Date start = sdf.parse(year+"-"+month+"-"+day+" 00:00");
//       && date.after(start) && date.before(end)
//       List<BatchSchedule> listScheduleBatch = openSession.createQuery("from BatchSchedule").list();
//       List<University> finallist = new ArrayList<>();
//       for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < listScheduleBatch.size(); j++) {
//                BatchSchedule get1 = listScheduleBatch.get(j);
//                Date date = get1.getDate();
//                University get = list.get(i);
//                if(get.getName().equals(listScheduleBatch.get(j).getUniversity())){
//                    System.out.println("Univesity Found"+get.getName());
//                finallist.add(list.get(i));
//                }
//            }
//
//        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date fromDate = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date toDate = calendar.getTime();
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.add(Restrictions.between("date", fromDate, toDate));
        // createCriteria.add(Restrictions.eq("Status", "scheduled"));
        List<BatchSchedule> list = createCriteria.list();
        List<University> list1 = openSession.createQuery("from University f ORDER BY f.name").list();
        List<University> listUniversity = new ArrayList<University>();
        System.out.println("Scheduleded Batches " + list.size());
        System.out.println("Total University " + list1.size());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if (list1.get(j).getName().equalsIgnoreCase(list.get(i).getUniversity())) {
                    University get = list1.get(i);
                    get.setStatus(list.get(i).getStatus());
                    listUniversity.add(get);

                }
            }
            //list.get(i).getUniversity().equalsIgnoreCase(list1.get(i))
        }
        // openSession.createQuery("from BatchSchedule").list();

        ObjectMapper mapper = new ObjectMapper();
        beginTransaction.commit();
        openSession.close();
        return mapper.writeValueAsString(listUniversity);

    }

    public static String getAllBatchCode() throws IOException {
        //Map<Integer, University> linkedHashMap = new LinkedHashMap<Integer, University>();
        //sessionFactory = Operations.getsessionFactory();
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        List<BatchCodes> list = openSession.createQuery("from BatchCodes f ORDER BY f.batchCode").list();
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(list);

    }

    public static String getAllUniversitiesCordinator(String division) throws IOException {
        //Map<Integer, University> linkedHashMap = new LinkedHashMap<Integer, University>();
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(University.class);
        createCriteria.add(Restrictions.eq("division", division));
        createCriteria.addOrder(Order.asc("name"));
        List<Trainer> list = createCriteria.list();
        // = openSession.createQuery("from University f ORDER BY f.name where f.division='"+division+"'").list();

        ObjectMapper mapper = new ObjectMapper();

//openSession.close();
        return mapper.writeValueAsString(list);

    }//

    public static String getAllTrainers() throws IOException {
        //Map<Integer, University> linkedHashMap = new LinkedHashMap<Integer, University>();
        //sessionFactory = Operations.getsessionFactory();
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        List<Trainer> list = openSession.createQuery("from Trainer f ORDER BY f.name").list();
        ObjectMapper mapper = new ObjectMapper();
        openSession.close();
        return mapper.writeValueAsString(list);

    }

//    public static String todayScheduledBatches() 
    public static String getUniversityBatchTrainerSchedule(String parameter) throws IOException {

      //  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        Date fromDate = calendar1.getTime();
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        Date toDate = calendar2.getTime();
        openSession = getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = null;
        createCriteria = openSession.createCriteria(BatchSchedule.class);
        // System.out.println("Looking for mobile Number");
        String replace = parameter.replace(" ", "_");
        System.out.println("University Name " + replace);
        createCriteria.add(Restrictions.eq("university", replace));
        //  createCriteria.add(Restrictions.between("date", fromDate, toDate));
        // createCriteria.add(Restrictions.eq("date", new Date()));
        List<BatchSchedule> list = createCriteria.list();

        List<GetSetMonitorSchedule> monitor = new ArrayList<GetSetMonitorSchedule>();
        for (BatchSchedule b : list) {
            System.out.println(b.getStatus()+ " " + b.getId());
            if (b.getDate().after(calendar1) && b.getTill().before(calendar2)) {
                String trainer = b.getTrainer();
                String replace1 = trainer.replace("_", " ");
                createCriteria = openSession.createCriteria(Trainer.class);
                createCriteria.add(Restrictions.eq("name", replace1));
                List<Trainer> list1 = createCriteria.list();
                GetSetMonitorSchedule m = new GetSetMonitorSchedule();
                m.setSchedule(b);
                m.setTrainer(list1.get(0));
                monitor.add(m);
            }
        }
        System.out.println("Record Retrived "+monitor);
//        System.out.println("List Size "+list.size());
//         openSession = sessionFactory.openSession();
//        beginTransaction = openSession.beginTransaction();
//  String trainerName=list.get(0).getTrainer();
//  
//        String replace1 = trainerName.replace("_", " ");
//        System.out.println("Trainer Name - "+trainerName);
//        createCriteria = openSession.createCriteria(Trainer.class);
//        // System.out.println("Looking for mobile Number");
//        createCriteria.add(Restrictions.eq("name", replace1));
//        List<Trainer> list1 = createCriteria.list();
//        
//        ObjectMapper mapper = new ObjectMapper();
//        System.out.println("going to print Data" + list.size());
//        return mapper.writeValueAsString(list)+"_"+mapper.writeValueAsString(list1);
//        beginTransaction.commit();
//        openSession.close();
        return new ObjectMapper().writeValueAsString(monitor);
    }

    public static String getAllUniversities4Map() throws IOException, ParseException {
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        // System.out.println(calendar1);
        //  Timestamp from = new Timestamp(calendar.getTime().getTime());
        //Date fromDate = calendar.getTime();
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        //System.out.println(calendar2);
        // Date toDate = calendar.getTime();
        //  System.out.println(fromDate+" Now i am looking from "+toDate);
        // Timestamp to = new Timestamp(calendar.getTime().getTime());
        sessionFactory = Operations.getsessionFactory();
        openSession = sessionFactory.openSession();
        beginTransaction = openSession.beginTransaction();
//        String hql = "From BatchSchedule u where u.date > :s and u.till<:t";
//        Query createQuery = openSession.createQuery(hql);
//  createQuery.setParameter("t", from);
//    createQuery.setParameter("s", to);

        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
//        createCriteria.add(Restrictions.ge("date", fromDate.getTime()));
//          createCriteria.add(Restrictions.le("till", toDate.getTime()));
        // createCriteria.add(Expression.between("date", calendar1, calendar2));
        //createCriteria.add(Restrictions.ge("date", fromDate));
//        createCriteria.add(Restrictions.le("till", toDate));
//        createCriteria.add(Restrictions.eq("Status", "scheduled"));
        //System.out.println("scheduled Searching from "+from+" to " +to);
        // System.out.println(toDate.before(new Date())+"Date Comparision "+fromDate.after(new Date()));
        // List<BatchSchedule> list = createQuery.list();
        List<BatchSchedule> list = createCriteria.list();
        System.out.println("List Retrived " + list.size());
        String s = "";
        //List<University> listUniversity = new ArrayList<University>();
        List l = new ArrayList<Object>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDate().after(calendar1) && list.get(i).getDate().before(calendar2)) {
                // System.out.println(list.get(i).getDate() + " to " + list.get(i).getTill());
                // System.out.println(fromDate.after(list.get(i).getDate())+"Today Date Comparision "+toDate.before(list.get(i).getTill()));

                s = list.get(i).getUniversity().replace("_", " ");
                Calendar date = list.get(i).getDate();
                System.out.println("University to get " + s);
                //Transaction beginTransaction1 = openSession.beginTransaction();
                //List<University> list1 = openSession.createQuery("from University where name='"+s+"'").list();
                Criteria createCriteria1 = openSession.createCriteria(University.class);

                createCriteria1.add(Restrictions.eq("name", s));

                List<University> list1 = createCriteria1.list();
                // beginTransaction1.commit();
                System.out.println("Scheduled Record - " + list.get(i));
                System.out.println("University Going to Update" + list1.get(0));
                list1.get(0).setStatus(list.get(i).getStatus());
                //  list1.get(0).setDate(list.get(i).getDate().getTime());
                System.out.println("Date From Schedule " + list1.get(0).getDate());
                l.add(list1);
                //list1.clear();
                // l.add(list1.get(0));
            }
            System.out.println(list.get(i).getId() + " i am out side if");
        }
        System.out.println("out of for loop");
        beginTransaction.commit();
        //System.out.println("Total Universities "+list1.size());
//        List<University> listUniversity = new ArrayList<University>();
//        System.out.println("Scheduleded Batches "+list.size());
//        System.out.println("Total University "+list1.size());
////        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list1.size(); j++) {
//                String replace = list.get(i).getUniversity().replace("_", " ");
//                System.out.println(list1.get(j).getName()+" "+list.get(i).getUniversity());
//                if (list1.get(j).getName().equalsIgnoreCase(replace)) {
//                                     
//                  list1.get(i).setStatus(list.get(i).getStatus());
//                   list1.get(i).setId(list.get(i).getId());
//                   list1.get(i).setName(list.get(i).getUniversity());
//                 //  list1.get(i).setLatitude(list.get(i).getUniversity());
//                    System.out.println("Object going to add - "+list1.get(i));
//                    listUniversity.add(list1.get(i));
//
//                }
//            }
//            //list.get(i).getUniversity().equalsIgnoreCase(list1.get(i))
//        }
        // openSession.createQuery("from BatchSchedule").list();

        // ObjectMapper mapper = new ObjectMapper();
        openSession.close();
        return getObjectMapper().writeValueAsString(l);

    }

    public static List<BatchSchedule> todayScheduledBatches() {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);//To change body of generated methods, choose Tools | Templates.
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        sessionFactory = Operations.getsessionFactory();
        openSession = sessionFactory.openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.addOrder(Order.asc("trainer"));
        List<BatchSchedule> list = createCriteria.list();
        System.out.println("List Retrived " + list.size());
        String s = "";
        List<BatchSchedule> l = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDate().after(calendar1) && list.get(i).getDate().before(calendar2)) {
                l.add(list.get(i));
            }
        }
        return l;
    }

    public static List<BatchSchedule> getBatchSchedule15() {
        openSession = Operations.getsessionFactory().openSession();
        Calendar today = Calendar.getInstance();
        System.out.println("today" + today.getTime());
        today.add(Calendar.DATE, -15);
        System.out.println("after deduction 15 " + today.getTime());

        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.addOrder(Order.desc("date"));
        createCriteria.add(Restrictions.ge("date", today));
        List<BatchSchedule> list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }

    public static List<BatchSchedule> getBatchScheduleNext15() {
        openSession = Operations.getsessionFactory().openSession();
        Calendar today = Calendar.getInstance();
        System.out.println("today" + today.getTime());
        today.add(Calendar.DATE, +15);
        System.out.println("after addition 15 " + today.getTime());

        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(BatchSchedule.class);
        createCriteria.addOrder(Order.desc("date"));
        createCriteria.add(Restrictions.ge("date", today));
        List<BatchSchedule> list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }

    public static void akpUpload(Version v) {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        openSession.save(v);
        beginTransaction.commit();
        openSession.close();
    }

    public static Version latestUpdate() {
        openSession = Operations.getsessionFactory().openSession();
        beginTransaction = openSession.beginTransaction();
        Criteria createCriteria = openSession.createCriteria(Version.class);
        List<Version> list = createCriteria.list();
        beginTransaction.commit();
        openSession.close();
        System.out.println("List Size " + list.size());
        if (list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return null;
    }

}
