package com.tt.service.impl;

import com.tt.pojo.ChooseClassRecordEntity;
import com.tt.repository.ChooseClassRecordRepository;
import com.tt.repository.ChooseClassRepository;
import com.tt.service.ChooseClassRecordService;
import com.tt.service.ChooseClassService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChooseClassRecordServiceImpl implements ChooseClassRecordService {
    @Autowired
    private ChooseClassRecordRepository chooseClassRecordRepository;

    @Override
    public Map<String,Object> findAllChooseClassByPage(int page, int pageSize, String placeId) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.chooseClassRecordRepository.findChooseClassByPage((page-1)*pageSize,pageSize,placeId);
        int total = this.chooseClassRecordRepository.findAllChooseClassTotal(placeId);
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public ChooseClassRecordEntity updateChooseClass(ChooseClassRecordEntity ChooseClassRecordEntity) {
        return this.chooseClassRecordRepository.save(ChooseClassRecordEntity);
    }

    @Override
    public ChooseClassRecordEntity saveChooseClass(ChooseClassRecordEntity ChooseClassRecordEntity) {
        return this.chooseClassRecordRepository.save(ChooseClassRecordEntity);
    }
    

    @Override
    public ChooseClassRecordEntity findChooseClassById(int chooseClassId) {
        return this.chooseClassRecordRepository.findChooseClassById(chooseClassId);
    }
}
