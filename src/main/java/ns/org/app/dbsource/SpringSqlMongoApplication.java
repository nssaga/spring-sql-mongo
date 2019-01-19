package ns.org.app.dbsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ns.org.app.dbsource.service.CommonSourceService;


@SpringBootApplication
public class SpringSqlMongoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringSqlMongoApplication.class, args);

		CommonSourceService user = (CommonSourceService) context.getBean("commonSourceService");
		user.save();
	}

}
