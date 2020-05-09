package dao;

import Models.Author;
import Models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AuthorDao {

    private SessionFactory sessionFactory;

    public AuthorDao() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addAuthor(Author author) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }

    public List<Author> getAuthorByBook(String bookTitle) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT authors from Book where lower(book_title)= lower (:bookTitle)")
                    .setParameter("bookTitle", bookTitle)
                    .list();
        }
    }

    public List<Book> getBookByAuthor(String authorName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT books from Author where lower (name) = lower (:authorName)")
                    .setParameter("authorName", authorName)
                    .list();
        }
    }

    public Author getAuthor(String name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Author author = session.createQuery("From Author WHERE name = :name ", Author.class)
                    .setParameter("name", name)
                    .getSingleResult();
            transaction.commit();
            return author;
        }
    }

    public void close() {
        sessionFactory.close();
    }
}