package com.xb.sharding;

import com.xb.sharding.dao.OrderDao;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderDaoTest
 * @Description TODO
 * @Author xb
 * @Date 2021/8/15 23:46
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class OrderDaoTest {

  @Autowired
  private OrderDao orderDao;

  @Test
  public void testInsertOrder(){
    for (int i = 0; i < 10; i++) {
      orderDao.insertOrder(new BigDecimal((i+1)*5),1L,"WAIT_PAY");
    }
  }

  @Test
  public void testSelectOrderbyIds(){
    final List<Long> ids = new ArrayList<>();
    ids.add(373771636085620736L);
    ids.add(373771635804602369L);
    final List<Map> maps = orderDao.selectOrderbyIds(ids);
    System.out.println(maps);
  }

  @Test
  public void testInsertOrder_2(){
    for (int i = 0 ; i<10; i++){
      orderDao.insertOrder(new BigDecimal((i+1)*5),1L,"WAIT_PAY");
    }
    for (int i = 0 ; i<10; i++){
      orderDao.insertOrder(new BigDecimal((i+1)*10),2L,"WAIT_PAY");
    }
  }
  @Test
  public void testSelectOrderbyUserAndIds(){
    List<Long> orderIds = new ArrayList<>();
    orderIds.add(373422416644276224L);
    orderIds.add(373422415830581248L);
    //查询条件中包括分库的键user_id
    int user_id = 1;
    List<Map> orders = orderDao.selectOrderbyUserAndIds(user_id,orderIds);
    System.out.println(orders);
  }


}
