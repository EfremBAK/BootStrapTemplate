package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/books";

		// add 1984
		restTemplate.postForLocation(serverUrl, new Book("1234","George Orwell", "1984", 12.49));
		// add Animal farm
		restTemplate.postForLocation(serverUrl, new Book("2234","George Orwell", "Animal Farm",14.99));

		// get 1984
		Book book = restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "1234");
		System.out.println("----------- get ISBN 1234 -----------------------");
		System.out.println(book.getTitle()+" has isbn "+book.getIsbn()+" and costs " + book.getPrice());

        // get all
		Books books= restTemplate.getForObject(serverUrl, Books.class);
		//this is why we need a Books class so that we dont have to do it in array form
		System.out.println("----------- get all the books --------------------");
		System.out.println(books);

		// delete 1984
		restTemplate.delete(serverUrl+"/{isbn}", "1234");

		// update animal farm
		book.setPrice(13.49);
		restTemplate.put(serverUrl+"/{isbn}", book, book.getIsbn());

		// get all
		books= restTemplate.getForObject(serverUrl, Books.class);
		System.out.println("----------- get all books -----------------------");
		System.out.println(books);
	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
