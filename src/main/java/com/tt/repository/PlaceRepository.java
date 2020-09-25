package com.tt.repository;

import com.tt.pojo.PlaceEntity;
import com.tt.pojo.PlaceEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 场地dao
 */
@Repository
public interface PlaceRepository extends BaseRepository<PlaceEntity, Long>, PagingAndSortingRepository<PlaceEntity, Long> {
    /**
     * 根据场地id查询场地
     * @param id
     * @return
     */
    @Query("from PlaceEntity as c where c.id = :id")
    PlaceEntity findPlaceById(@Param("id") int id);

    /**
     * 查询所有场地
     * @return
     */
    @Query("from PlaceEntity")
    List<PlaceEntity> findAllPlace();

    /**
     * 分页查询所有场地
     *
     * @param page 起始个数
     * @param pageSize 截至个数
     */
    @Query(value = "select * from tt_place as u LIMIT :offset,:pageSize", nativeQuery = true)
    List<PlaceEntity> findAllPlaceByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * 查询数量
     * @return 场地数量
     */
    @Query(value = "select count(*) from tt_place as u", nativeQuery = true)
    int findAllPlaceTotal();

    @Transactional
    @Modifying
    @Query(value = "delete from tt_place where id=:id", nativeQuery = true)
    int deleteById(@Param("id") int id);
}
