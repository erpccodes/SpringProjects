package app.contactManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"app.contactManager", "app.contactManager.service"})
public class ContactManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagementAppApplication.class, args);
	}

}
