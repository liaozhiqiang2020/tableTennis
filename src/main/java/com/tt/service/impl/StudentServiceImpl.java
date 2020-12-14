package com.tt.service.impl;

import com.tt.pojo.StudentEntity;
import com.tt.pojo.UserEntity;
import com.tt.repository.StudentRepository;
import com.tt.repository.UserRepository;
import com.tt.service.StudentService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;

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
    public Map<String, Object> findStudentByPage2(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.studentRepository.findAllStudentByPage2((page-1)*pageSize,pageSize);
        int total = this.studentRepository.findAllStudentTotal();
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public Map<String, Object> findStudentByPage2(int page, int pageSize, String placeId) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.studentRepository.findAllStudentByPage2((page-1)*pageSize,pageSize,placeId);
        int total = this.studentRepository.findAllStudentTotal(placeId);
        int pages=total/pageSize;
        if(total%pageSize!=0){
            pages++;
        }
        result.put("code", 0);
        result.put("data", list);
        result.put("pages", pages);
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String createTime = df.format(new Date());
        try {
            //添加用户
            UserEntity userEntity = new UserEntity();
            userEntity.setName(student.getName());
            userEntity.setUserName(student.getSn());
            userEntity.setAuthenticationString("123456");
            userEntity.setType(1);
            userEntity.setStatus(0);
            userEntity.setCreateDatetime(createTime);
            userEntity.setCellphoneNumber(student.getParentTel());
            this.userRepository.save(userEntity);
            System.out.println("添加用户"+student.getName()+"成功");
        }catch (Exception e){
            System.out.println("添加用户失败");
        }


        return this.studentRepository.save(student);
    }

    @Override
    public int deleteStudent(int studentId) {
        try {
            StudentEntity studentEntity = this.studentRepository.findStudentById(studentId);
            UserEntity userEntity = this.userRepository.findUserByUserName(studentEntity.getSn());
            if(userEntity!=null){
                this.userRepository.deleteById(userEntity.getId());
            }
        }catch (Exception e){
            System.out.println("删除家长账号失败");
        }

        return this.studentRepository.deleteById(studentId);
    }

    @Override
    public StudentEntity findStudentById(int studentId) {
        return this.studentRepository.findStudentById(studentId);
    }

    @Override
    public List<StudentEntity> findStudentByPlaceId(String placeId) {
        return this.studentRepository.findStudentByPlaceId(placeId);
    }

    @Override
    public StudentEntity findSn(String sn) {
        return this.studentRepository.findSn(sn);
    }
}
