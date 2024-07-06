package com.spring.cruddemo;

import com.spring.cruddemo.DAO.AppDAO;
import com.spring.cruddemo.entity.*;
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

			//createCourseandStudent(appDAO);
			//findCourseandStudent(appDAO);
			//findStudentandCourse(appDAO);
			//addMoreCoursestoStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId =2;
		System.out.println("Deleting the student id: "+theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Deleted");
	}

	private void addMoreCoursestoStudent(AppDAO appDAO) {
		int theId = 1;
		Student tempStudent = appDAO.findStudentandCourseByStudentId(theId);
		//create courses
		Course temp1 = new Course("Python machine learning");
		Course temp2 = new Course("Spring framework");

		tempStudent.addCourses(temp1);
		tempStudent.addCourses(temp2);
		System.out.println("Saving student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("Updated");


	}

	private void findStudentandCourse(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding student");

		Student temp = appDAO.findStudentandCourseByStudentId(theId);
		System.out.println("Student: "+temp);
		System.out.println("Course associated with student"+temp.getCourses());
	}

	private void findCourseandStudent(AppDAO appDAO) {
		int theId = 10;
		Course temp = appDAO.findCourseandStudentByCourseId(theId);

		System.out.println("Course is: "+temp);
		System.out.println("Student associated with the Course "+temp.getStudents());
	}

	private void createCourseandStudent(AppDAO appDAO) {
		//create course
		Course tempcourse =new Course("Java the reference");

		//create the students
		Student tempStudent1 = new Student("Pratik","Dhane","pratik@gmail.com");
		Student tempStudent2 = new Student("Dhanraj","Shelke","dhanraj@gmail.com");

		//add students to course
		tempcourse.addStudent(tempStudent1);
		tempcourse.addStudent(tempStudent2);

		appDAO.save(tempcourse);
		System.out.println("course and student saved in db");


		//save the course and associated student

	}










	private void deleteCourseandReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting/....");
		appDAO.deleteCoursebyId(id);
	}

	private void retireveCourseandReviews(AppDAO appDAO) {
		int theID =10;
		Course temp = appDAO.findCourseandReviewByCourseId(theID);
		System.out.println(temp);
		System.out.println(temp.getReviews());

	}

	private void createCourseandReview(AppDAO appDAO) {
		//create a course
			Course temp = new Course("Intro to C");
		//add some review
		temp.addReview(new Review("Great course"));
		temp.addReview(new Review("Cool course, job well done"));
		temp.addReview(new Review("What a dumb course"));

		//save the course
		System.out.println("Save");
		appDAO.save(temp);

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
