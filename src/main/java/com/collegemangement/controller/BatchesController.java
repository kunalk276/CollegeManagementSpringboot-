package com.collegemangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.collegemangement.entity.Batches;
import com.collegemangement.service.BatchesService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Batches") 
public class BatchesController {

    @Autowired
    private BatchesService batchesService;

    @PostMapping("/addBatch")
    public ResponseEntity<Batches> saveBatch(@Valid @RequestBody Batches batch) {
        Batches savedBatch = batchesService.addBatch(batch);
        return new ResponseEntity<>(savedBatch, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Batches> getBatchDetail(@PathVariable("id") int id) {
        Batches batch = batchesService.getBatchDetail(id);
        return new ResponseEntity<>(batch, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Batches>> getAllBatches() {
        List<Batches> batches = batchesService.getAllBatches();
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteBatchDetail(@PathVariable("id") int id) {
        batchesService.deleteBatchDetail(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Batches> updateBatchDetail(@PathVariable("id") int id, @Valid @RequestBody Batches batch) {
        Batches updatedBatch = batchesService.updateBatchDetail(batch, id);
        return new ResponseEntity<>(updatedBatch, HttpStatus.OK);
    }
}
