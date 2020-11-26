package org.softwire.training.bookish.models.database;

public class AuthorBook {

    private int isbn;
    private int authorId;

    public int getIsbn(){
        return isbn;
    }
    public void setIsbn(int isbn){ this.isbn = isbn; }

    public int getAuthorId(){
        return authorId;
    }
    public void setAuthorId(int authorId){ this.authorId = authorId; }
}
