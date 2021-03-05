package com.tt.repository;

import com.tt.pojo.CourseEntity;
import com.tt.pojo.NoticeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface NoticeRepository extends BaseRepository<NoticeEntity, Long>, PagingAndSortingRepository<NoticeEntity, Long> {
    /**
     * 根据消息id查询内容
     * @param id
     * @return
     */
    @Query("from NoticeEntity as c where c.id = :id")
    NoticeEntity findNoticeById(@Param("id") int id);

    /**
     * 查询所有消息
     * @return
     */
    @Query("from NoticeEntity")
    List<NoticeEntity> findAllNotice();

    /**
     * 分页查询所有课程
     *
     * @param page 起始个数
     * @param pageSize 截至个数
     */
    @Query(value = "select n.*,u.name publish_name from tt_notice n,mc_user u where n.publish_id=u.id and if(IFNULL(:type,'')!='',n.type=:type,1=1)  LIMIT :offset,:pageSize", nativeQuery = true)
    List<Map<String,Object>> findAllNoticeByPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize,@Param("type") Integer type);

    /**
     * 查询数量
     * @return 课程数量
     */
    @Query(value = "select count(*) from tt_notice where if(IFNULL(:type,'')!='',type=:type,1=1)", nativeQuery = true)
    int findAllNoticeTotal(@Param("type") Integer type);


    @Transactional
    @Modifying
    @Query(value = "delete from tt_notice where id=:id", nativeQuery = true)
    int deleteById(@Param("id") int id);

    /**
     * 根据类型查询
     * @param type
     * @return
     */
    @Query(value = "select * from tt_notice where if(IFNULL(:type,'')!='',type=:type,1=1) order by publish_date desc", nativeQuery = true)
    List<NoticeEntity> findAllNoticeByType(@Param("type") Integer type);
}
