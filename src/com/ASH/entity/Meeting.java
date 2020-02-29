package com.ASH.entity;


public class Meeting {

  private long id;
  private String meetingNumber;
  private long typeId;
  private String state;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMeetingNumber() {
    return meetingNumber;
  }

  public void setMeetingNumber(String meetingNumber) {
    this.meetingNumber = meetingNumber;
  }


  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
