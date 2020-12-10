package com.tt.service;


import com.tt.pojo.ChooseClassRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 选课记录service
 * @param <T>
 */
public interface ChooseClassRecordService<T> {


    Map<String,Object> findAllChooseClassByPage(int page, int pageSize, String placeId);

    /**
     * 更新ChooseClass对象
     *
     * @return 更新的ChooseClass对象
     */
    ChooseClassRecordEntity updateChooseClass(ChooseClassRecordEntity ChooseClassRecordEntity);

    /**
     * 保存ChooseClass对象
     *
     * @return 保存的ChooseClass对象
     */
    ChooseClassRecordEntity saveChooseClass(ChooseClassRecordEntity ChooseClassRecordEntity);

    /**
     * 根据Id查询ChooseClass
     *
     * @return 查询结果
     */
    ChooseClassRecordEntity findChooseClassById(int chooseClassId);


}
