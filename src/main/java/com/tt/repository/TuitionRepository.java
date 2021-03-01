package com.tt.repository;

import com.tt.pojo.TuitionEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 收费信息dao
 */
@Repository
public interface TuitionRepository extends BaseRepository<TuitionEntity, Long>, PagingAndSortingRepository<TuitionEntity, Long> {
    /**
     * 根据收费信息id查询收费信息
     * @param id
     * @return
     */
    @Query("from TuitionEntity as c where c.id = :id")
    TuitionEntity findTuitionById(@Param("id") int id);

    /**
     * 查询所有收费信息
     * @return
     */
    @Query("from TuitionEntity")
    List<TuitionEntity> findAllTuition();

    /**
     * 分页查询所有收费信息
     *
     * @param page 起始个数
     * @param pageSize 截至个数
     */
    @Query(value = "select * from tt_tuition as u LIMIT :offset,:pageSize", nativeQuery = true)
    List<TuitionEntity> findAllTuitionByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

/*    @Query(value="SELECT t.*,s.name student_name,p.name place_name,c.name course_name FROM tt_tuition t,tt_student s,tt_place p,tt_course c where t.student_id=s.id and t.place_id=p.id and t.course_id=c.id LIMIT :offset,:pageSize",nativeQuery = true)
    List<Map<String,Object>> findAllTuitionByPage2(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);*/
    @Query(value="SELECT t.*,s.name student_name,p.name place_name FROM tt_tuition t,tt_student s,tt_place p where t.student_id=s.id and t.place_id=p.id order by t.id LIMIT :offset,:pageSize",nativeQuery = true)
    List<Map<String,Object>> findAllTuitionByPage2(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * 查询数量
     * @return 收费信息数量
     */
    @Query(value = "select count(*) from tt_tuition as u", nativeQuery = true)
    int findAllTuitionTotal();


    @Transactional
    @Modifying
    @Query(value = "delete from tt_tuition where id=:id", nativeQuery = true)
    int deleteById(@Param("id") int id);


}
