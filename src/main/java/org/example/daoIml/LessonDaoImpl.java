package org.example.daoIml;

import org.example.DataBase;
import org.example.dao.LessonDao;
import org.example.model.Course;
import org.example.model.Lesson;

import javax.persistence.EntityManager;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    EntityManager entityManager = DataBase.entityManager();
    @Override
    public void saveLesson(Long id, Lesson lesson) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        lesson.setCourse(course);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class,id);
        lesson1.setName(lesson.getName());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("id: "+ id + " successfully deleted! ");

    }

    @Override
    public Lesson getLessonById(Long id) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
       List<Lesson> lesson = entityManager.createQuery("select l from Lesson l").getResultList();
       entityManager.getTransaction().commit();
       entityManager.close();
        return lesson;
    }
}
