package frameworkapi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FrameworkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkApiApplication.class, args);
	}

}
