package com.tt.repository;

import com.tt.pojo.MemberEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 会员dao
 */
@Repository
public interface MemberRepository extends BaseRepository<MemberEntity, Long>, PagingAndSortingRepository<MemberEntity, Long> {
    /**
     * 根据会员id查询会员
     * @param id
     * @return
     */
    @Query("from MemberEntity as c where c.id = :id")
    MemberEntity findMemberById(@Param("id") int id);

    /**
     * 根据会员手机号查询会员
     * @param tel
     * @return
     */
    @Query("from MemberEntity as c where c.tel = :tel")
    MemberEntity findMemberByTel(@Param("tel") String tel);

    /**
     * 查询所有会员
     * @return
     */
    @Query("from MemberEntity")
    List<MemberEntity> findAllMember();

    /**
     * 分页查询所有会员
     *
     * @param page 起始个数
     * @param pageSize 截至个数
     */
    @Query(value = "select * from tt_member LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> findAllMemberByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);

    @Query(value = "SELECT * FROM tt_member where  if(IFNULL(:name,'')!='',name LIKE %:name%,1=1) and if(IFNULL(:tel,'')!='',tel LIKE %:tel%,1=1) LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> getListByPageAndOther(@Param("offset") Integer page, @Param("pageSize") Integer pageSize, @Param("name") String name, @Param("tel") String tel);

    /**
     * 查询数量
     * @return 课程数量
     */
    @Query(value = "select count(*) from tt_member as u", nativeQuery = true)
    int findAllMemberTotal();

    @Query(value = "select count(*) from tt_member where if(IFNULL(:name,'')!='',name LIKE %:name%,1=1) and if(IFNULL(:tel,'')!='',tel LIKE %:tel%,1=1)", nativeQuery = true)
    int findAllMemberTotal(@Param("name") String name, @Param("tel") String tel);

    @Transactional
    @Modifying
    @Query(value = "delete from tt_member where id=:id", nativeQuery = true)
    int deleteById(@Param("id") int id);
}
