package application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import application.model.Book;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends MongoRepository<Book, String> {

	Book findBookByIsbn(@Param("isbn") String isbn);
	
	List<Book> findBooksByTitle(@Param("title") String title);
	
	List<Book> findBooksByAuthor(@Param("author") String author);
	
}
