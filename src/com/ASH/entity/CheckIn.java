package com.ASH.entity;


import java.sql.Date;

public class CheckIn {

  private long id;
  private String name;
  private String documentType;
  private String documentNumber;
  private String gender;
  private byte[] face;
  private java.sql.Date checkinDate;
  private java.sql.Date checkoutDate;
  private String time;
  private long roomId;
  private String relatedRoom;
  private long isCheckOut;
  private String phoneNumber;

  public CheckIn(long id, String name, String documentType, String documentNumber, String gender, byte[] face, Date checkinDate, Date checkoutDate, String time, long roomId, String relatedRoom, long isCheckOut, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.documentType = documentType;
    this.documentNumber = documentNumber;
    this.gender = gender;
    this.face = face;
    this.checkinDate = checkinDate;
    this.checkoutDate = checkoutDate;
    this.time = time;
    this.roomId = roomId;
    this.relatedRoom = relatedRoom;
    this.isCheckOut = isCheckOut;
    this.phoneNumber = phoneNumber;
  }

  public CheckIn(){
    super();
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


  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }


  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public byte[] getFace() {
    return face;
  }

  public void setFace(byte[] face) {
    this.face = face;
  }


  public java.sql.Date getCheckinDate() {
    return checkinDate;
  }

  public void setCheckinDate(java.sql.Date checkinDate) {
    this.checkinDate = checkinDate;
  }


  public java.sql.Date getCheckoutDate() {
    return checkoutDate;
  }

  public void setCheckoutDate(java.sql.Date checkoutDate) {
    this.checkoutDate = checkoutDate;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }


  public String getRelatedRoom() {
    return relatedRoom;
  }

  public void setRelatedRoom(String relatedRoom) {
    this.relatedRoom = relatedRoom;
  }


  public long getIsCheckOut() {
    return isCheckOut;
  }

  public void setIsCheckOut(long isCheckOut) {
    this.isCheckOut = isCheckOut;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}
