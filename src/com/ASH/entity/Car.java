package com.ASH.entity;


public class Car {

  private long id;
  private byte[] face;
  private long isCheckin;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public byte[] getFace() {
    return face;
  }

  public void setFace(byte[] face) {
    this.face = face;
  }


  public long getIsCheckin() {
    return isCheckin;
  }

  public void setIsCheckin(long isCheckin) {
    this.isCheckin = isCheckin;
  }

}
