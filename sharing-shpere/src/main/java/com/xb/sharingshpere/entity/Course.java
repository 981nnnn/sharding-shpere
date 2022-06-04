package com.xb.sharingshpere.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author xb
 **/
@Data
@ToString
public class Course {
  private Long cid;
  private String cname;
  private Long userId;
  private String cstatus;
}
