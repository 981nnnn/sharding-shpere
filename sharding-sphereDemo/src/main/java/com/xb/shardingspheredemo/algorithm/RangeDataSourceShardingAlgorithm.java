package com.xb.shardingspheredemo.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author xb
 **/
public class RangeDataSourceShardingAlgorithm implements RangeShardingAlgorithm {
  @Override
  public Collection<String> doSharding(final Collection collection, final RangeShardingValue rangeShardingValue) {
    final Range<Long> valueRange = rangeShardingValue.getValueRange();
    final Long upperValue = valueRange.upperEndpoint();
    final Long lowerValue = valueRange.lowerEndpoint();
    final String logicTableName = rangeShardingValue.getLogicTableName();
    return Arrays.asList("m1","m2");
  }
}
