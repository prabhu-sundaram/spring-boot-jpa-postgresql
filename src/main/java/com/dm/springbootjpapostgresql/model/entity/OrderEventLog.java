package com.dm.springbootjpapostgresql.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_EVENT_LOG")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEventLog {

    @Id
    private Long id; // This will hold the same value as Order ID due to @MapsId

    private Integer kafkaPartition;

    private Long kafkaOffset;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "order_id")
    private Order order;

}
