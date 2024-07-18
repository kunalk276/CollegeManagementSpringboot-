package com.collegemangement.service;

import java.util.List;
import com.collegemangement.entity.Batches;

public interface BatchesService {
    Batches addBatch(Batches batch);
    Batches getBatchDetail(int id);
    List<Batches> getAllBatches();
    Batches updateBatchDetail(Batches batch, int id);
    void deleteBatchDetail(int id);
}
