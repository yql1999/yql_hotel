package com.ASH.entity;


public class UserReserve {

  private long id;
  private String name;
  private java.sql.Date checkinDate;
  private java.sql.Date checkoutDate;
  private String roomType;
  private java.sql.Date time;
  private String phoneNumber;


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


  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}
