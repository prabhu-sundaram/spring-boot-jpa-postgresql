package com.dm.springbootjpapostgresql.event.producer;

import com.dm.springbootjpapostgresql.dto.UserOrder;

public interface OrderProducer {
    public void sendOrder(UserOrder order);
}
