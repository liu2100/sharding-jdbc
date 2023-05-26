package org.example.db.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.example.db.utils.ConsistencyHashUtil;

import java.util.Collection;

/**
 * @author liudaojian
 */
public class DbShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        String value = preciseShardingValue.getValue().toString();
        return "ds" + ConsistencyHashUtil.find(value);
    }

}

