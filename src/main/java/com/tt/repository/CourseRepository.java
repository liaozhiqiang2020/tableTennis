package com.tt.repository;

import com.tt.pojo.CourseEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    @Query(value = "select u.*,p.name place_name from tt_course u,tt_place p where u.place_id=p.id LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> findAllCourseByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    @Query(value="select c.*,p.name place_name from tt_course c,tt_place p where c.place_id=p.id and if(IFNULL(:placeId,'')!='',c.place_id=:placeId,1=1) LIMIT :offset,:pageSize",nativeQuery = true)
    List<Map<String,Object>> findAllCourseByPageAndPlaceId(@Param("offset") Integer page, @Param("pageSize") Integer pageSize,@Param("placeId") String placeId);

    /**
     * 查询数量
     * @return 课程数量
     */
    @Query(value = "select count(*) from tt_course as u", nativeQuery = true)
    int findAllCourseTotal();

    @Query(value = "select count(*) from tt_course as u where if(IFNULL(:placeId,'')!='',u.place_id=:placeId,1=1)", nativeQuery = true)
    int findAllCourseTotalByPlaceId(@Param("placeId") String placeId);

    @Query(value = "select * from tt_course as u where u.place_id=:placeId", nativeQuery = true)
    List<CourseEntity> findAllCourseByPlace(@Param("placeId") String placeId);

    @Transactional
    @Modifying
    @Query(value = "delete from tt_course where id=:id", nativeQuery = true)
    int deleteById(@Param("id") int id);
}
