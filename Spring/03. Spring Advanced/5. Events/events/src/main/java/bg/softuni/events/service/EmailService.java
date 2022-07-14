package bg.softuni.events.service;

import bg.softuni.events.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);


    @Order(2)
    @EventListener(OrderCreatedEvent.class)
    public void onOrderCreated(OrderCreatedEvent orderCreatedEvent) {
        LOGGER.info("Sending email for order {}", orderCreatedEvent.getOrderId());

    }
}
