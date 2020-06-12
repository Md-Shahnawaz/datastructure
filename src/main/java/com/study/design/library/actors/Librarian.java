package com.study.design.library.actors;

import com.study.design.library.models.BookItem;

public class Librarian extends Account {

    public boolean addBookItem(BookItem bookItem){
        return true;
    }

    public boolean blockMember(Member member){
        return true;
    }

    public boolean unBlockMember(Member member){
        return true;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
