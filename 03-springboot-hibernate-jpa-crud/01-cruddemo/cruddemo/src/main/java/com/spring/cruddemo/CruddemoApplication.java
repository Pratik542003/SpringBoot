package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDAO;
import com.spring.cruddemo.entity.Student;
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
	//executed after spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryforStudent(studentDAO);
			//queryforStudentbyLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all student");
		int numsdeleted = studentDAO.deleteAll();
		System.out.println("No of rows deleted "+numsdeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentid = 2;
		System.out.println("Deleting the id "+studentid);
		studentDAO.delete(studentid);
	}

	private void updateStudent(StudentDAO studentDAO) {
	//retrieve the student based on id
		int studentId=1;
		Student myStudent = studentDAO.findById(studentId);

		//change the first name
		System.out.println("Update the student");
		myStudent.setFirstName("John");

		//update the student
		studentDAO.update(myStudent);

		//display
		System.out.println("Upadated name is "+ myStudent);
	}

	private void queryforStudentbyLastName(StudentDAO studentDAO) {
		//get list
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		//display students
		for(Student student :theStudents){
			System.out.println(student);
		}
	}

	private void queryforStudent(StudentDAO studentDAO) {
		//get a list of student
		List<Student> theStudents = studentDAO.findAll();

		//display list of student
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		Student tempstudent = new Student("pratik","dhane","dhane@gmail.com");

		//save the object
		studentDAO.save(tempstudent);

		//display id of the student
		int theId = tempstudent.getId();
		System.out.println("Saved Student. id:- "+theId);

		//retrieve student based on id:
		Student myStudent = studentDAO.findById(theId);
		//display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Pratik","Doe","pratik@gmail.com");
		Student tempStudent2 = new Student("Dhanraj","Shelke","dhanraj@gmail.com");
		Student tempStudent3 = new Student("Prashant","Dheple","prashant@gmail.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating object");
		Student tempStudent = new Student("Paul","Doe","paul@gmail.com");

		//save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);

		//display id of saved student
		System.out.println("Saved Student. Generated student: "+tempStudent.getId());


	}


}
