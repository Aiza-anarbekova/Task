package org.example.dao;

import org.example.model.Task;

import java.util.List;

public interface TaskDao {
    void saveTask(Long id,Task task);

    void update(Long id, Task task);

    List<Task> getTaskByLessonId(Long id);

    void deleteTaskById(Long id);
}
