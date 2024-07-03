package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Instructor;
import com.spring.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorbyId(int theID);
    void deleteInstructorbyId(int theId);

    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
