package org.example.serviceImpl;

import org.example.daoIml.LessonDaoImpl;
import org.example.model.Lesson;
import org.example.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    LessonDaoImpl lessonDao = new LessonDaoImpl();
    @Override
    public void saveLesson(Long id, Lesson lesson) {
        lessonDao.saveLesson(id,lesson);

    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
lessonDao.updateLesson(id,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        return lessonDao.getLessonByCourseId(id);
    }
}
