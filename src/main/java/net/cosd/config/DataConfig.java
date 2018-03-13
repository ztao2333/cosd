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

        //dataSource.setDriverClassName("com.mysql.jdbc.Driver.class");
        dataSource.setUrl("jdbc:mysql://118.89.163.181:3306/cosd?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql666");
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

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public org.apache.ibatis.session.Configuration mybatisConfig(){
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();

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