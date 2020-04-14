package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author robin = new Author("Robin", "Sharma");
        Book monk = new Book("The Monk who Sold his Ferrari", "55555");
        robin.getBooks().add(monk);
        monk.getAuthors().add(robin);
        authorRepository.save(robin);
        bookRepository.save(monk);

        Author dan = new Author("Dan", "Brown");
        Book fortress = new Book("Digital Fortress", "8888");
        dan.getBooks().add(fortress);
        fortress.getAuthors().add(dan);
        authorRepository.save(dan);
        bookRepository.save(fortress);

        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());

        Publisher penguin = new Publisher("Penguin", "Pen St, BC");
        publisherRepository.save(penguin);
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
