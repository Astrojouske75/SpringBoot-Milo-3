package com.fundamentos.SpringBoot.fundamentos;

import com.fundamentos.SpringBoot.fundamentos.Bean.MyBean;
import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanWhitDependency;
import com.fundamentos.SpringBoot.fundamentos.Bean.MyBeanWhitProperties;
import com.fundamentos.SpringBoot.fundamentos.Component.ComponentDependency;
import com.fundamentos.SpringBoot.fundamentos.Entity.User;
import com.fundamentos.SpringBoot.fundamentos.Pojo.UserPojo;
import com.fundamentos.SpringBoot.fundamentos.Repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWhitDependency myBeanWhitDependency;
	private MyBeanWhitProperties myBeanWhitProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;


	public FundamentosApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency, MyBean myBean, MyBeanWhitDependency myBeanWhitDependency, MyBeanWhitProperties myBeanWhitProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWhitDependency = myBeanWhitDependency;
		this.myBeanWhitProperties = myBeanWhitProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		//clasesAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		/*LOGGER.info("Usuario con el metodo findByUserEmail" + userRepository.findByUserEmail("Camilo@domain.com")
				.orElseThrow(()-> new RuntimeException(("No se encontro ni chimba jaja revise el puto codigo"))));


		userRepository.findAndSort("J", Sort.by("id")
			 .descending()).stream().forEach(user -> LOGGER.info("Usuario con metodo sort"+user));

		userRepository.findByName("Elena")
			.stream()
				.forEach(user -> LOGGER.info("Usuario con query method" + user));

		LOGGER.info("Usuario con query method" + userRepository.findByEmailAndName("Gabriela@domain.com", "Gabriela")
			.orElseThrow(()-> new RuntimeException("Usuario no encontrado jaja xd")));

		userRepository.findByNameLike("%J%")
			.stream().forEach(user -> LOGGER.info("Usuario FindByNameLike " + user));

		userRepository.findByNameOrEmail("Camilo","")
				.stream().forEach(user -> LOGGER.info("Usuario findByNameOrEmail " + user));*/

		userRepository.findByBirthDateBetween(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 5, 28))
				.stream().forEach(user -> LOGGER.info("Usuarios con intervalos de fechas: "+ user));

		userRepository.findByNameContainingOrderByIdDesc("%J%")
				.stream().forEach(user -> LOGGER.info("Usuario encontrado con like y ordenado " + user ));
	}

	private void saveUsersInDataBase(){
		User user1 = new User("Jhon", "Jhon@domain.com", LocalDate.of(2023, 1, 24));
		User user2 = new User("Juan", "Juancho@domain.com", LocalDate.of(2023, 10, 12));
		User user3 = new User("Julian", "Julian@domain.com", LocalDate.of(2023, 4, 28));
		User user4 = new User("Juliana", "Juliana@domain.com", LocalDate.of(2023, 11, 28));
		User user5 = new User("Juana", "Juana@domain.com", LocalDate.of(2023, 5, 16));
		User user6 = new User("Gabriela", "Gabriela@domain.com", LocalDate.of(2023, 2, 20));
		User user7 = new User("Javier", "Javier@domain.com", LocalDate.of(2023, 6, 10));
		User user8 = new User("Rafael", "Rafael@domain.com", LocalDate.of(2023, 4, 29));
		User user9 = new User("Elena", "Elena@domain.com", LocalDate.of(2023, 7, 31));
		User user10 = new User("Camilo", "Camilo@domain.com", LocalDate.of(2023, 1, 3));
		List<User> list= Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		list.stream().forEach(userRepository::save);
	}



	private void clasesAnteriores(){
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
