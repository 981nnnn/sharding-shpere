package com.xb.shardingspheredemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author xb
 **/
@Data
@TableName("user")
public class User {
  private Long userId;
  private String username;
  private String ustatus;
  private int uage;
}
