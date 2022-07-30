package org.example.service;

import org.example.model.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    void updateCourse(Long id, Course course);

    void deleteCourseById(Long id);

    Course getCourseByName(String courseName);
}
