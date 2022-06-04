package com.xb.sharingshpere;

import com.xb.sharingshpere.entity.Course;
import com.xb.sharingshpere.mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author xb
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJDBCTest {
  @Resource
  private CourseMapper courseMapper;

  @Test
  public void addCourse(){
    for (int i = 0; i < 10; i++) {
      final Course course  = new Course();
      course.setCstatus("1");
      course.setCname("sharing jdbc");
      course.setUserId(Long.valueOf(""+(1000+i)));
      courseMapper.insert(course);
    }
  }
}
