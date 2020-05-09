package Models;

import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@Proxy(lazy = false)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String genre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "authorsBook_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))

    private Set<Book> books = new HashSet<Book>();

    public Author() {
    }

    public Author(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Author(int id, String name, String genre, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.books = books;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.getAuthors().add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\ngenre='" + genre + '\'' +
                "\nbooks=" + books +
                '}';
    }
}