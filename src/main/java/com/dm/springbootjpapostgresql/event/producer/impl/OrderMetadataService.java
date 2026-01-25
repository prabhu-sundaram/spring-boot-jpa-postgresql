package com.dm.springbootjpapostgresql.event.producer.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.dm.springbootjpapostgresql.model.entity.Order;
import com.dm.springbootjpapostgresql.model.entity.OrderEventLog;
import com.dm.springbootjpapostgresql.repository.jpa.OrderEventLogRepository;
import com.dm.springbootjpapostgresql.repository.jpa.OrderRepository;

@Service
public class OrderMetadataService {

	private final OrderEventLogRepository orderEventLogRepository;
    private final OrderRepository orderRepository;

    public OrderMetadataService(OrderEventLogRepository orderEventLogRepository, OrderRepository orderRepository) {
        this.orderEventLogRepository = orderEventLogRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveEventLog(Long orderId, int partition, long offset) {
        // Use getReferenceById to link the Order via its ID without a full SELECT
        Order orderProxy = orderRepository.getReferenceById(orderId);

        OrderEventLog logEntry = OrderEventLog.builder()
                .order(orderProxy)
                .kafkaPartition(partition)
                .kafkaOffset(offset)
                .build();
        
        orderEventLogRepository.save(logEntry);
    }
}
