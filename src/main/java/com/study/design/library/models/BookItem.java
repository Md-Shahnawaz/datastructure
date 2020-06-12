package com.study.design.library.models;

import com.study.design.library.services.BookLending;

import java.util.Date;

public class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;

    public boolean checkout(String memberId) {
        if(this.getIsReferenceOnly()) {
//            ShowError("This book is Reference only and can't be issued");
            return false;
        }
        if(!BookLending.lendBook(this.getBarcode(), memberId)){
            return false;
        }
        this.updateBookItemStatus(BookStatus.LOANED);
        return true;
    }

    public void updateBookItemStatus(BookStatus loaned) {
    }


    public String getBarcode() {
        return barcode;
    }

    @Override
    protected boolean getIsReferenceOnly() {
        return false;
    }

    public void updateBookItemState(BookStatus reserved) {
    }

    public String getBarCode() {
        return null;
    }
}
