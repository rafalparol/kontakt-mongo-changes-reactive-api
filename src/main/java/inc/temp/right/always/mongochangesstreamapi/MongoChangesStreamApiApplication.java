package inc.temp.right.always.mongochangesstreamapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "inc.temp.right.always.mongochangesstreamapi.repositories")
public class MongoChangesStreamApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongoChangesStreamApiApplication.class, args);
	}
}
