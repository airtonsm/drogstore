package system.drugstore.drugstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EntityScan(basePackages = "com.drogstone.model")
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.drogstore.repository"})
@EnableTransactionManagement
public class DrugstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugstoreApplication.class, args);
	}

}
