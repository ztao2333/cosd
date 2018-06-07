package net.cosd.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
@Configuration
@MapperScan(basePackages="net.cosd.mapper") // 指定扫描的mapper接口所在的包
public class DataConfig {
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // 解决中文乱码输入问题 useUnicode=true&characterEncoding=utf8
        // 解决useSSL问题 useSSL=false
        /* 解决The server time zone value '???ú±ê×??±??' is unrecognized or represents 问题 :
            1. serverTimezone=UTC: mybatis进行MySQL操作的时候，发现输入当前数据，数据库中存储的数据总比输入的要小8个小时
                大多数资料都是设置的UTC时间，所以才出现了8个小时的时差.
            2. serverTimezone=GMT%2B8: 对于中国来说只需要将serverTimezone的值改为GMT%2B8就好了

         */
        dataSource.setUrl("jdbc:mysql://localhost:3306/cosd?useUnicode=true&characterEncoding=utf8&useSSL=false" +
                "&serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setMaxActive(10);
        dataSource.setInitialSize(2);
        dataSource.setMinIdle(2);
        dataSource.setMaxWait(6000L);
        dataSource.setTimeBetweenEvictionRunsMillis(3000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT * FROM DUAL");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        return dataSource;
    }
    // 配置事务管理器
    @Bean
    public DataSourceTransactionManager transactionManager() {
        // 注入数据库连接池
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public org.apache.ibatis.session.Configuration mybatisConfig(){
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        // 开启驼峰命名转换:Table{create_time} -> Entity{createTime}
        config.setMapUnderscoreToCamelCase(true);
        config.setAutoMappingBehavior(AutoMappingBehavior.PARTIAL);
        config.setJdbcTypeForNull(JdbcType.NULL);
        config.getTypeAliasRegistry().registerAliases("net.cosd.entity");

        return config;
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setConfiguration(mybatisConfig());
        sessionFactory.setTypeAliasesPackage("net.cosd.entity");
        //如果映射文件与java文件在同一个包中，且文件名相同，可以不用配置MapperLocations
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(patternResolver.getResources("classpath:mapping/*Mapper.xml"));
        return sessionFactory;
    }


}
