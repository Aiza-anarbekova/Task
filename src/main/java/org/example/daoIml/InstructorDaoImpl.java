package org.example.daoIml;

import org.example.DataBase;
import org.example.dao.InstructorDao;
import org.example.model.Course;
import org.example.model.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    EntityManager entityManager = DataBase.entityManager();

    @Override
    public void saveInstructor(Instructor instructor) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(instructor.getFirstName() + "  successfully saved! ");

    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Id number "+id+" successfully updated ");
    }

    @Override
    public Instructor getInstructorById(Long id) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        List<Instructor> instructors = course.getInstructor();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("All instructors:  ");
        return instructors;

    }

    @Override
    public void deleteInstructorById(Long id) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
       Instructor instructor = entityManager.find(Instructor.class,id);
       entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("id "+ id+ " successfully deleted! ");
    }

    @Override
    public void assignInstructorToCourse(Long id, Long courseId) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        course.setInstructor(entityManager.find(Instructor.class, id));
        Instructor instructor = entityManager.find(Instructor.class, id);
        instructor.setCourse(entityManager.find(Course.class, courseId));
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
