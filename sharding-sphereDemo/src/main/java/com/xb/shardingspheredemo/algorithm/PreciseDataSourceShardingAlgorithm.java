package com.xb.shardingspheredemo.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @Author xb
 **/
public class PreciseDataSourceShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
  @Override
  public String doSharding(final Collection<String> collection, final PreciseShardingValue<Long> preciseShardingValue) {
    final String logicTableName = preciseShardingValue.getLogicTableName();
    final Long value = preciseShardingValue.getValue();
    final String columnName = preciseShardingValue.getColumnName();
    final BigInteger shardingValue = BigInteger.valueOf(value);
    // cid % 2 + 1
    final BigInteger mod = shardingValue.mod(new BigInteger("2")).add(new BigInteger("1"));
    final String key = "m" + mod.intValue();
    if(collection.contains(key)) {
      return key;
    }
    throw new UnsupportedOperationException("route "+key + "is not supported ,please check your config。");
  }
}
