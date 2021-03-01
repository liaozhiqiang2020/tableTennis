package com.tt.service;


import com.tt.pojo.PermissionEntity;
import com.tt.pojo.CourseEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 课程service
 * @param <T>
 */
public interface CourseService<T> {

    /**
     * 根据名字查询
     * @param CourseName
     * @return
     */
    CourseEntity findCourseByCourseName(String CourseName);

    /**
     * 分页查询所有Course
     *
     * @return 分页集合
     */
    Map<String,Object> findCourseByPage(int page, int pageSize);

    Map<String,Object> findCourseByPageAndPlace(int page, int pageSize, String placeId);

    /**
     * 不分页查询所有Course
     *
     * @return 所有Course
     */
    List<CourseEntity> findAllCourse();
    List<CourseEntity> findAllCourseByPlace(String placeId);

    /**
     * 更新Course对象
     *
     * @return 更新的Course对象
     */
    CourseEntity updateCourse(CourseEntity course);

    /**
     * 保存Course对象
     *
     * @return 保存的Course对象
     */
    CourseEntity saveCourse(CourseEntity course);

    /**
     * 删除一个Course对象
     *
     */
    int deleteCourse(int courseId);

    /**
     * 根据Id查询Course
     *
     * @param courseId Course主键
     * @return 查询结果
     */
    CourseEntity findCourseById(int courseId);



}
