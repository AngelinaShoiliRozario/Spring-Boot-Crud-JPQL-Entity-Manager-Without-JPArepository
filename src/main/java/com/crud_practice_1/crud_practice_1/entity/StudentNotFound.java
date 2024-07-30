package com.crud_practice_1.crud_practice_1.entity;

//No @entity has been used as its not related to any table of DB
//No @Table(...) and @Column has been used for the same reason

public class StudentNotFound {
    // variables 
    int status;
    long timestamp;
    String message;

    // constructor
    public StudentNotFound() {
    }

    public StudentNotFound(int status, String message, long timestamp) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

    // setter methods
    public void setStatus(int status) {
        this.status = status;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //getter methods
    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
