package ie.atu.bookappsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:.env")
public class BookAppSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAppSearchServiceApplication.class, args);
	}

}
