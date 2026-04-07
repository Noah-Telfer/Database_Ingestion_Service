package com.mainframe.modernization.database_service.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.mainframe.modernization.database_service.entity.MainframeDataEntity;
import com.mainframe.modernization.database_service.repository.MainframeRecordRepository;

@Service
public class DatabaseIngestionService {



    private final MainframeRecordRepository repository;

    public DatabaseIngestionService(MainframeRecordRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${kafka.topic.name}")
    public void listen(String payload) {
        // If this throws an Exception, Spring won't commit the offset.
        // It will trigger the Retry/DLT logic instead.
        repository.save(new MainframeDataEntity(payload));
    }
}
