package com.tt.repository;

import com.tt.pojo.CoachEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 选课dao
 */
@Repository
public interface CoachRepository extends BaseRepository<CoachEntity, Long>, PagingAndSortingRepository<CoachEntity, Long> {
    /**
     *
     * @param id
     * @return
     */
    @Query("from CoachEntity as c where c.id = :id")
    CoachEntity findCoachEntityById(@Param("id") Integer id);

    /**
     * 查询所有在职教练
     * @param onWork
     * @return
     */
    @Query(value="select * from tt_coach as c where c.on_work = :onWork",nativeQuery = true)
    List<CoachEntity> findCoachEntityByOnWork(@Param("onWork") Integer onWork);

    @Query(value="select c.*,p.name place_name from tt_coach c,tt_place p where c.place_id=p.id and c.on_work = 0 LIMIT :offset,:pageSize",nativeQuery = true)
    List<Map<String,Object>> findAllCoachByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    @Query(value = "select count(*) from tt_coach where on_work = 0", nativeQuery = true)
    int findAllCoachTotal();

    @Query(value="select * from tt_coach as c where c.on_work = :onWork",nativeQuery = true)
    List<Map<String,Object>> findCoachEntityByOnWork2(@Param("onWork") Integer onWork);
}
