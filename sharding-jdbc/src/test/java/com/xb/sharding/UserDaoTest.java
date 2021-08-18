package com.xb.sharding;

import com.xb.sharding.dao.UserDao;
import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author xb
 * @Date 2021/8/18 13:34
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class UserDaoTest {
  @Autowired
  UserDao userDao;
  @Test
  public void testInsertUser(){
    for (int i = 0 ; i<10; i++){
      final Long id = i + 1L;
      userDao.insertUser(id,"姓名"+ id );
    }
  }
  @Test
  public void testSelectUserbyIds(){
    final List<Long> userIds = new ArrayList<>();
    userIds.add(1L);
    userIds.add(2L);
    final List<Map> users = userDao.selectUserbyIds(userIds);
    System.out.println(users);
  }
  @Test
  public void testSelectUserInfobyIds(){
    final List<Long> userIds = new ArrayList<>();
    userIds.add(1L);
    userIds.add(2L);
    final List<Map> users = userDao.selectUserInfobyIds(userIds);
    final JSONArray jsonUsers = new JSONArray(users);
    System.out.println(jsonUsers);
  }
}
