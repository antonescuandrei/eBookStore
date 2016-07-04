package ebookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Version;

@Entity
public class Ebook implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Version
    private int version;
    
    private String title;
    private String isbn;
    private String author;
    private double price;
    
    public Ebook() {}
    
    public Ebook(String title, String isbn, String author, double price) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }
    
    public int getVersion() {
        return version;
    }
    
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}