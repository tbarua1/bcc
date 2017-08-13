/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.dao;

import com.tarkesh.entity.BatchCodes;
import java.util.List;

/**
 *
 * @author Abhishek.Sehgal
 */
public interface BatchCodedao {
    public Long addRecord(BatchCodes batchCode);
    //public boolean editRecord(Long id,BatchCodes batchCode);
     public boolean editRecord(BatchCodes batchCode);
    public boolean deleteRecord(Long id);
    public BatchCodes getRecord(Long id);
    public List<BatchCodes> getAll();
}
