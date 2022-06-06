package com.xb.shardingspheredemo.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author xb
 **/
public class HintTableShardingAlgorithm implements HintShardingAlgorithm<Integer> {

  @Override
  public Collection<String> doSharding(final Collection<String> collection, final HintShardingValue<Integer> hintShardingValue) {
    final Collection<Integer> values = hintShardingValue.getValues();
    final ArrayList<String> result = new ArrayList<>();
    for (final Integer value : values) {
     final String key =  hintShardingValue.getLogicTableName()+"_"+value;
      if (collection.contains(key)) {
        result.add(key);
      }
    }
    return result;
  }
}
