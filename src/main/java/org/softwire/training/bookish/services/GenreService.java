package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService extends DatabaseService{

    public List<Genre> getAllGenres() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM genre")
                        .mapToBean(Genre.class)
                        .list()
        );
    }

    public void addGenre(Genre genre) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO genre (genreId, genreName, ageRange) VALUES (:genreId, :genreName, :ageRange)")
                        .bind("genreId", genre.getGenreId())
                        .bind("genreName", genre.getGenreName())
                        .bind("ageRange",genre.getAgeRange())
                        .execute()
        );
    }

    public void deleteGenre(int genreId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM genre WHERE genreId = :genreId")
                        .bind("genreId", genreId)
                        .execute()
        );
    }
}
