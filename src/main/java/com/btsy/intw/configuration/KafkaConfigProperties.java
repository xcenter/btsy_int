package com.btsy.intw.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "spring.kafka")
@Configuration
public class KafkaConfigProperties {

    @Name("bootstrap-servers")
    private String bootstrapServers;
    @Name("template.default-topic")
    private String topic;
    @Name("template.dlq-topic")
    private String dlqTopic;
    @Name("consumer.group-id")
    private String groupId;

}
