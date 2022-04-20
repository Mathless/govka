package tyoma.govka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GovkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GovkaApplication.class, args);
	}

}
