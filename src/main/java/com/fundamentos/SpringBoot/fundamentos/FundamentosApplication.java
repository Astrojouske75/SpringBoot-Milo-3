package com.fundamentos.SpringBoot.fundamentos;

import com.fundamentos.SpringBoot.fundamentos.Bean.MyBean;
import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanWhitDependency;
import com.fundamentos.SpringBoot.fundamentos.Component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWhitDependency myBeanWhitDependency;


	public FundamentosApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency, MyBean myBean, MyBeanWhitDependency myBeanWhitDependency) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWhitDependency = myBeanWhitDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		componentDependency.saludar();
		myBean.print();
		myBeanWhitDependency.printWhitDependency();
	}

}
