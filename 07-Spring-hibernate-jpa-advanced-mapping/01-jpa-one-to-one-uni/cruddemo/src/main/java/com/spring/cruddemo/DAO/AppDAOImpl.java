package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional
    @Override
    public void save(Instructor theInstructor) {

        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorbyId(int theID) {
        return entityManager.find(Instructor.class,theID);
    }
    @Transactional
    @Override
    public void deleteInstructorbyId(int theId) {
        Instructor temp = entityManager.find(Instructor.class,theId);
        entityManager.remove(temp);
    }


}
