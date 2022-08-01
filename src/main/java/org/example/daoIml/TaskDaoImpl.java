package org.example.daoIml;

import org.example.DataBase;
import org.example.dao.TaskDao;
import org.example.model.Lesson;
import org.example.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @Override
    public void saveTask(Long id,Task task) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        lesson.addTask(task);
        task.setLesson(lesson);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(task.getName()+" successfully saved ");

    }

    @Override
    public void update(Long id, Task task) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class,id);
        task1.setName(task.getName());
        task1.setTask(task.getTask());
        task1.setDeadline(task.getDeadline());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Id: "+id +" successfully updated ");

    }

    @Override
    public List<Task> getTaskByLessonId(Long id) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Lesson lesson  = entityManager.find(Lesson.class,id);
        List<Task> tasks = lesson.getTask();
        entityManager.getTransaction().commit();
        entityManager.close();

        return tasks;
    }

    @Override
    public void deleteTaskById(Long id) {
        EntityManager entityManager = DataBase.entityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class,id);
        task.setLesson(null);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("id: "+id +" successfully deleted! ");
    }
}
