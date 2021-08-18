package com.xb.sharding;

import com.xb.sharding.dao.DictDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName DictDaoTest
 * @Description TODO
 * @Author xb
 * @Date 2021/8/18 13:57
 * @Version 1.0
 **/
@SpringBootTest(classes = ShardingJdbcApplication.class)
@RunWith(SpringRunner.class)
public class DictDaoTest {
  @Autowired
  DictDao dictDao;
  @Test
  public void testInsertDict(){
    dictDao.insertDict(1L,"user_type","0","管理员");
    dictDao.insertDict(2L,"user_type","1","操作员");
  }
  @Test
  public void testDeleteDict(){
    dictDao.deleteDict(1L);
    dictDao.deleteDict(2L);
  }


}
