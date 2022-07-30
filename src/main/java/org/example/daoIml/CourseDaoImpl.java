package org.example.daoIml;

import org.example.DataBase;
import org.example.dao.CourseDao;
import org.example.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    EntityManager entityManager = DataBase.entityManager();

    @Override
    public void saveCourse(Course course) {
        EntityManager entityManager = DataBase.entityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        System.out.println(course.getCourseName() + " Successfully saved");
        entityManager.close();

    }

    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = DataBase.entityManager();

        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        EntityManager entityManager = DataBase.entityManager();

        entityManager.getTransaction().begin();
        List<Course> courses = entityManager.createQuery("select  c from Course c order by c.createAt desc ").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    @Override
    public void updateCourse(Long id, Course course) {
        EntityManager entityManager = DataBase.entityManager();

        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, id);
        course1.setCourseName(course.getCourseName());
        course1.setCreateAt(course.getCreateAt());
        course1.setDescription(course.getDescription());
        course1.setDuration(course.getDuration());
        course1.setImageLink(course.getImageLink());
        entityManager.getTransaction().commit();
        entityManager.close();

    }


    @Override
    public void deleteCourseById(Long id) {
        EntityManager entityManager = DataBase.entityManager();

        entityManager.getTransaction().begin();
        // entityManager.createQuery("delete from Course where id = " + id).executeUpdate();
        //query.executeUpdate();
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Id number : " + id + "  successfully deleted! ");


    }

    @Override
    public Course getCourseByName(String courseName) {
        EntityManager entityManager = DataBase.entityManager();

        entityManager.getTransaction().begin();
        Course course = entityManager.createQuery("select c from Course c where c.courseName= : courseName",Course.class).setParameter("courseName",courseName).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }


}
