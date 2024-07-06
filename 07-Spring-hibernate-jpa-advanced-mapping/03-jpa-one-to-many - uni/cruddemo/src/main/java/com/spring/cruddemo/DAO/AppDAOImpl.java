package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Course;
import com.spring.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        //get the courses
        List<Course> tempcourses = temp.getCourses();
        //break association of all courses
        for(Course course:tempcourses){
            course.setInstructor(null);
        }
        //we only delete the instructor and not course
        entityManager.remove(temp);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id=:data", Course.class);
        query.setParameter("data",theId );
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail "+
                        "WHERE i.id = :data", Instructor.class);
        query.setParameter("data", theId);
        Instructor res = query.getSingleResult();
        return res;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCoursebyId(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteCoursebyId(int theId) {
        Course temp = entityManager.find(Course.class,theId);
        entityManager.remove(temp);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseandReviewByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id=:data", Course.class);
        query.setParameter("data",id);
        Course course = query.getSingleResult();
        return course;
    }


}
