package com.xb.shardingspheredemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author xb
 **/
@TableName("t_order")
public class Order {
  private Long id;
  private Integer orderType;
  private Integer customerId;
  private Double amount;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Integer getOrderType() {
    return orderType;
  }

  public void setOrderType(final Integer orderType) {
    this.orderType = orderType;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(final Integer customerId) {
    this.customerId = customerId;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(final Double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Orders{" +
        "id=" + id +
        ", orderType=" + orderType +
        ", customerId=" + customerId +
        ", amount=" + amount +
        '}';
  }
}
