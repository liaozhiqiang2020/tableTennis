package com.tt.service.impl;

import com.tt.pojo.CourseEntity;
import com.tt.repository.CourseRepository;
import com.tt.service.CourseService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseEntity findCourseByCourseName(String CourseName) {
        return null;
    }

    @Override
    public Map<String,Object> findCourseByPage(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<CourseEntity> list = this.courseRepository.findAllCourseByPage((page-1)*10,pageSize);
        int total = this.courseRepository.findAllCourseTotal();
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }


    @Override
    public List<CourseEntity> findAllCourse() {
        return this.courseRepository.findAllCourse();
    }

    @Override
    public CourseEntity updateCourse(CourseEntity course) {
        return this.courseRepository.save(course);
    }

    @Override
    public CourseEntity saveCourse(CourseEntity course) {
        return this.courseRepository.save(course);
    }

    @Override
    public int deleteCourse(int courseId) {
        return this.courseRepository.deleteById(courseId);
    }

    @Override
    public CourseEntity findCourseById(int courseId) {
        return this.courseRepository.findCourseById(courseId);
    }
}
