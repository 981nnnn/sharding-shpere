package com.xb.shardingspheredemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xb.shardingspheredemo.entity.Course;
import com.xb.shardingspheredemo.entity.Dict;
import com.xb.shardingspheredemo.entity.Order;
import com.xb.shardingspheredemo.entity.User;
import com.xb.shardingspheredemo.mapper.CourseMapper;
import com.xb.shardingspheredemo.mapper.DictMapper;
import com.xb.shardingspheredemo.mapper.OrdersMapper;
import com.xb.shardingspheredemo.mapper.UserMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ShardingSphereDemoApplicationTests {

  @Resource
  private CourseMapper courseMapper;
  @Autowired
  private DictMapper dictMapper;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private OrdersMapper ordersMapper;

  @Test
  void addCourse() {
    for (int i = 0; i < 10; i++) {
      final Course course = new Course();
//      course.setCid(Long.valueOf(i));
      course.setCname("sharding sphere");
      course.setCstatus("1");
      course.setUserId(Long.valueOf("" + 100 + i));
      courseMapper.insert(course);
    }
  }

  @Test
  void queryCourseByIn() {
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
    queryWrapper.eq("cid", 740232281439862784L);
    queryWrapper.in("cid", Arrays.asList(740310060466438144L, 740310059942150145L, 7403100599421502145L));
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }

  @Test
  void queryCourseByRange() {
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
    queryWrapper.between("cid", 740310060466438144L, 740310060613238785L);
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }

  @Test
  void queryCourseByEquals() {
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
    queryWrapper.eq("cid", 740310060466438144L);
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }

  @Test
  void queryCourseOrder() {
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("user_id", "1002");
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }

  @Test
  void queryCourseComplex() {
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
    queryWrapper.in("cid", Arrays.asList(740310060466438144L, 740310060613238785L));
    queryWrapper.eq("user_id", 1001L);
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }

  @Test
  void queryCourseHint() {
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
    // hint 不支持union，多层子查询，函数计算
    final HintManager hintManager = HintManager.getInstance();
    hintManager.addTableShardingValue("course", 2);
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
    hintManager.close();
  }

  @Test
  void findDict(){
    final QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
    dictMapper.selectList(queryWrapper).forEach(System.out::println);
  }



  @Test
  public void addDict() {

    final Dict dict = new Dict();
//    dict.setDictId(Long.valueOf("1"));
    dict.setUstatus("1");
    dict.setUvalue("异常");
    dictMapper.insert(dict);

    final Dict dict1 = new Dict();
//    dict1.setDictId(Long.valueOf("2"));
    dict1.setUstatus("0");
    dict1.setUvalue("正常");
    dictMapper.insert(dict1);

    for (int i = 0; i < 10; i++) {
      final User user = new User();
      user.setUsername("user"+i);
      user.setUstatus(i%2+"");
      user.setUage(i);
      userMapper.insert(user);
    }
  }

  @Test
  void addDict_1(){
    for (int i = 0; i < 10; i++) {
      final Dict dict = new Dict();
      dict.setUvalue("normal");
      dict.setUstatus("1");
      dict.setDictId(Long.valueOf(i+""+100));
      dictMapper.insert(dict);
    }
  }
  @Test
  void addUser(){

  }

  @Test
  void queryUserStatus(){
    final List<User> users = userMapper.queryUserStatus();
    users.forEach(System.out::println);
  }

  @Test
   void masterSlaveDict(){
    for (int i = 0;i  < 10; i++) {
      final Dict dict = new Dict();
      dict.setUstatus(""+(i%2));
      dict.setUvalue("normal");
      dictMapper.insert(dict);
    }
  }

  @Test
   void queryMasterSlaveDict(){
      final QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
      dictMapper.selectList(queryWrapper).forEach(System.out::println);
  }

  @Test
  void updateMasterSlaveDict(){
    final QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("dict_id",742787454561419265L);
    final Dict dict = new Dict();
    dict.setUvalue("unNormal");
    dictMapper.update(dict,queryWrapper);
  }

  @Test
  void insertOrder(){
    for (int i = 0; i < 10; i++) {
      final Order orders = new Order();
      orders.setOrderType(i);
      orders.setCustomerId(i);
      orders.setAmount(Double.valueOf(i+""));
      ordersMapper.insert(orders);
    }
  }
  @Test
  void findOrder(){
    final QueryWrapper queryWrapper = new QueryWrapper();
    queryWrapper.eq("customer_id",2);
    ordersMapper.selectList(queryWrapper).forEach(System.out::println);
  }
  @Test
  public void test(){
    System.out.println("");
  }

}
