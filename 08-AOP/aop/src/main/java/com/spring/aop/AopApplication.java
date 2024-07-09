package com.spring.aop;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,MemberShipDAO theMemberDAO){
		return runner->{
			demoTheBeforeAdvice(theAccountDAO,theMemberDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MemberShipDAO theMemberDAO) {
		//call the business method
		Account myAccount = new Account();

		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.addAccount1();

		theMemberDAO.addAccount();
		theMemberDAO.goToSleep();

//		//re-run the method
//		System.out.println("Re-running the method");
//		theAccountDAO.addAccount();
	}
}
