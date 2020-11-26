package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends DatabaseService{

    public List<Book> getAllAuthorBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void addBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO book (isbn, title) VALUES (:isbn, :title)")
                        .bind("isbn", book.getIsbn())
                        .bind("title", book.getTitle())
                        .execute()
        );
    }

    public void deleteBook(int isbn) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM book WHERE isbn = :isbn")
                        .bind("isbn", isbn)
                        .execute()
        );
    }
}
