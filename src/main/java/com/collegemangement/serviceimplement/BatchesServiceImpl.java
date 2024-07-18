package com.collegemangement.serviceimplement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Import transactional annotation
import com.collegemangement.entity.Batches;
import com.collegemangement.exception.BatchNotFoundException;
import com.collegemangement.repository.BatchesRepository;
import com.collegemangement.service.BatchesService;

@Service
public class BatchesServiceImpl implements BatchesService {

    @Autowired
    private BatchesRepository batchesRepository;

    @Override
    public Batches addBatch(Batches batch) {
        return batchesRepository.save(batch);
    }

    @Override
    public Batches getBatchDetail(int id) {
        return batchesRepository.findById(id)
                .orElseThrow(() -> new BatchNotFoundException("Batch not found with id " + id));
    }

    @Override
    public List<Batches> getAllBatches() {
        return batchesRepository.findAll();
    }

    @Override
    @Transactional // Ensure transactional behavior for update operation
    public Batches updateBatchDetail(Batches updatedBatch, int id) {
        Batches existingBatch = batchesRepository.findById(id)
                .orElseThrow(() -> new BatchNotFoundException("Batch not found with id " + id));

        // Update only the relevant fields
        existingBatch.setBname(updatedBatch.getBname());
        existingBatch.setSubject(updatedBatch.getSubject());
        existingBatch.setStartdate(updatedBatch.getStartdate());
        existingBatch.setEnddate(updatedBatch.getEnddate());
        existingBatch.setDuration(updatedBatch.getDuration());

        return batchesRepository.save(existingBatch);
    }

    @Override
    public void deleteBatchDetail(int id) {
        Batches batch = batchesRepository.findById(id)
                .orElseThrow(() -> new BatchNotFoundException("Batch not found with id " + id));
        batchesRepository.delete(batch);
    }
}
