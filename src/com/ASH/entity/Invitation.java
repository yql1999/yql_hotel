package com.ASH.entity;


public class Invitation {

  private long id;
  private long roomId;
  private java.sql.Date time;
  private String inviteCode;
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


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }


  public String getInviteCode() {
    return inviteCode;
  }

  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }


  public long getCheckinId() {
    return checkinId;
  }

  public void setCheckinId(long checkinId) {
    this.checkinId = checkinId;
  }

}
