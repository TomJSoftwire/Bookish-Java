package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService extends DatabaseService{

    public List<Author> getAllAuthors() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM author")
                        .mapToBean(Author.class)
                        .list()
        );
    }

    public void addAuthor(Author author) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO author (authorName, authorId) VALUES (:authorName, :authorId)")
                        .bind("name", author.getAuthorName())
                        .bind("logoUrl", author.getAuthorId())
                        .execute()
        );
    }

    public void deleteAuthor(int authorId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM author WHERE authorId = :authorId")
                        .bind("authorId", authorId)
                        .execute()
        );
    }
}
