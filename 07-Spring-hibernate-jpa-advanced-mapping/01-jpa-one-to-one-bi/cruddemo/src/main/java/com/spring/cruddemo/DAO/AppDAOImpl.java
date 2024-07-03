package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Instructor;
import com.spring.cruddemo.entity.InstructorDetail;
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

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail temp = entityManager.find(InstructorDetail.class,theId);

        //remove the associated object reference
        //break bidirectional  link
        temp.getInstructor().setInstructorDetail(null);

        entityManager.remove(temp);
    }
}
