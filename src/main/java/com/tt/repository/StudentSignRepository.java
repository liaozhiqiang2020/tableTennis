package com.tt.repository;

import com.tt.pojo.StudentSignEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学员签到信息dao
 */
@Repository
public interface StudentSignRepository extends BaseRepository<StudentSignEntity, Long>, PagingAndSortingRepository<StudentSignEntity, Long> {
    /**
     * 根据学员签到信息id查询学员签到信息
     * @param id
     * @return
     */
    @Query("from StudentSignEntity as c where c.id = :id")
    StudentSignEntity findStudentSignById(@Param("id") int id);

    /**
     * 查询所有学员签到信息
     * @return
     */
    @Query("from StudentSignEntity")
    List<StudentSignEntity> findAllStudentSign();

    /**
     * 分页查询所有学员签到信息
     *
     * @param page 起始个数
     * @param pageSize 截至个数
     */
    @Query(value = "select * from tt_student_sign as u LIMIT :offset,:pageSize", nativeQuery = true)
    List<StudentSignEntity> findAllStudentSignByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * 查询数量
     * @return 学员签到信息数量
     */
    @Query(value = "select count(*) from tt_student_sign as u", nativeQuery = true)
    int findAllStudentSignTotal();
}
