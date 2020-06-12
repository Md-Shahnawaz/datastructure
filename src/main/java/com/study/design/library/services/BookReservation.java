package com.study.design.library.services;

import com.study.design.library.models.ReservationStatus;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public static BookReservation fetchReservationDetails(String barcode){
        return null;
    }

    public String getMemberId() {
        return memberId;
    }

    public void updateStatus(ReservationStatus status) {
        this.status = status;
    }

    public void sendBookAvailableNotification() {
    }
}
