package guru.springframework.spring5webapp.bootstrap;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started in Bootstrap");
		var eric = Author.builder().firstName("Eric").lastName("Evans").build();
		var ddd = Book.builder().title("Domain Driven Design").isbn("123123").build();
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		var rod = Author.builder().firstName("Rod").lastName("Johnson").build();
		var noEJB = Book.builder().title("J2EE Development Without EJB").isbn("3939459459").build();
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
		var sopena = Publisher.builder().addressLine1("Calle falsa 123").city("Springfield").name("Sopena").zip("050030").state("Alaska").build();
		sopena.getBooks().addAll(Arrays.asList(ddd, noEJB));
		publisherRepository.save(sopena);
		System.out.println("Number of publishers: " + publisherRepository.count());
		System.out.println("Sopena books: " + sopena.getBooks().size());
	}

}
