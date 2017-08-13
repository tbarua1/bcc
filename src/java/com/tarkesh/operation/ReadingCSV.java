package com.tarkesh.operation;

import com.tarkesh.entity.University;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tarkeshwar
 */
public class ReadingCSV {

    private File file;
    private String data;
    private String[] split;
    private University universiry;

    public ReadingCSV(File csvFile) {
        file = csvFile;
    }

    public void csvUniversity() {
        try {
            universiry = new University();
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((data = br.readLine()) != null) {
                split = data.split(",");
                universiry.setName(split[1]);
                universiry.setProgram_fs(true);
                universiry.setProgram_topup(true);
                universiry.setUniversity_type("Public");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadingCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadingCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
