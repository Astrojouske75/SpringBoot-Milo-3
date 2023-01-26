package com.fundamentos.SpringBoot.fundamentos.Configuration;

import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanPropertiesImplement;
import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanWhitProperties;
import com.fundamentos.SpringBoot.fundamentos.Pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:Connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

     @Bean
    public MyBeanWhitProperties function(){
         return new MyBeanPropertiesImplement(name, apellido);
     }


     @Bean
    public DataSource dataSource(){
         DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
         dataSourceBuilder.driverClassName(driver);
         dataSourceBuilder.url(jdbcUrl);
         dataSourceBuilder.username(username);
         dataSourceBuilder.password(password);
         return dataSourceBuilder.build();

     }
}
