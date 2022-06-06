package com.xb.shardingspheredemo.entity;

/**
 * @Author xb
 **/
public class Course {
  private Long cid;
  private String cname;
  private Long userId;
  private String cstatus;

  public Long getCid() {
    return cid;
  }

  public void setCid(final Long cid) {
    this.cid = cid;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(final String cname) {
    this.cname = cname;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public String getCstatus() {
    return cstatus;
  }

  public void setCstatus(final String cstatus) {
    this.cstatus = cstatus;
  }

  @Override
  public String toString() {
    return "Course{" +
        "cid=" + cid +
        ", cname='" + cname + '\'' +
        ", userId=" + userId +
        ", cstatus='" + cstatus + '\'' +
        '}';
  }
}
