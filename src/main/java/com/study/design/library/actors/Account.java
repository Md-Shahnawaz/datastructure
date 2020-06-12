package com.study.design.library.actors;

// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

import com.study.design.library.models.AccountStatus;
import com.study.design.library.models.Person;

public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public abstract boolean resetPassword();

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }
}
