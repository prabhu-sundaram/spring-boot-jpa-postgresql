package com.dm.springbootjpapostgresql.event.consumer;

import com.dm.springbootjpapostgresql.dto.UserOrder;

public interface OrderConsumer {

    public void receiveOrder(UserOrder order);
}
