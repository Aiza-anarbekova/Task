package org.example.serviceImpl;

import org.example.daoIml.InstructorDaoImpl;
import org.example.model.Instructor;
import org.example.service.InstructorService;

import java.util.List;

public class InstructorServiceIml implements InstructorService {
    InstructorDaoImpl instructorDao = new InstructorDaoImpl();
    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorDao.updateInstructor(id,instructor);

    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return instructorDao.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorDao.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long id, Long courseId) {
        instructorDao.assignInstructorToCourse(id,courseId);
    }
}
