package com.tarkesh.operation;

import com.tarkesh.entity.FinalAssessment;
import com.tarkesh.entity.PlacementOpportunities;
import com.tarkesh.entity.Trainer;
import com.tarkesh.entity.placementes;
import com.tarkesh.entity.tracker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UploadData {

    private static Configuration cfg;
    private static SessionFactory factory;
    private static Session session;
    private static Transaction tr;
    private static tracker information;
    private static placementes placement;
    private static Trainer trainer;
    private static PlacementOpportunities po;
    private static int count = 0;
    private tracker tracker;
    private FinalAssessment finalAssessment;

    public UploadData() {
        System.out.println("i am at DataUpload constructor");
        cfg = new Configuration();
        cfg.configure();
        factory = cfg.buildSessionFactory();
        session = factory.openSession();
        //session.flush();
        tr = session.beginTransaction();
    }

    public void writeFile() {

        File file = new File("abc.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("Hillary Clinton");
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

//    public void readDatafromFile(String file) {
////        hibernateUtil.retrieveSf();
////        in = new info();
////        session = HibernateUtil.sf.openSession();
////        tr = session.beginTransaction();
//        String s = "";
//        BufferedReader bufferedReader;
//        try {
//            bufferedReader = new BufferedReader(new FileReader(new File(file)));
//            while ((s = bufferedReader.readLine()) != null) {
//
//   //             splitString(s);
//                if ((count % 50) == 0) {
//                    session.flush();
//                    session.clear();
//                }
//            }
//            tr.commit();
//        } catch (FileNotFoundException ex) {
//            System.out.println("File Not Found");
//        } catch (IOException ex) {
//            System.out.println("File Reading and writing Error");
//        }
//
//    }
    public tracker splitString(String str) {

        String[] split = str.split(",");
        // String[] split = new String[26];
        System.out.println(split.length + " " + str);

        //FormData data=new FormData();
        information = new tracker();
        // information.setId(Long.parseLong(split[0]));
        information.setStatus(split[1]);
        information.setBatch_code(split[2]);
        information.setTool_id(split[3]);
        information.setUniversity(split[4]);
        information.setLocation(split[5]);
        //updated on 26 March 2017       
        information.setDivision(split[6]);
        information.setEy_spoc(split[7]);
        information.setPhone_ey_spoc(split[8]);
        information.setLocal_spoc(split[9]);
        information.setPhone_local_spoc(split[10]);
        information.setDepartment(split[11]);
        information.setTrack(split[12]);
        information.setBatch_start_date(new Date());//----------
        information.setBatch_size_on_start_date(Integer.parseInt(split[14]));
        information.setExisting_batch_size_on_date(Integer.parseInt(split[15]));
        information.setDropout_on_date(Integer.parseInt(split[16]));
        information.setMale(Integer.parseInt(split[17]));
        information.setFemale(Integer.parseInt(split[18]));
        information.setTrainer_name(split[19]);
        information.setHours_completed_trainer(Integer.parseInt(split[20]));
        information.setDomain_trainer_name(split[21]);
        information.setHours_completed_domain_trainer(Integer.parseInt(split[22]));
        information.setExpected_end_month(split[23]);
        information.setAcademic_year_closer_month_year(split[24]);
        information.setModule_topup_softskill("TOPUP");

        //count++;
        System.out.println("Record Added" + count++);
        return information;
    }

    public tracker splitStringFS(String str) {

        String[] split = str.split(",");
        // String[] split = new String[26];
        System.out.println(split.length + " " + str);

        //FormData data=new FormData();
        information = new tracker();
        // information.setId(Long.parseLong(split[0]));
        information = new tracker();
        // information.setId(Long.parseLong(split[0]));
        information.setStatus(split[1]);
        information.setBatch_code(split[2]);
        information.setTool_id(split[3]);
        information.setUniversity(split[4]);
        information.setLocation(split[5]);
        //updated on 26 March 2017       
        information.setDivision(split[6]);
        information.setEy_spoc(split[7]);
        information.setPhone_ey_spoc(split[8]);
        information.setLocal_spoc(split[9]);
        information.setPhone_local_spoc(split[10]);
        information.setDepartment(split[11]);
        information.setTrack(split[12]);
        information.setBatch_start_date(new Date());//----------
        information.setBatch_size_on_start_date(Integer.parseInt(split[14]));
        information.setExisting_batch_size_on_date(Integer.parseInt(split[15]));
        information.setDropout_on_date(Integer.parseInt(split[16]));
        information.setMale(Integer.parseInt(split[17]));
        information.setFemale(Integer.parseInt(split[18]));
        information.setTrainer_name(split[19]);
        information.setHours_completed_trainer(Integer.parseInt(split[20]));
        information.setDomain_trainer_name(split[21]);
        information.setHours_completed_domain_trainer(Integer.parseInt(split[22]));
        information.setExpected_end_month(split[23]);
        information.setAcademic_year_closer_month_year(split[24]);
        information.setModule_topup_softskill("Foundation Skills");

        //count++;
        System.out.println("Record Added" + count++);
        return information;
    }

//    public static boolean sendtoDataBase(info in) {
//
//        session.save(in);
//        count++;
//        //session.close();
//        return true;
//    }
//    public void saveData(info inform) {
//        session.save(inform);
//
//    }
    public void readFromFileTrainer(String fileName) {
        BufferedReader bufferedReader;
        String s;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            while ((s = bufferedReader.readLine()) != null) {
                Trainer splitString = splitStringTrainer(s);

                session = factory.openSession();
                //session.flush();
                tr = session.beginTransaction();
                session.save(splitString);
                tr.commit();
                session.close();
                //saveData(splitString);
                System.out.println("" + count);
                count++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readFromFileFS(String fileName) {
        BufferedReader bufferedReader;
        String s;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            while ((s = bufferedReader.readLine()) != null) {
                tracker splitString = splitStringFS(s);

                session = factory.openSession();
                //session.flush();
                tr = session.beginTransaction();
                session.save(splitString);
                tr.commit();
                session.close();
                //saveData(splitString);
                System.out.println("" + count);
                count++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readFromFile(String fileName) {
        BufferedReader bufferedReader;
        String s;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            while ((s = bufferedReader.readLine()) != null) {
                tracker splitString = splitString(s);

                session = factory.openSession();
                //session.flush();
                tr = session.beginTransaction();
                session.save(splitString);
                tr.commit();
                session.close();
                //saveData(splitString);
                System.out.println("" + count);
                count++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readFromFileFinalAssessment(String fileName) {
        BufferedReader bufferedReader;
        String s;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            while ((s = bufferedReader.readLine()) != null) {
                FinalAssessment splitStringFinalAssessment = splitStringFinalAssessment(s);

                session = factory.openSession();
                //session.flush();
                tr = session.beginTransaction();
                session.save(splitStringFinalAssessment);
                tr.commit();
                session.close();
                //saveData(splitString);
                System.out.println("" + count);
                count++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FinalAssessment splitStringFinalAssessment(String str) {

        String[] split = str.split(",");
        // String[] split = new String[26];
        System.out.println(split.length + " " + str);

        //FormData data=new FormData();
        finalAssessment = new FinalAssessment();
        // information.setId(Long.parseLong(split[0]));
        finalAssessment.setModule_topup_softskill("Foundation Skills");
        finalAssessment.setTotalNASSCOMComplete(Integer.parseInt(split[1]));
        finalAssessment.setMale(Integer.parseInt(split[2]));
        finalAssessment.setFemale(Integer.parseInt(split[3]));
        finalAssessment.setLocation(split[4]);

        //count++;
        System.out.println("Record Added" + count++);
        return finalAssessment;
    }

    private Trainer splitStringTrainer(String str) {
        String[] split = str.split(",");
        // String[] split = new String[26];
        System.out.println(split.length + " " + str);

        //FormData data=new FormData();
        trainer = new Trainer();
        // information.setId(Long.parseLong(split[0]));
        // information = new tracker();
        // trainer.setId(Long.parseLong(split[0]));
        trainer.setName(split[1]);
        trainer.setQualification(split[2]);
        trainer.setSkillset(split[3]);
        trainer.setExperience(split[4]);
        trainer.setNatianality(split[5]);
        //updated on 26 March 2017       
        trainer.setMobile(split[6]);
        trainer.setSkype(split[7]);
        trainer.setWhatsapp(split[8]);
        trainer.setEmailid(split[9]);
        return trainer;
    }

    void readFromFilePalacementOpportunity(String hometarkeshwarEYbhtconsolidatedtrainercsv) {
        BufferedReader bufferedReader;
        String s;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(hometarkeshwarEYbhtconsolidatedtrainercsv)));
            while ((s = bufferedReader.readLine()) != null) {
                PlacementOpportunities splitStringFinalAssessment = splitStringPlacementOpportunity(s);

                session = factory.openSession();
                //session.flush();
                tr = session.beginTransaction();
                session.save(splitStringFinalAssessment);
                tr.commit();
                session.close();
                //saveData(splitString);
                System.out.println("" + count);
                count++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PlacementOpportunities splitStringPlacementOpportunity(String str) {
        String[] split = str.split(",");
        // String[] split = new String[26];
        System.out.println(split.length + " " + str);

        //FormData data=new FormData();
        po = new PlacementOpportunities();
        // information.setId(Long.parseLong(split[0]));
        // information = new tracker();
        // trainer.setId(Long.parseLong(split[0]));
        po.setOrganization_name(split[1]);
        po.setResource_requirement(Integer.parseInt(split[2]));
        po.setProgram(split[3]);

        // trainer.setEmailid(split[9]);        
        return po;
    }

    void readFromFilePalacementMade(String hometarkeshwarEYbhtconsolidatedtrainercsv) {
        BufferedReader bufferedReader;
        String s;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(hometarkeshwarEYbhtconsolidatedtrainercsv)));
            while ((s = bufferedReader.readLine()) != null) {
                placementes splitStringFinalAssessment = splitStringPlacementMade(s);

                session = factory.openSession();
                //session.flush();
                tr = session.beginTransaction();
                session.save(splitStringFinalAssessment);
                tr.commit();
                session.close();
                //saveData(splitString);
                System.out.println("" + count);
                count++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private placementes splitStringPlacementMade(String str) {
        String[] split = str.split(",");

        System.out.println(split.length + " " + str);

        placement = new placementes();
        placement.setDate_placement(new Date());

        return placement;
    }
}
