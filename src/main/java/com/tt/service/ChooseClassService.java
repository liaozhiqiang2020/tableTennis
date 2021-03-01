package com.tt.service;


import com.tt.pojo.ChooseClassEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * 选课service
 * @param <T>
 */
public interface ChooseClassService<T> {

    /**
     * 不分页查询所有ChooseClass
     *
     * @return 所有ChooseClass
     */
    List<ChooseClassEntity> findAllChooseClassByPlaceId(String placeId);

    Map<String,Object> findAllChooseClassByPage(int page, int pageSize, String placeId);
    Map<String,Object> findAllChooseClassByPageAndCourse(int page, int pageSize, String placeId, String courseId);

    /**
     * 更新ChooseClass对象
     *
     * @return 更新的ChooseClass对象
     */
    ChooseClassEntity updateChooseClass(ChooseClassEntity chooseClassEntity);

    /**
     * 保存ChooseClass对象
     *
     * @return 保存的ChooseClass对象
     */
    ChooseClassEntity saveChooseClass(ChooseClassEntity chooseClassEntity);

    /**
     * 删除一个ChooseClass对象
     *
     */
    int deleteChooseClass(int ChooseClassId);

    /**
     * 根据Id查询ChooseClass
     *
     * @return 查询结果
     */
    ChooseClassEntity findChooseClassById(String chooseClassId);


}
