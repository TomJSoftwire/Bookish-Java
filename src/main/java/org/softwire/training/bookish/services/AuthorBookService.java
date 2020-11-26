package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.AuthorBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookService extends DatabaseService{

    public List<AuthorBook> getAllAuthorBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM author")
                        .mapToBean(AuthorBook.class)
                        .list()
        );
    }

    public void addAuthorBook(AuthorBook authorBook) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO authorbook (isbn, authorId) VALUES (:isbn, :authorId)")
                        .bind("isbn", authorBook.getIsbn())
                        .bind("authorId", authorBook.getAuthorId())
                        .execute()
        );
    }

    public void deleteAuthorBook(int authorId, int isbn) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM authorbook WHERE authorId = :authorId AND isbn = :isbn")
                        .bind("authorId", authorId)
                        .bind("isbn", isbn)
                        .execute()
        );
    }
}
