package org.example.serviceImpl;

import org.example.daoIml.CourseDaoImpl;
import org.example.model.Course;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDaoImpl   courseDao = new CourseDaoImpl();
    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {

        return courseDao.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void updateCourse(Long id, Course course) {
       courseDao.updateCourse(id,course);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseDao.deleteCourseById(id);

    }

    @Override
    public Course getCourseByName(String courseName) {
        return courseDao.getCourseByName(courseName);
    }
}
