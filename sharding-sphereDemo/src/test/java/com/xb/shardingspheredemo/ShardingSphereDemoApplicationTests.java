package com.xb.shardingspheredemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xb.shardingspheredemo.entity.Course;
import com.xb.shardingspheredemo.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ShardingSphereDemoApplicationTests {

  @Resource
  private CourseMapper courseMapper;
  @Test
  void addCourse() {
    for (int i = 0; i < 10; i++) {
      final Course course = new Course();
//      course.setCid(Long.valueOf(i));
      course.setCname("sharding sphere");
      course.setCstatus("1");
      course.setUserId(Long.valueOf(""+100+i));
      courseMapper.insert(course);
    }
  }
  @Test
  void queryCourseByIn(){
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
//    queryWrapper.eq("cid",740232281439862784L);
//    queryWrapper.in("cid", Arrays.asList(740310060466438144L,740310059942150145L,7403100599421502145L));
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }
  @Test
  void queryCourseByRange(){
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
    queryWrapper.between("cid",740310060466438144L,740310060613238785L);
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }

  @Test
  void queryCourseByEquals(){
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
    queryWrapper.eq("cid",740310060466438144L);
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }

  @Test
  void queryCourseOrder(){
    final QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("user_id","1002");
    final List<Course> courses = courseMapper.selectList(queryWrapper);
    courses.forEach(System.out::println);
  }
}
