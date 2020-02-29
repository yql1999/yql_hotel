package com.ASH.entity;


public class CheckOut {

  private long id;
  private long roomId;
  private double price;
  private java.sql.Date checkinDate;
  private java.sql.Date checkoutDate;
  private java.sql.Date time;
  private String name;
  private long documentType;
  private String documentNumber;
  private long checkinId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getDocumentType() {
    return documentType;
  }

  public void setDocumentType(long documentType) {
    this.documentType = documentType;
  }


  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }


  public long getCheckinId() {
    return checkinId;
  }

  public void setCheckinId(long checkinId) {
    this.checkinId = checkinId;
  }

}
