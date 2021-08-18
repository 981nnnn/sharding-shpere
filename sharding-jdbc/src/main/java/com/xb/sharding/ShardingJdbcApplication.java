package com.xb.sharding;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName ShardingJdbcApplication
 * @Description TODO
 * @Author xb
 * @Date 2021/8/15 23:43
 * @Version 1.0
 **/
@SpringBootApplication(exclude = { DruidDataSourceAutoConfigure.class})
@MapperScan("com.xb.sharding.dao")
public class ShardingJdbcApplication {
  public static void main(final String[] args) {
      SpringApplication.run(ShardingJdbcApplication.class, args);
  }
}
