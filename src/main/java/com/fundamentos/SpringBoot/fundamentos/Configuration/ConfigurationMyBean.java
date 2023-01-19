package com.fundamentos.SpringBoot.fundamentos.Configuration;

import com.fundamentos.SpringBoot.fundamentos.Bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMyBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWhitDependency beanOperationOperationDependecy(MyOperation myOperation){
        return new MybeanWhitDependencyImplement(myOperation);
    }
}