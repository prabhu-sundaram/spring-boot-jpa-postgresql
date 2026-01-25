package com.dm.springbootjpapostgresql.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;

import com.dm.springbootjpapostgresql.model.entity.Shipment;
import com.dm.springbootjpapostgresql.model.entity.TaxInvoice;

@Configuration
@EnableKafka
public class MultiConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    // 1. Factory for String (User Group)
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> userFactory() {
        return createFactory("user-group", new StringDeserializer());
    }

    // 2. Factory for Invoicing
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TaxInvoice> invoicingFactory() {
        return createFactory("invoicing", new JsonDeserializer<>(TaxInvoice.class));
    }

    // 3. Factory for Shipping
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Shipment> shippingFactory() {
        return createFactory("shipping", new JsonDeserializer<>(Shipment.class));
    }

    // Helper method to reduce boilerplate
    private <T> ConcurrentKafkaListenerContainerFactory<String, T> createFactory(String groupId, Deserializer<T> valueDeserializer) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        
        DefaultKafkaConsumerFactory<String, T> factory = new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), valueDeserializer);
        ConcurrentKafkaListenerContainerFactory<String, T> listenerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerFactory.setConsumerFactory(factory);
        listenerFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return listenerFactory;
    }
}
