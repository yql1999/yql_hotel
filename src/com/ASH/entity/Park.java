package com.ASH.entity;


public class Park {

  private long id;
  private long carId;
  private java.sql.Date parkTime;
  private java.sql.Date leaveTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCarId() {
    return carId;
  }

  public void setCarId(long carId) {
    this.carId = carId;
  }


  public java.sql.Date getParkTime() {
    return parkTime;
  }

  public void setParkTime(java.sql.Date parkTime) {
    this.parkTime = parkTime;
  }


  public java.sql.Date getLeaveTime() {
    return leaveTime;
  }

  public void setLeaveTime(java.sql.Date leaveTime) {
    this.leaveTime = leaveTime;
  }

}
