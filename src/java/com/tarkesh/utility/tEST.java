/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.utility;

import com.tarkesh.entity.BatchSchedule;
import com.tarkesh.operation.Operations;

/**
 *
 * @author tarkeshwar
 */
public class tEST {
    public static void main(String[] args) {
        BatchSchedule batchSchedule=new BatchSchedule();
        batchSchedule.setUniversity("Select_University/Institute/College");
        Operations.addBatchSchedule(batchSchedule);
    }
}
