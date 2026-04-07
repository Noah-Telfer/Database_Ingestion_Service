package com.mainframe.modernization.database_service.repository;

import com.mainframe.modernization.database_service.entity.MainframeDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainframeRecordRepository extends JpaRepository<MainframeDataEntity, Long> {
    
    // Spring automatically gives you:
    // .save(entity)
    // .findById(id)
    // .findAll()
    // .delete(entity)
    
    // You can also add custom lookups if needed later:
    // List<MainframeRecord> findBySourceSystem(String sourceSystem);
}