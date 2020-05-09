
import Models.Author;
import Models.Book;
import dao.AuthorDao;
import dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    private AuthorDao authorDao = new AuthorDao();
    private BookDao bookDao = new BookDao();

    public DataService() {
    }

    public void addAuthor(Author author) {
        authorDao.addAuthor(author);
    }

    public void addBook(int id, String title) {
        bookDao.addBook(new Book(id, title));
    }

    public Book getBook(int id){
        return bookDao.getBook(id);
    }

    public Author getAuthor(String name){
        return authorDao.getAuthor(name);
    }
    public List<String> getAuthorsByBook(String bookTitle){
        List <Author> authors = authorDao.getAuthorByBook(bookTitle);
        List <String> result = new ArrayList<>();
        for (Author author :authors) {
            result.add(author.getName());
        }
        return result;
    }

    public List<String> getBookByAuthor (String authorName) {
        List<Book> books = authorDao.getBookByAuthor(authorName);
        List <String> result = new ArrayList<>();
        for (Book book : books) {
            result.add(book.getTitle());
        }
        return result;
    }

    public void close(){
        authorDao.close();
        bookDao.close();
    }

}