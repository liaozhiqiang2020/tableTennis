package com.tt.service;


import com.tt.pojo.ChooseClassEntity;
import com.tt.pojo.CoachEntity;
import org.omg.CORBA.Object;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * 教练service
 * @param <T>
 */
public interface CoachService<T> {

    List<CoachEntity> findCoachEntityByOnWork();

    CoachEntity saveCoach(CoachEntity coachEntity);

    CoachEntity updateCoach(CoachEntity coachEntity);

    CoachEntity findCoachEntityById(int coachId);

    Map<String,Object> findAllCoachByPage(int page, int pageSize);

    List<Map<String, Object>> findCoachAndClass(String state);
}
