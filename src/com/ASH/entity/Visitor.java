package com.ASH.entity;


import java.sql.Date;

public class Visitor {

    private long id;
    private String name;
    private String phoneNumber;
    private byte[] face;
    private long roomId;
    private String power;
    private String document_type;
    private String document_number;
    private java.sql.Date visit_date;

    public Visitor() {
        super();
    }

    public Visitor(String name, String phoneNumber, byte[] face, long roomId, String power, String document_type, String document_number, java.sql.Date visit_date) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.face = face;
        this.roomId = roomId;
        this.power = power;
        this.document_type = document_type;
        this.document_number = document_number;
        this.visit_date = visit_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public byte[] getFace() {
        return face;
    }

    public void setFace(byte[] face) {
        this.face = face;
    }


    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }


    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }


    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public java.sql.Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(java.sql.Date visit_date) {
        this.visit_date = visit_date;
    }
}
