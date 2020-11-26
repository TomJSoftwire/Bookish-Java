package org.softwire.training.bookish.models.database;

public class BookCopy {

    private int copyId;
    private int isbn;

    public int getCopyId(){
        return copyId;
    }
    public void setCopyId(int copyId){ this.copyId = copyId; }

    public int getIsbn(){
        return isbn;
    }
    public void setIsbn(int isbn){ this.isbn = isbn; }
}
