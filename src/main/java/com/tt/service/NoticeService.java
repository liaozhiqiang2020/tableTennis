package com.tt.service;

import com.tt.pojo.CoachEntity;
import com.tt.pojo.NoticeEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * 消息通知service
 */
public interface NoticeService {
    NoticeEntity saveNotice(NoticeEntity noticeEntity);

    NoticeEntity updateCoach(NoticeEntity noticeEntity);

    NoticeEntity findNoticeById(int id);

    List<NoticeEntity> findAllNotice();

    Map<String,Object> findAllNoticeByPage(Integer page, Integer pageSize, Integer type);

    int deleteById(int id);

    List<NoticeEntity> findAllNoticeByType(Integer type);

}
