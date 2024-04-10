package com.dz.first.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dz.first.entities.ExecutionData;

@Repository
public interface ExecutionDataRepository extends JpaRepository<ExecutionData, Long> {
    @Query("SELECT AVG(endTime - startTime) FROM ExecutionData")
    double findAverageExecutionTime();

    @Query("SELECT SUM(endTime - startTime) FROM ExecutionData")
    long findTotalExecutionTime();

    List<ExecutionData> findAll();
}
