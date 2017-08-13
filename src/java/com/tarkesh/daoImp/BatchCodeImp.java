/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.daoImp;

import com.tarkesh.dao.BatchCodedao;
import com.tarkesh.entity.BatchCodes;
import com.tarkesh.operation.Operations;
import java.util.List;

/**
 *
 * @author Abhishek.Sehgal
 */
public class BatchCodeImp implements BatchCodedao {

    @Override
    public Long addRecord(BatchCodes batchCode) {
        Operations.addBatchCode(batchCode);
        return 1L;
    }
    @Override
    public List<BatchCodes> getAll() {
        return Operations.getAllBatchCodeList();
    }

    @Override
    public boolean deleteRecord(Long id) {
        return Operations.deleteBatchCode(id);
    }

    @Override
    public BatchCodes getRecord(Long id) {
        return Operations.getBatchCodeById(id);
    }

    @Override
    public boolean editRecord(BatchCodes batchCode) {
        return Operations.editBatchCode(batchCode);
    }

   
}
