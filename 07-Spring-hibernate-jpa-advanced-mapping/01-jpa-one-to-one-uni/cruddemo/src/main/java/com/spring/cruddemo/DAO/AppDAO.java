package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorbyId(int theID);
    void deleteInstructorbyId(int theId);
}
