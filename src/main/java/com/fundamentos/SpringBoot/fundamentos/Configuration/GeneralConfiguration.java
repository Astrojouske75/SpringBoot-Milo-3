package com.fundamentos.SpringBoot.fundamentos.Configuration;

import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanPropertiesImplement;
import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanWhitProperties;
import com.fundamentos.SpringBoot.fundamentos.Pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

     @Bean
    public MyBeanWhitProperties function(){
         return new MyBeanPropertiesImplement(name, apellido);
     }
}
