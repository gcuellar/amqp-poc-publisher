package io.builders.amqp.poc

import io.builders.amqp.poc.producer.Publisher
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class RabbitAmqpPocApplication {

	static void main(String[] args) {
		SpringApplication.run(RabbitAmqpPocApplication, args).close()
	}

	@Bean
	CommandLineRunner runner(Publisher publisher) {
		(args) -> {
			publisher.publish(args[0], args[1]?:"")

			println ""
			println ""
			println "-- Message sent -- "
			println ""
			println "routingKey: " + args[1]
			println "payload: " + args[0]
			println ""
			println "-- ------------ -- "
		}
	}

}
