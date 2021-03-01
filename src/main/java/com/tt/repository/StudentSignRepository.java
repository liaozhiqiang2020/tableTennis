package com.tt.repository;

import com.tt.pojo.StudentSignEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    @Query(value = "select ss.*,s.name student_name,p.name place_name,c.name course_name,u.name user_name from tt_student_sign ss,tt_student s,tt_place p,tt_course c,mc_user u where ss.student_id=s.id and ss.place_id=p.id and ss.course_id=c.id and ss.user_id=u.id order by ss.id desc LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> findAllStudentSignByPage2(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    @Query(value = "select ss.*,s.name student_name,p.name place_name,c.name course_name,u.name user_name from tt_student_sign ss,tt_student s,tt_place p,tt_course c,mc_user u where ss.student_id=s.id and ss.place_id=p.id and ss.course_id=c.id and ss.user_id=u.id and if(IFNULL(:name,'')!='',ss.user_id =:name,1=1) and if(IFNULL(:studentId,'')!='',ss.student_id =:studentId,1=1) order by ss.id desc LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> getListByPageAndOther(@Param("offset") Integer page, @Param("pageSize") Integer pageSize, @Param("name") String name, @Param("studentId") String studentId);

    @Query(value = "select ss.*,s.name student_name,p.name place_name,c.name course_name,u.name user_name from tt_student_sign ss,tt_student s,tt_place p,tt_course c,mc_user u where ss.sign_time between :startTime and :endTime and ss.student_id=s.id and ss.place_id=p.id and ss.course_id=c.id and ss.user_id=u.id and if(IFNULL(:name,'')!='',ss.user_id =:name,1=1) and if(IFNULL(:studentId,'')!='',ss.student_id =:studentId,1=1)  order by ss.id desc LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> getListByPageAndOther2(@Param("offset") Integer page, @Param("pageSize") Integer pageSize, @Param("name") String name, @Param("studentId") String studentId, @Param("startTime") String startTime, @Param("endTime") String endTime);


    /**
     * 查询数量
     * @return 学员签到信息数量
     */
    @Query(value = "select count(*) from tt_student_sign as u", nativeQuery = true)
    int findAllStudentSignTotal();

    @Query(value = "select count(*) from tt_student_sign where if(IFNULL(:name,'')!='',user_id =:name,1=1) and if(IFNULL(:studentId,'')!='',student_id =:studentId,1=1)", nativeQuery = true)
    int findAllStudentSignTotal(@Param("name") String name, @Param("studentId") String studentId);

    @Query(value = "select count(*) from tt_student_sign where sign_time between :startTime and :endTime and if(IFNULL(:name,'')!='',user_id =:name,1=1) and if(IFNULL(:studentId,'')!='',student_id =:studentId,1=1)", nativeQuery = true)
    int findAllStudentSignTotal2(@Param("name") String name, @Param("studentId") String studentId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 查询当天是否签到
     * @param id
     * @return
     */
    @Query(value = "select * from tt_student_sign as u where u.student_id=:id and u.sign_time LIKE CONCAT('',:signTime,'%')", nativeQuery = true)
    StudentSignEntity querySign(int id, String signTime);

    /**
     * 查询是否签到(改为一天可以签到多次)
     * @param id
     * @return
     */
    @Query(value = "select * from tt_student_sign as u where u.student_id=:id", nativeQuery = true)
    StudentSignEntity querySign(int id);
}
