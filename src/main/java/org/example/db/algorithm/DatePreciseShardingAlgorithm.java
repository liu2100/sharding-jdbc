package org.example.db.algorithm;

import cn.hutool.core.date.DateUtil;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * @author liudaojian
 * Date: 2023/5/26 14:12
 * Description:
 */
public class DatePreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    /**
     * 精确匹配查询
     *
     * @param tbNames       数据库中所有的事实表
     * @param shardingValue 分片相关信息
     * @return 返回匹配的数据源
     */
    @Override
    public String doSharding(Collection<String> tbNames, PreciseShardingValue<String> shardingValue) {

        String logicTableName = shardingValue.getLogicTableName();
        // 匹配满足当前分片规则的表名称
        Date date = DateUtil.parseDate(shardingValue.getValue());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        String monthStr = month >= 10 ? month + "" : "0" + month;
        String value = year + monthStr;

        return logicTableName + "_" + value;

    }

}
