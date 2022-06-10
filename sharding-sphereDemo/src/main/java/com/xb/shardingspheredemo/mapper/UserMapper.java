package com.xb.shardingspheredemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xb.shardingspheredemo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author xb
 **/
public interface UserMapper extends BaseMapper<User> {

  @Select("select u.user_id, u.username, d.uvalue ustatus from user u left join t_dict d on u.ustatus = d.ustatus")
  public List<User> queryUserStatus();
}
