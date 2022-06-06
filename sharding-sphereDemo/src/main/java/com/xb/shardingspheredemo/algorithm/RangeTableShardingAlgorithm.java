package com.xb.shardingspheredemo.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author xb
 **/
public class RangeTableShardingAlgorithm implements RangeShardingAlgorithm<Long> {
  /**
   * 实现分片算法
   * @param collection
   * @param rangeShardingValue
   * @return
   */
  @Override
  public Collection<String> doSharding(final Collection<String> collection, final RangeShardingValue<Long> rangeShardingValue) {
    final Range<Long> valueRange = rangeShardingValue.getValueRange();
    final Long upperValue = valueRange.upperEndpoint();
    final Long lowerValue = valueRange.lowerEndpoint();
    final String logicTableName = rangeShardingValue.getLogicTableName();
    return Arrays.asList(logicTableName+"_1",logicTableName+"_2");
  }
}
