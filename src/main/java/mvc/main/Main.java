package mvc.main;

import mvc.config.Config;
import mvc.entity.*;
import mvc.repository.BookRepository;
import mvc.repository.CategoryRepository;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
    static BookRepository bookRepository=(BookRepository) context.getBean("bookRepository");
    static CategoryRepository categoryRepository =(CategoryRepository) context.getBean("categoryRepository");
    static OrderDetailsRepository orderDetailsRepository=(OrderDetailsRepository) context.getBean("orderDetailsRepository");
    static OrderRepository orderRepository =(OrderRepository) context.getBean("orderRepository");


    public static void main(String[] args){

//        createNewBookEntryWithNewCategory();
//        createNewBookEntry();
        findAll();
//        findByAuthor("Roger");
//        findByNameAndAuthor("Java A-Z","Roger");
//        findByNameOrAuthor("linux","Roger");
//        findByPriceLessThan(80);
//        findByBookDetailsIsbn("ISIBF1219323");
//        findByNameContaining("ava");
//        deleteBookById(1);
//        deleteAllBook();


        System.out.println("=========");
//        createNewOrder();
//        createNewOrderDetailsEntry();
//        createNewOrderDetailsEntryWithNewOrder();
//        findAllOrdersAndOrderDetails();
//        findByOrderId(1);
//        findOrderByCurrentMonth();
//        findOrderByTotalAmountGreaterThan(1000);
//        findByProductNameContaining("java");
    }

    // ===========BOOKS============

    public static void deleteBookById(int i){
        bookRepository.deleteById(i);
        System.out.println("Deleted book id "+i);
    }
    public static void deleteAllBook(){
        bookRepository.deleteAll();
        System.out.println("Deleted all books");
    }

    public static void findAll(){
        List<BookEntity> bookEntityList= (List<BookEntity>) bookRepository.findAll();
        if(bookEntityList!=null){

            System.out.println("They are: ");
            for(BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByAuthor(String author){
        List<BookEntity> bookEntityList=bookRepository.findByAuthor(author);
        if(bookEntityList!=null){
            System.out.println("Find "+bookEntityList.size()+" books which author = "+author);
            System.out.println("They are: ");
            for(BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }

    public static void findByNameAndAuthor(String name,String author){
        List<BookEntity> bookEntityList=bookRepository.findByNameAndAuthor(name,author);
        if(bookEntityList!=null){
            System.out.println("\nFind "+bookEntityList.size()+" books which name= "+ name+ " and author = "+author);
            for(BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }

    public static void findByNameOrAuthor(String name,String author){
        List<BookEntity> bookEntityList=bookRepository.findByNameOrAuthor(name,author);
        if(bookEntityList!=null){
            System.out.println("\nFind "+bookEntityList.size()+" books which name= "+ name+ "or author = "+author);
            for(BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }

    public static void findByPriceLessThan(int price){
        List<BookEntity> bookEntityList=bookRepository.findByPriceLessThan(price);
        if(bookEntityList!=null){
            System.out.println("\nFind "+bookEntityList.size()+" books price less than "+price);
            for(BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }

    public static void findByNameContaining(String name){
        List<BookEntity> bookEntityList=bookRepository.findByNameContaining(name);
        if(bookEntityList!=null){
            System.out.println("\nFind "+bookEntityList.size()+" books containing name "+name);
            for(BookEntity bookEntity:bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }


    public static void findByBookDetailsIsbn(String isbn){
        BookEntity bookEntity= bookRepository.findByBookDetailsIsbn(isbn);
        if(bookEntity!=null){
            System.out.println("\nFind book which isbn= "+isbn);

                System.out.println(bookEntity.toString());

        }
    }
//
//
//
    public static void createNewBookEntry(){
        CategoryEntity categoryEntity= new CategoryEntity();
        categoryEntity.setId(1);

        BookEntity bookEntity=createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }
    public static void createNewBookEntryWithNewCategory(){
        CategoryEntity categoryEntity= createNewCategory();
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity=createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }

    private static CategoryEntity createNewCategory() {
        CategoryEntity categoryEntity=new CategoryEntity();
        categoryEntity.setName("Math");
        categoryEntity.setDescription("Math books");
        return categoryEntity;
    }

    private static BookEntity createNewBook() {
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setIsbn("ISIBF12200003");
        bookDetailsEntity.setNumberOfPage(363);
        bookDetailsEntity.setPrice(300);
        bookDetailsEntity.setPublishDate(LocalDate.parse("2015-01-08"));

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Linux shell programming");
        bookEntity.setAuthor("Thomas");
        bookEntity.setBookDetails(bookDetailsEntity);
        bookDetailsEntity.setBook(bookEntity);

        return bookEntity;

    }




// ===========ORDERS============

    public static void findAllOrdersAndOrderDetails(){
        List<OrderEntity> orderEntityList= (List<OrderEntity>) orderRepository.findAll();
        if(orderEntityList!=null){
            System.out.println("Find "+orderEntityList.size()+" orders:");
            System.out.println("They are: ");
            for(OrderEntity orderEntity:orderEntityList){
                System.out.println(orderEntity.toString());
            }
        }
    }

    public static void findByOrderId(int id){
        List<OrderEntity> orderEntityList=orderRepository.findByOrderId(id);
        if(orderEntityList!=null){
            System.out.println("Find "+orderEntityList.size()+" orders which id = "+id);
            System.out.println("They are: ");
            for(OrderEntity orderEntity:orderEntityList){
                System.out.println(orderEntity.toString());
            }
        }
    }

    public static void findOrderByCurrentMonth(){
        List<OrderEntity> orderEntityList=orderRepository.findOrderByCurrentMonth();
        if(orderEntityList.size()!=0){
            System.out.println("Found "+orderEntityList.size()+" order(s) in current month");
            System.out.println("They are: ");
            for(OrderEntity o:orderEntityList){
                System.out.println(o.toString());
            }

        }
    }
//7. List all orders which have total amount more than 1,000USD
    public static void findOrderByTotalAmountGreaterThan(double price){
        List<OrderEntity> orderEntityList=orderRepository.findOrderByTotalAmountGreaterThan(price);
        if(orderEntityList!=null){
            System.out.println("\nFind "+orderEntityList.size()+" orders which have total amount more than "+price+" USD:");
            for(OrderEntity orderEntity:orderEntityList){
                System.out.println(orderEntity.toString());
            }
        }
    }
    //8. List all orders buy Java book.
    public static void findByProductNameContaining(String productName){
        List<OrderEntity> orderEntityList=orderRepository.findByProductNameContaining(productName);
        if(orderEntityList!=null){
            System.out.println("Find "+orderEntityList.size()+" orders which productName = "+productName);
            System.out.println("They are: ");
            for(OrderEntity orderEntity:orderEntityList){
                System.out.println(orderEntity.toString());
            }
        }
    }

    public static void createNewOrderDetailsEntry(){
        OrderEntity orderEntity= createNewOrder();
        orderEntity.setId(1);
        OrderDetailsEntity orderDetailsEntity=createNewOrderDetails();
        orderDetailsEntity.setOrder(orderEntity);
        orderDetailsRepository.save(orderDetailsEntity);
    }


    public static void createNewOrderDetailsEntryWithNewOrder(){
        OrderEntity orderEntity= createNewOrder();
        orderRepository.save(orderEntity);

        OrderDetailsEntity orderDetailsEntity=createNewOrderDetails();
        orderDetailsEntity.setOrder(orderEntity);
        orderDetailsRepository.save(orderDetailsEntity);
    }

        private static OrderEntity createNewOrder() {
            OrderEntity orderEntity=new OrderEntity();

            orderEntity.setOrderDate(LocalDate.now());
            orderEntity.setCustomerName("Nguyen Du");
            orderEntity.setCustomerAddress("Vietnam");
            orderRepository.save(orderEntity);
        return orderEntity;
    }

    private static OrderDetailsEntity createNewOrderDetails() {
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
        orderDetailsEntity.setProductName("Java");
        orderDetailsEntity.setQuantity(2);
        orderDetailsEntity.setUnitPrice(150);


        OrderEntity orderEntity = new OrderEntity();
        orderDetailsEntity.setOrder(orderEntity);

        return orderDetailsEntity;

    }

}
