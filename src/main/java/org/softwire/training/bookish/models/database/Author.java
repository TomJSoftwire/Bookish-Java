package org.softwire.training.bookish.models.database;

public class Author {

    private int authorId;
    private String authorName;

    public int getAuthorId(){
        return authorId;
    }
    public void setAuthorId(int authorId){ this.authorId = authorId; }

    public String getAuthorName(){
        return authorName;
    }
    public void setAuthorId(String authorName){ this.authorName = authorName; }
}
