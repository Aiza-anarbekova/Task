package org.example.service;

import org.example.model.Task;

import java.util.List;

public interface  TaskService {
    void saveTask(Task task);

    void update(Long id, Task task);

    List<Task> getTaskByLessonId(Long id);

    void deleteTaskById(Long id);
}
