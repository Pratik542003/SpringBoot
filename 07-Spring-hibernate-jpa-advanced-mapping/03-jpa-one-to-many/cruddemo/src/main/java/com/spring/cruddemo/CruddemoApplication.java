package com.spring.cruddemo;

import com.spring.cruddemo.DAO.AppDAO;
import com.spring.cruddemo.entity.Course;
import com.spring.cruddemo.entity.Instructor;
import com.spring.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//deleteInstructor(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorwithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//fidnInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			deleteCourse(appDAO);
			};
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding the id: "+id);
		Course course = appDAO.findCoursebyId(id);
		System.out.println(course);
		appDAO.deleteCoursebyId(id);
		System.out.println("Deleted");

	}

	private void updateCourse(AppDAO appDAO){
		int theId =10;
		System.out.println("Finding course for id: "+theId);
		Course course = appDAO.findCoursebyId(theId);
		System.out.println("Updating course for id: "+theId);
		course.setTitle("Internet of Things");
		appDAO.updateCourse(course);
		System.out.println("Done");

	}
	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("find instructor id:"+theId);
		Instructor tempInstructor = appDAO.findInstructorbyId(theId);
		tempInstructor.setLastName("Dhane");
		appDAO.update(tempInstructor);
		System.out.println("Done!");
	}

	private void fidnInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId =1;
		System.out.println("Finding the instructor: "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempinstructor: "+tempInstructor);
		System.out.println("The Associated course : "+tempInstructor.getCourses());
		System.out.println("done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the instructor: "+theId);
		Instructor tempInstructor = appDAO.findInstructorbyId(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		//FIND COURSE FOR ISNTRUCTOR

		List<Course> courses = appDAO.findCourseByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("the associated course "+tempInstructor.getCourses());
		System.out.println("Done");

	}


	private void findInstructorwithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the instructor: "+theId);
		Instructor tempInstructor = appDAO.findInstructorbyId(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("tempInstructor course is : "+tempInstructor.getCourses()) ;
		System.out.println("Done");
	}




	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor= new Instructor("Susan","Public","susan@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/Susan",
				"Gamer");

		//associate
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse1 = new Course("Air Title-The Ultimate Guide");
		Course tempCourse2 = new Course("Java Masterclass");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//Save the instructor
		System.out.println("Saving the Instructor: "+tempInstructor);
		System.out.println("The Courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Courses saved due to cascading type");

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
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
