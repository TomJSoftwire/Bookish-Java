package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService extends DatabaseService{

    public List<BookCopy> getAllBookCopies() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookcopy")
                        .mapToBean(BookCopy.class)
                        .list()
        );
    }

    public void addBookCopy(BookCopy bookCopy) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO bookcopy (copyId, isbn) VALUES (:copyId, :isbn)")
                        .bind("copyId", bookCopy.getCopyId())
                        .bind("isbn", bookCopy.getIsbn())
                        .execute()
        );
    }

    public void deleteBookCopy(int copyId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM bookcopy WHERE copyId = :copyId")
                        .bind("copyId", copyId)
                        .execute()
        );
    }
}
