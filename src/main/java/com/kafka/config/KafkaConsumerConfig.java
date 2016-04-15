package com.kafka.config;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.javaapi.consumer.ConsumerConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ykurtulus on 4/13/16.
 */

@Configuration
public class KafkaConsumerConfig {

    private String zookeeperConnect="localhost:2181";
    private String groupId="test-consumer-group";
    private String autoOffsetReset="smallest";

    @Bean
    public ConsumerConnector kafkaConsumer() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("zookeeper.connect", zookeeperConnect);
        properties.setProperty("group.id", groupId);
        properties.setProperty("auto.offset.reset", autoOffsetReset);

        ConsumerConfig kafkaConsumerConfig = new ConsumerConfig(properties);
        return Consumer.createJavaConsumerConnector(kafkaConsumerConfig);
    }

}
