package com.tt.repository;

import com.tt.pojo.StudentEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 学员dao
 */
@Repository
public interface StudentRepository extends BaseRepository<StudentEntity, Long>, PagingAndSortingRepository<StudentEntity, Long> {
    /**
     * 根据学员id查询学员
     * @param id
     * @return
     */
    @Query("from StudentEntity as c where c.id = :id")
    StudentEntity findStudentById(@Param("id") int id);

    /**
     * 查询所有学员
     * @return
     */
    @Query("from StudentEntity")
    List<StudentEntity> findAllStudent();

    /**
     * 分页查询所有学员
     *
     * @param page 起始个数
     * @param pageSize 截至个数
     */
    @Query(value = "select * from tt_student as u LIMIT :offset,:pageSize", nativeQuery = true)
    List<StudentEntity> findAllStudentByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    @Query(value = "SELECT s.*,p.name place_name FROM tt_student s,tt_place p where s.place_id=p.id LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> findAllStudentByPage2(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    @Query(value = "SELECT s.*,p.name place_name FROM tt_student s,tt_place p where s.place_id=p.id and s.place_id=:placeId LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> findAllStudentByPage2(@Param("offset") Integer page, @Param("pageSize") Integer pageSize,@Param("placeId") Integer placeId);

    /**
     * 查询数量
     * @return 学员数量
     */
    @Query(value = "select count(*) from tt_student as u", nativeQuery = true)
    int findAllStudentTotal();
    @Query(value = "select count(*) from tt_student as u where u.place_id=:placeId", nativeQuery = true)
    int findAllStudentTotal(@Param("placeId") Integer placeId);

    @Transactional
    @Modifying
    @Query(value = "delete from tt_student where id=:id", nativeQuery = true)
    int deleteById(@Param("id") int id);

    @Query(value = "select * from tt_student u where u.place_id=:placeId", nativeQuery = true)
    List<StudentEntity> findStudentByPlaceId(@Param("placeId") Integer placeId);
}
