package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
//specialized anotatiom for repo and supports component scanning
// Translates jdbc exceptions
public class StudentDAOImpl implements  StudentDAO{

    //define field for entity manager

    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {
entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        // FROM Student->Student is not database table name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //return query result

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> thequery = entityManager.createQuery("from Student where lastName=:theData",Student.class);

        //set query parameter
        thequery.setParameter("theData", theLastName);
        //return result
        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student theStudent = entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("Delete from Student").executeUpdate();

        return numRowsDeleted;
    }
}
