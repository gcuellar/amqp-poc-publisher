package io.builders.amqp.poc.producer


import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class Publisher {

    @Value('${rabbitmq.poc.exchange}')
    private String EXCHANGE_NAME

    RabbitTemplate rabbitTemplate

    Publisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate
    }

    void publish(String message){
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,"", message)
    }
}
