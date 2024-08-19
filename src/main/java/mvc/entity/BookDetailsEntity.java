package mvc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="bookdetails")
public class BookDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="isbn")
    private String isbn;

    @Column(name="numberOfPage")
    private int numberOfPage;

    @Column(name="price")
    private int price;

    @Column(name="publishDate")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate publishDate;

    @OneToOne(mappedBy="bookDetails")
    private BookEntity book;


    public BookDetailsEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "{" +
                " isbn=" + isbn + '\'' +
                ", numberOfPage=" + numberOfPage +
                ", price=" + price +
                ", publishDate=" + publishDate+
                '}';
    }
}