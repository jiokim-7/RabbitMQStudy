package com.revi.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {
		RabbitAutoConfiguration.class
})
@EnableRabbit
@RestController
@RequiredArgsConstructor
public class RabbitMqApplication {
	private final RabbitTemplate testTemplate;
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}

	@GetMapping("/")
	public String inQueue() {
		testTemplate.convertAndSend(SampleMessage.of("first message"));
		return "Success";
	}
	@GetMapping("/vhost")
	public String inQueuing() {
		testTemplate.convertAndSend(SampleMessage.of("second message"));
		return "Not fail";
	}

	@Data
	@AllArgsConstructor(staticName = "of")
	@NoArgsConstructor
	public static class SampleMessage {
		private String message;
	}
}
