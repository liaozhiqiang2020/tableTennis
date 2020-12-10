package com.tt.service.impl;

import com.tt.pojo.ChooseClassEntity;
import com.tt.pojo.CourseEntity;
import com.tt.repository.ChooseClassRepository;
import com.tt.service.ChooseClassService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChooseClassServiceImpl implements ChooseClassService {
    @Autowired
    private ChooseClassRepository chooseClassRepository;

    @Override
    public List<ChooseClassEntity> findAllChooseClassByPlaceId(String placeId) {
        return this.chooseClassRepository.findChooseClassByPlaceId(placeId);
    }

    @Override
    public Map<String,Object> findAllChooseClassByPage(int page, int pageSize, String placeId) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.chooseClassRepository.findChooseClassByPage((page-1)*pageSize,pageSize,placeId);
        int total = this.chooseClassRepository.findAllChooseClassTotal(placeId);

        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public Map<String,Object> findAllChooseClassByPageAndCourse(int page, int pageSize, String placeId,String courseId) {
        Map<String,Object> result = new HashedMap();
        List<ChooseClassEntity> list = this.chooseClassRepository.findChooseClassByPageAndCourse((page-1)*pageSize,pageSize,placeId,courseId);
        int total = this.chooseClassRepository.findAllChooseClassTotalAndCourse(placeId,courseId);
        int pages=total/pageSize;
        if(total%pageSize!=0){
            pages++;
        }
        result.put("code", 0);
        result.put("data", list);
        result.put("pages", pages);
        return result;
    }

    @Override
    public ChooseClassEntity updateChooseClass(ChooseClassEntity chooseClassEntity) {
        return this.chooseClassRepository.save(chooseClassEntity);
    }

    @Override
    public ChooseClassEntity saveChooseClass(ChooseClassEntity chooseClassEntity) {
        return this.chooseClassRepository.save(chooseClassEntity);
    }

    @Override
    public int deleteChooseClass(int chooseClassId) {
        return this.chooseClassRepository.deleteById(chooseClassId);
    }

    @Override
    public ChooseClassEntity findChooseClassById(String chooseClassId) {
        return this.chooseClassRepository.findChooseClassById2(Integer.parseInt(chooseClassId));
    }
}
