package com.tt.service;

import com.tt.pojo.StudentSignEntity;

import java.util.List;
import java.util.Map;

/**
 * 学员service
 * @param <T>
 */
public interface StudentSignService<T> {


    /**
     * 分页查询所有Student
     *
     * @return 分页集合
     */
    Map<String,Object> findStudentSignByPage(int page, int pageSize);
    Map<String,Object> findStudentSignByPage2(int page, int pageSize);

    /**
     * 不分页查询所有StudentSign
     *
     * @return 所有StudentSign
     */
    List<StudentSignEntity> findAllStudentSign();

    /**
     * 更新StudentSign对象
     *
     * @return 更新的StudentSign对象
     */
    StudentSignEntity updateStudentSign(StudentSignEntity studentEntity);

    /**
     * 保存StudentSign对象
     *
     * @return 保存的StudentSign对象
     */
    StudentSignEntity saveStudentSign(StudentSignEntity studentEntity);

    /**
     * 删除一个Student对象
     *
     */
    int deleteStudentSign(int studentSignId);

    /**
     * 根据Id查询StudentSign
     *
     * @return 查询结果
     */
    StudentSignEntity findStudentSignById(int studentSignId);

    /**
     * 根据场地id查询
     */
    List<StudentSignEntity> findStudentSignByPlaceId(int placeId);

}
