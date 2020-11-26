package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Genre;
import org.softwire.training.bookish.models.database.GenreBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreBookService extends DatabaseService{

    public List<GenreBook> getAllGenreBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM genrebook")
                        .mapToBean(GenreBook.class)
                        .list()
        );
    }

    public void addGenreBook(GenreBook genreBook) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO genre (genreId, genreName, ageRange) VALUES (:genreId, :genreName, :ageRange)")
                        .bind("genreId", genreBook.getGenreId())
                        .bind("genreName", genreBook.getIsbn())
                        .execute()
        );
    }

    public void deleteGenreBook(int genreBookId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM genreBook WHERE genreBookId = :genreBookId")
                        .bind("genreBookId", genreBookId)
                        .execute()
        );
    }
}
