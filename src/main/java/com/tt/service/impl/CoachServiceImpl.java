package com.tt.service.impl;

import com.tt.pojo.ChooseClassEntity;
import com.tt.pojo.CoachEntity;
import com.tt.repository.ChooseClassRepository;
import com.tt.repository.CoachRepository;
import com.tt.service.CoachService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private ChooseClassRepository chooseClassRepository;


    @Override
    public List<CoachEntity> findCoachEntityByOnWork() {
        return this.coachRepository.findCoachEntityByOnWork(0);
    }

    @Override
    public CoachEntity saveCoach(CoachEntity coachEntity) {
        return this.coachRepository.save(coachEntity);
    }

    @Override
    public CoachEntity updateCoach(CoachEntity coachEntity) {
        return this.coachRepository.save(coachEntity);
    }

    @Override
    public CoachEntity findCoachEntityById(int coachId) {
        return this.coachRepository.findCoachEntityById(coachId);
    }

    @Override
    public Map<String, Object> findAllCoachByPage(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.coachRepository.findAllCoachByPage((page-1)*pageSize,pageSize);
        int total = this.coachRepository.findAllCoachTotal();

        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public List<Map<String, Object>> findCoachAndClass(String state) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> newcoachList = new ArrayList<>();
        List<Map<String,Object>> coachList = this.coachRepository.findCoachEntityByOnWork2(0);

        for (int i = 0; i < coachList.size(); i++) {
            Map<String,Object> coachMap2 = new HashMap<>();
            Map<String,Object> coachMap = coachList.get(i);
            List<ChooseClassEntity> classList = this.chooseClassRepository.findChooseClassEntitiesByCoachId(Integer.parseInt(coachMap.get("id").toString()),state);
            if(classList.size()>0){
                coachMap2.put("coachMap",coachMap);
                coachMap2.put("classList",classList);
                newcoachList.add(coachMap2);
            }
        }

        result.put("code", 0);
        result.put("data", newcoachList);
        result.put("count", newcoachList.size());
        return newcoachList;
    }


}
