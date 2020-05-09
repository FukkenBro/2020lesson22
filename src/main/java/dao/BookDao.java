package dao;

import Models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookDao {

    private SessionFactory sessionFactory;

    public BookDao() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addBook(Book book) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }

    public Book getBook(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Book book = session.createQuery("From Book WHERE id = :id ", Book.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
            return book;
        }
    }

    public void close() {
        sessionFactory.close();
    }
}
