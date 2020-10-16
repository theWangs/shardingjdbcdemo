package com.wang.shardingjdbcdemo.config;

import com.wang.shardingjdbcdemo.support.DynamicDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.HintShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: meng
 * @Date: 2020-10-09 10:58
 */
@Configuration
public class DataSourceConfig {

    static Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    public static final DatabaseShardingAlgorithm databaseShardingAlgorithm = new DatabaseShardingAlgorithm();

    public static final Pattern pattern = Pattern.compile("-(\\d+)-");

    @Value("${spring.shardingsphere.props.sql.show}")
    private boolean shardingJdbcShowSql;

    @Bean(name = "defaultDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.default")
    public DataSource defaultDataSource() {
        HikariDataSource defaultDataSource = new HikariDataSource();
        return defaultDataSource;
    }

    @Bean(name = "configDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sharding")
    public DataSource configDataSource() {
        HikariDataSource shardingDataSource = new HikariDataSource();
        return shardingDataSource;
    }

    /**
     * 设置动态数据源，通过@Primary 来确定主DataSource
     * @return
     */
    @Bean(name = "dataSource")
    @Primary
    public DataSource createDynamicdataSource(@Qualifier("defaultDataSource") DataSource defaultDataSource, @Qualifier("shardingDataSource") DataSource shardingDataSource){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);
        //配置多数据源
        Map<Object, Object> map = new HashMap<>();
        map.put("defaultDataSource",defaultDataSource);
        map.put("shardingDataSource",shardingDataSource);
        dynamicDataSource.setTargetDataSources(map);
        return  dynamicDataSource;
    }


    @Bean(name = "shardingDataSource")
    public DataSource shardingDataSource() throws Exception {
        Map<String, DataSource> dataMap = new LinkedHashMap<>();
        dataMap.put("ds_0", configDataSource());

        TableRuleConfiguration UserRuleConfiguration = new TableRuleConfiguration("user", "ds_${0}.user_${1..12}");
        UserRuleConfiguration.setTableShardingStrategyConfig(new HintShardingStrategyConfiguration(new OrderHintShardingAlgorithm()));


        // 配置分库规则
        // userRuleConfiguration.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("village_code", databaseShardingAlgorithm));
        // Sharding全局配置
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        shardingRuleConfiguration.getTableRuleConfigs().add(UserRuleConfiguration);
        // 创建数据源
        Properties properties = new Properties();
        //开启打印sql  true
        properties.put("sql.show",shardingJdbcShowSql);
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataMap, shardingRuleConfiguration, properties);
        return dataSource;
    }

    static class DatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
        @Override
        public String doSharding(Collection<String> databaseNames, PreciseShardingValue<Long> shardingValue) {
            log.error("database:{}", databaseNames);
            for (String database : databaseNames) {
                log.error("db:{}", database);
                return database;
            }
            return "";
        }
    }

    /**
     * hint分片策略
     */
    static class OrderHintShardingAlgorithm implements HintShardingAlgorithm {

        /**
         *
         * @param tablesNames
         * @param hintShardingValue
         * @return
         */
        @Override
        public Collection<String> doSharding(Collection tablesNames, HintShardingValue hintShardingValue) {
            log.error("hintShardingValue:{}, tablesNames:{}", hintShardingValue, tablesNames);

            List<String> tables = new ArrayList<>();
            List<String> values = new ArrayList<>(hintShardingValue.getValues());
            if(values.size() > 0){
                String date = values.get(0);
                if(StringUtils.isNotBlank(date)){
                    for (Object tablesName : tablesNames) {
                        String  name = (String ) tablesName;
                        Matcher matcher = pattern.matcher(date);
                        String suffix = null;
                        if(matcher.find()){
                            suffix = Integer.valueOf(matcher.group(1))+"";
                        }
                        //截取表名中的月份
                        String month = name.substring(name.lastIndexOf("_") + 1);
                        if(month.equals(suffix)){
                            tables.add(name);
                        }
                    }
                }else {
                    tables.addAll(tablesNames);
                }
            }else {
                tables.addAll(tablesNames);
            }
            log.error("tables:{}", tables);
            return tables;
        }
    }

}
