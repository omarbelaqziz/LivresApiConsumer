package com.example.apconsumer;

public class Book {

    private int id;
    private String title;
    private String author;
    private String cover;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'';
    }
}
