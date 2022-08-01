package org.example.daoIml;

import org.example.DataBase;
import org.example.dao.CourseDao;
import org.example.model.Course;
import org.example.model.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDaoImpl implements CourseDao {


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
        System.out.println("id number: "+id+ " successfully updated ");
        entityManager.close();

    }

    @Override
    public void deleteCourseById(Long id) {
        try {
            EntityManager entityManager1 = DataBase.entityManager();
            entityManager1.getTransaction().begin();
            Course course = entityManager1.find(Course.class, id);
            for (Instructor i: course.getInstructor()) {
                i.setCourse(null);
            }
            entityManager1.remove(course);
            entityManager1.getTransaction().commit();
            System.out.println("successfully deleted! ");
            entityManager1.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }


    @Override
    public Course getCourseByName(String courseName) {
        EntityManager entityManager = DataBase.entityManager();

        entityManager.getTransaction().begin();
        Course course = entityManager.createQuery("select c from Course c where c.courseName= : courseName", Course.class).setParameter("courseName", courseName).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }


}
