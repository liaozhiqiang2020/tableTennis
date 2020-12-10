package com.tt.repository;

import com.tt.pojo.ChooseClassEntity;
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
 * 选课dao
 */
@Repository
public interface ChooseClassRepository extends BaseRepository<ChooseClassEntity, Long>, PagingAndSortingRepository<ChooseClassEntity, Long> {
    /**
     *
     * @param id
     * @return
     */
    @Query("from ChooseClassEntity as c where c.id = :id")
    ChooseClassEntity findChooseClassById(@Param("id") Integer id);

    @Query(value="select * from tt_choose_class as c where c.id = :id",nativeQuery = true)
    ChooseClassEntity findChooseClassById2(@Param("id") Integer id);

    @Query("from ChooseClassEntity as c where c.placeId = :placeId")
    List<ChooseClassEntity> findChooseClassByPlaceId(@Param("placeId") String placeId);

    @Query(value="select c.*,p.name place_name,s.name course_name,co.name coach_name from tt_choose_class c,tt_place p,tt_course s,tt_coach co where c.place_id=p.id and c.course_id=s.id and c.coach_id=co.id and if(IFNULL(:placeId,'')!='',c.place_id=:placeId,1=1) order by c.coach_id LIMIT :offset,:pageSize",nativeQuery = true)
    List<Map<String,Object>> findChooseClassByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize, @Param("placeId") String placeId);

    @Query(value="select * from tt_choose_class c where if(IFNULL(:placeId,'')!='',c.place_id=:placeId,1=1) and if(IFNULL(:courseId,'')!='',c.course_id=:courseId,1=1) LIMIT :offset,:pageSize",nativeQuery = true)
    List<ChooseClassEntity> findChooseClassByPageAndCourse(@Param("offset") Integer page, @Param("pageSize") Integer pageSize, @Param("placeId") String placeId, @Param("courseId") String courseId);

    @Query(value = "select count(*) from tt_choose_class as c where if(IFNULL(:placeId,'')!='',c.place_id=:placeId,1=1)", nativeQuery = true)
    int findAllChooseClassTotal(@Param("placeId") String placeId);

    @Query(value = "select count(*) from tt_choose_class as c where if(IFNULL(:placeId,'')!='',c.place_id=:placeId,1=1) and if(IFNULL(:courseId,'')!='',c.course_id=:courseId,1=1)", nativeQuery = true)
    int findAllChooseClassTotalAndCourse(@Param("placeId") String placeId,@Param("courseId") String courseId);

    @Transactional
    @Modifying
    @Query(value = "delete from ChooseClassEntity where id=:id", nativeQuery = true)
    int deleteById(@Param("id") int id);

    @Query(value = "select * from tt_choose_class as c where c.coach_id=:coachId and c.week=:week", nativeQuery = true)
    List<ChooseClassEntity> findChooseClassEntitiesByCoachId(@Param("coachId") int coachId,@Param("week") String week);
}
