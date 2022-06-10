package com.xb.shardingspheredemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author xb
 **/
@Data
@TableName("t_dict")
public class Dict {
  private Long dictId;
  private String ustatus;
  private String uvalue;
}
