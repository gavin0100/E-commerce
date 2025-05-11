package ecommerce.personal.com;

import ecommerce.com.lib.annotations.EnableApiDoc;
import ecommerce.com.lib.annotations.EnableExceptionHandler;
import ecommerce.com.lib.annotations.EnableTransactionLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableExceptionHandler
@EnableJpaAuditing
@EnableApiDoc
@EnableTransactionLog
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
