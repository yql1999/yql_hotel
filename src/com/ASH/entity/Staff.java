package com.ASH.entity;


public class Staff {

  private long id;
  private String name;
  private byte[] face;
  private String document_type;
  private String document_number;
  private String gender;
  private String job;

  public Staff(long id, String name, byte[] face, String document_type, String document_number, String gender, String job) {
    this.id = id;
    this.name = name;
    this.face = face;
    this.document_type = document_type;
    this.document_number = document_number;
    this.gender = gender;
    this.job = job;
  }

  public Staff(){
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

  public byte[] getFace() {
    return face;
  }

  public void setFace(byte[] face) {
    this.face = face;
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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getWork() {
    return job;
  }

  public void setWork(String job) {
    this.job = job;
  }
}
