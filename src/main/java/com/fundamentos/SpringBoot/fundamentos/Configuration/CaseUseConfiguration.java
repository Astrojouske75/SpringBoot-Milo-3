package com.fundamentos.SpringBoot.fundamentos.Configuration;

import com.fundamentos.SpringBoot.fundamentos.Service.UserService;
import com.fundamentos.SpringBoot.fundamentos.caseUse.GetUser;
import com.fundamentos.SpringBoot.fundamentos.caseUse.GetUserImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
