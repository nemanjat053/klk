package stuService.ewq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = { "stuService.ewq.repository", "stuService.ewq.model", "stuService.ewq.service", "stuService.ewq.controller",
		"stuService.ewq.dto", "stuService.ewq.utils", "stuService.ewq.security"} )
public class EwqApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwqApplication.class, args);
	}

}
