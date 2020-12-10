package com.tt.repository;

import com.tt.pojo.ChooseClassRecordEntity;
import com.tt.pojo.ChooseClassRecordEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 选课记录dao
 */
@Repository
public interface ChooseClassRecordRepository extends BaseRepository<ChooseClassRecordEntity, Long>, PagingAndSortingRepository<ChooseClassRecordEntity, Long> {
    /**
     *
     * @param id
     * @return
     */
    @Query("from ChooseClassRecordEntity as c where c.id = :id")
    ChooseClassRecordEntity findChooseClassById(@Param("id") int id);

    @Query(value="select c.*,p.name place_name,s.name student_name from tt_choose_class_record c,tt_place p,tt_student s where c.place_id=p.id and c.student_id=s.id and if(IFNULL(:placeId,'')!='',c.place_id=:placeId,1=1) LIMIT :offset,:pageSize",nativeQuery = true)
    List<Map<String,Object>> findChooseClassByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize, @Param("placeId") String placeId);

    @Query(value = "select count(*) from tt_choose_class_record as c where if(IFNULL(:placeId,'')!='',c.place_id=:placeId,1=1)", nativeQuery = true)
    int findAllChooseClassTotal(@Param("placeId") String placeId);
}
