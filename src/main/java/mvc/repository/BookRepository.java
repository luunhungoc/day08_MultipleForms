package mvc.repository;


import org.springframework.data.repository.CrudRepository;
import mvc.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<BookEntity,Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByNameAndAuthor(String name,String author);
    List<BookEntity> findByNameOrAuthor(String name, String author);
    BookEntity findByBookDetailsIsbn(String isbn);

    @Query(value="select * from book join bookDetails where bookDetails.price <?1 and book.id = bookDetails.id",nativeQuery=true)
    List<BookEntity> findByPriceLessThan(int price);
    List<BookEntity> findByNameContaining(String name);


}
