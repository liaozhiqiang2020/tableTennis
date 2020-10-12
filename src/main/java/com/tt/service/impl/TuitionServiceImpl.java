package com.tt.service.impl;

import com.tt.pojo.TuitionEntity;
import com.tt.repository.TuitionRepository;
import com.tt.service.TuitionService;
import com.tt.service.TuitionService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TuitionServiceImpl implements TuitionService{
    @Autowired
    private TuitionRepository tuitionRepository;

    @Override
    public TuitionEntity findTuitionByTuitionName(String tuitionName) {
        return this.findTuitionByTuitionName(tuitionName);
    }

    @Override
    public Map<String, Object> findTuitionByPage(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<TuitionEntity> list = this.tuitionRepository.findAllTuitionByPage((page-1)*10,pageSize);
        int total = this.tuitionRepository.findAllTuitionTotal();
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public Map<String, Object> findTuitionByPage2(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.tuitionRepository.findAllTuitionByPage2((page-1)*pageSize,pageSize);
        int total = this.tuitionRepository.findAllTuitionTotal();
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public List<TuitionEntity> findAllTuition() {
        return this.tuitionRepository.findAllTuition();
    }

    @Override
    public TuitionEntity updateTuition(TuitionEntity tuition) {
        return this.tuitionRepository.save(tuition);
    }

    @Override
    public TuitionEntity saveTuition(TuitionEntity tuition) {
        return this.tuitionRepository.save(tuition);
    }

    @Override
    public int deleteTuition(int tuitionId) {
        return this.tuitionRepository.deleteById(tuitionId);
    }

    @Override
    public TuitionEntity findTuitionById(int tuitionId) {
        return this.tuitionRepository.findTuitionById(tuitionId);
    }
}
