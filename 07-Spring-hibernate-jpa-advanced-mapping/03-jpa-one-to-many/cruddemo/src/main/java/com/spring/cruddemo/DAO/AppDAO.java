package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Course;
import com.spring.cruddemo.entity.Instructor;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorbyId(int theID);
    void deleteInstructorbyId(int theId);
    List<Course>  findCourseByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
    void update(Instructor tempInstructor);
    void updateCourse(Course tempCourse);
    Course findCoursebyId(int theId);
    void deleteCoursebyId(int theId);

}
