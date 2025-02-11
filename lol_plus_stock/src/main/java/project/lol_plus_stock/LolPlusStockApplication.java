package project.lol_plus_stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
public class LolPlusStockApplication {

	public static void main(String[] args) {

		SpringApplication.run(LolPlusStockApplication.class, args);
		System.out.println("고동현바보");

	}

}
