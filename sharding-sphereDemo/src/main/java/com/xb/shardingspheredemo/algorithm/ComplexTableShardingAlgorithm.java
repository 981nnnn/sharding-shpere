package com.xb.shardingspheredemo.algorithm;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author xb
 **/
public class ComplexTableShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

  @Override
  public Collection<String> doSharding(final Collection<String> collection, final ComplexKeysShardingValue<Long> complexKeysShardingValue) {
    final String logicTableName = complexKeysShardingValue.getLogicTableName();
    final Collection<Long> userIdCol = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("user_id");
    final ArrayList<String> result = new ArrayList<String>();
    for ( final Long userId : userIdCol) {
      final BigInteger userIdB = BigInteger.valueOf(userId);
      final BigInteger targetKey = userIdB.mod(new BigInteger("2")).add(new BigInteger("1"));
      result.add(logicTableName+"_"+targetKey);
    }
    return result;
  }
}
