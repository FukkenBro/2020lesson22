package Models;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Proxy(lazy = false)
public class Book {

    @Id
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_title")
    private String title;

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<Author>();

    public Book() {
    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(int id, String title, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public Set<Author> getAuthors() {
        return this.authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\nid=" + id +
                "\nname='" + title + '\'' +
                "\nstudents=" + authors +
                '}';
    }
}
