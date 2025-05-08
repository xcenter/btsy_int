package com.btsy.intw.configuration;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "kafka")
public class KafkaConfigProperties {

    private String bootstrapServers;
    private String topic;
    private String groupId;

}
