package com.study.design.library.models;

public abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
//    private List<Author> authors;

    protected abstract boolean getIsReferenceOnly();
}
