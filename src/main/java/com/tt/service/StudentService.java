package com.tt.service;


import com.tt.pojo.StudentEntity;

import java.util.List;
import java.util.Map;

/**
 * 学员service
 * @param <T>
 */
public interface StudentService<T> {

    /**
     * 根据名字查询
     * @return
     */
    StudentEntity findStudentByStudentName(String studentName);

    /**
     * 分页查询所有Student
     *
     * @return 分页集合
     */
    Map<String,Object> findStudentByPage(int page, int pageSize);
    Map<String,Object> findStudentByPage2(int page, int pageSize);
    Map<String,Object> findStudentByPage2(int page, int pageSize, String placeId);

    /**
     * 不分页查询所有Student
     *
     * @return 所有Student
     */
    List<StudentEntity> findAllStudent();

    /**
     * 更新Student对象
     *
     * @return 更新的Student对象
     */
    StudentEntity updateStudent(StudentEntity student);

    /**
     * 保存Student对象
     *
     * @return 保存的Student对象
     */
    StudentEntity saveStudent(StudentEntity student);

    /**
     * 删除一个Student对象
     *
     */
    int deleteStudent(int studentId);

    /**
     * 根据Id查询Student
     *
     * @return 查询结果
     */
    StudentEntity findStudentById(int studentId);

    List<StudentEntity> findStudentByPlaceId(String placeId);

    /**
     * 查询学号是否存在
     * @param sn
     * @return
     */
    StudentEntity findSn(String sn);

    //查询手机号下绑定的学员
    List<StudentEntity> findStudentByPhone(String phone);

}
