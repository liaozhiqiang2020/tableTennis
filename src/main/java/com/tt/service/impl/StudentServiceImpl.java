package com.tt.service.impl;

import com.tt.pojo.StudentEntity;
import com.tt.repository.StudentRepository;
import com.tt.service.StudentService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentEntity findStudentByStudentName(String studentName) {
        return this.findStudentByStudentName(studentName);
    }

    @Override
    public Map<String, Object> findStudentByPage(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<StudentEntity> list = this.studentRepository.findAllStudentByPage((page-1)*10,pageSize);
        int total = this.studentRepository.findAllStudentTotal();
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public List<StudentEntity> findAllStudent() {
        return this.studentRepository.findAllStudent();
    }

    @Override
    public StudentEntity updateStudent(StudentEntity student) {
        return this.studentRepository.save(student);
    }

    @Override
    public StudentEntity saveStudent(StudentEntity student) {
        return this.studentRepository.save(student);
    }

    @Override
    public int deleteStudent(int studentId) {
        return this.studentRepository.deleteById(studentId);
    }

    @Override
    public StudentEntity findStudentById(int studentId) {
        return this.studentRepository.findStudentById(studentId);
    }

    @Override
    public List<StudentEntity> findStudentByPlaceId(int placeId) {
        return this.studentRepository.findStudentByPlaceId(placeId);
    }
}
