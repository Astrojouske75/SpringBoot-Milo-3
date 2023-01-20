package com.fundamentos.SpringBoot.fundamentos;

import com.fundamentos.SpringBoot.fundamentos.Bean.MyBean;
import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanWhitDependency;
import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanWhitProperties;
import com.fundamentos.SpringBoot.fundamentos.Component.ComponentDependency;
import com.fundamentos.SpringBoot.fundamentos.Pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWhitDependency myBeanWhitDependency;
	private MyBeanWhitProperties myBeanWhitProperties;
	private UserPojo userPojo;


	public FundamentosApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency, MyBean myBean, MyBeanWhitDependency myBeanWhitDependency, MyBeanWhitProperties myBeanWhitProperties, UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWhitDependency = myBeanWhitDependency;
		this.myBeanWhitProperties = myBeanWhitProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		componentDependency.saludar();
		myBean.print();
		myBeanWhitDependency.printWhitDependency();
		System.out.println(myBeanWhitProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword() + "-" + userPojo.getAge());
		try{
			//error
			int value = 10/0;
			LOGGER.info("Mi valor :" + value);
		} catch (Exception e) {
			LOGGER.error("Esto es un error al dividir por 0 " + e.getMessage());
		}

	}

}
