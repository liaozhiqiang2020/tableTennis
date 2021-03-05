package com.tt.service.impl;

import com.tt.pojo.NoticeEntity;
import com.tt.pojo.PlaceEntity;
import com.tt.repository.NoticeRepository;
import com.tt.service.NoticeService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public NoticeEntity saveNotice(NoticeEntity noticeEntity) {
        return this.noticeRepository.save(noticeEntity);
    }

    @Override
    public NoticeEntity updateCoach(NoticeEntity noticeEntity) {
        return this.noticeRepository.save(noticeEntity);
    }

    @Override
    public NoticeEntity findNoticeById(int id) {
        return this.noticeRepository.findNoticeById(id);
    }

    @Override
    public List<NoticeEntity> findAllNotice() {
        return this.noticeRepository.findAllNotice();
    }

    @Override
    public Map<String, Object> findAllNoticeByPage(Integer page, Integer pageSize, Integer type) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.noticeRepository.findAllNoticeByPage((page-1)*pageSize,pageSize,type);
        int total = this.noticeRepository.findAllNoticeTotal(type);
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }


    @Override
    public int deleteById(int id) {
        return this.noticeRepository.deleteById(id);
    }

    @Override
    public List<NoticeEntity> findAllNoticeByType(Integer type) {
        return this.noticeRepository.findAllNoticeByType(type);
    }
}
