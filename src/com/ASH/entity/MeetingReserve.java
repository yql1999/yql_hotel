package com.ASH.entity;


public class MeetingReserve {

  private long id;
  private long meetingId;
  private String name;
  private String phoneNumber;
  private byte[] face;
  private long timePeriod;
  private String inviteCode;

  public MeetingReserve(long id, long meetingId, String name, String phoneNumber, byte[] face, long timePeriod, String inviteCode) {
    this.id = id;
    this.meetingId = meetingId;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.face = face;
    this.timePeriod = timePeriod;
    this.inviteCode = inviteCode;
  }

  public MeetingReserve(){
    super();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMeetingId() {
    return meetingId;
  }

  public void setMeetingId(long meetingId) {
    this.meetingId = meetingId;
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


  public long getTimePeriod() {
    return timePeriod;
  }

  public void setTimePeriod(long timePeriod) {
    this.timePeriod = timePeriod;
  }


  public String getInviteCode() {
    return inviteCode;
  }

  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }

}
