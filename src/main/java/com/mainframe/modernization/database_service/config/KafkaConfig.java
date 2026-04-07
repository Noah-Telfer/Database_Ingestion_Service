package com.mainframe.modernization.database_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.retrytopic.RetryTopicConfiguration;
import org.springframework.kafka.retrytopic.RetryTopicConfigurationBuilder;

@Configuration
public class KafkaConfig {
    @Value("${kafka.retry.attempts}")
    private int maxRetryAttempts;

    @Value("${kafka.retry.interval.ms}")
    private int retryIntervalMs;

    @Bean
    public RetryTopicConfiguration myRetryTopic(KafkaTemplate<String, String> template) {
        return RetryTopicConfigurationBuilder
                .newInstance()
                .maxAttempts(maxRetryAttempts)
                .fixedBackOff(retryIntervalMs) // Wait specified milliseconds between tries
                .notRetryOn(NullPointerException.class) // Don't bother retrying logic errors
                .create(template);
    }   
}
