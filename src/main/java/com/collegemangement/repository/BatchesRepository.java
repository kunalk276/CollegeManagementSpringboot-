package com.collegemangement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.collegemangement.entity.Batches;

public interface BatchesRepository extends JpaRepository<Batches, Integer> {
}
