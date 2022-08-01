package org.example.serviceImpl;

import org.example.daoIml.TaskDaoImpl;
import org.example.model.Task;
import org.example.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    TaskDaoImpl taskDao = new TaskDaoImpl();
    @Override
    public void saveTask(Long id,Task task) {
taskDao.saveTask(id,task);
    }



    @Override
    public void update(Long id, Task task) {
taskDao.update(id,task);
    }

    @Override
    public List<Task> getTaskByLessonId(Long id) {
        return taskDao.getTaskByLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
taskDao.deleteTaskById(id);
    }
}
