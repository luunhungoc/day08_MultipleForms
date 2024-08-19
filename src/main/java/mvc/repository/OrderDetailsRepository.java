package mvc.repository;


import mvc.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity,Integer> {


//    List<OrderDetailsEntity> findByAuthor(String author);
//    List<OrderDetailsEntity> findByNameAndAuthor(String name,String author);
//    List<OrderDetailsEntity> findByNameOrAuthor(String name, String author);
//    OrderDetailsEntity findByBookDetailsIsbn(String isbn);
//
//
//    List<BookEntity> findByBookDetailsPriceLessThan(int price);
//    List<BookEntity> findByBookDetailsPriceLessThanEqual(int price);
//    List<BookEntity> findByBookDetailsPriceGreaterThanEqual(int price);
//
//    List<BookEntity> findByPriceLessThan(int price);
//

//
//    List<BookEntity> getAll();
}
