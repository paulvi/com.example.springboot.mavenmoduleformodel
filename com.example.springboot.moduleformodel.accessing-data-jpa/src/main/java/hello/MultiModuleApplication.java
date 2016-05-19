package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springboot.moduleformodel2.Hotel;
import com.example.springboot.moduleformodel2.HotelRepository;

@SpringBootApplication
public class MultiModuleApplication {

	private static final Logger log = LoggerFactory.getLogger(MultiModuleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MultiModuleApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
            log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
            log.info("");
		};
	}

	@Bean
	public CommandLineRunner demo(HotelRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Hotel("5Star"));
			
			// fetch an individual hotel by ID
			Hotel hotel = repository.findOne(1L);
			log.info("Hotel found with findOne(1L):");
			log.info("--------------------------------");
			log.info(hotel.toString());
            log.info("");
		};
	}	
}
