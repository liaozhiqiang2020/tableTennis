package com.tt.repository;

import com.tt.pojo.CourseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程dao
 */
@Repository
public interface CourseRepository extends BaseRepository<CourseEntity, Long>, PagingAndSortingRepository<CourseEntity, Long> {
    /**
     * 根据课程id查询课程
     * @param id
     * @return
     */
    @Query("from CourseEntity as c where c.id = :id")
    CourseEntity findCourseById(@Param("id") int id);

    /**
     * 查询所有课程
     * @return
     */
    @Query("from CourseEntity")
    List<CourseEntity> findAllCourse();

    /**
     * 分页查询所有课程
     *
     * @param page 起始个数
     * @param pageSize 截至个数
     */
    @Query(value = "select * from tt_course as u LIMIT :offset,:pageSize", nativeQuery = true)
    List<CourseEntity> findAllCourseByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * 查询数量
     * @return 课程数量
     */
    @Query(value = "select count(*) from tt_course as u", nativeQuery = true)
    int findAllCourseTotal();
}
