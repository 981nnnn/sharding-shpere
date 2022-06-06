package com.xb.shardingspheredemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xb.shardingspheredemo.mapper")
public class ShardingSphereDemoApplication {

  public static void main(final String[] args) {
    SpringApplication.run(ShardingSphereDemoApplication.class, args);
  }

}
