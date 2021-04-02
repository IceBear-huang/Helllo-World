package org.example.service.impl;

import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    public StudentDao getDao() {
        return dao;
    }

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public int addStudent(Student student) {
        int nums = dao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = dao.selectStudents();
        return students;
    }
}
