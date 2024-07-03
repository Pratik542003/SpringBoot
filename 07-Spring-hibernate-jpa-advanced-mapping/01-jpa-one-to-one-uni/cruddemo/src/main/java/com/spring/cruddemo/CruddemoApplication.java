package com.spring.cruddemo;

import com.spring.cruddemo.DAO.AppDAO;
import com.spring.cruddemo.entity.Instructor;
import com.spring.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting id : "+theId);
		appDAO.deleteInstructorbyId(theId);
		System.out.println("Deleted");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorbyId(theId);
		System.out.println(tempInstructor);
	}

	private void createInstructor(AppDAO appDAO) {
		//create instructor
/*		Instructor tempInstructor= new Instructor("Chad","Dearby","chad@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/Chad",
				"love to code");
*/
		Instructor tempInstructor= new Instructor("Pratik","Dhane","pratik@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/Pratik",
				"Guitar");

		//associate
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		System.out.println("Saving instructor"+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}
}
