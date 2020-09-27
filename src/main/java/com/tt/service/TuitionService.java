package com.tt.service;


import com.tt.pojo.TuitionEntity;

import java.util.List;
import java.util.Map;

/**
 * 缴费service
 * @param <T>
 */
public interface TuitionService<T> {

    /**
     * 根据名字查询
     * @return
     */
    TuitionEntity findTuitionByTuitionName(String tuitionName);

    /**
     * 分页查询所有Tuition
     *
     * @return 分页集合
     */
    Map<String,Object> findTuitionByPage(int page, int pageSize);

    Map<String,Object> findTuitionByPage2(int page, int pageSize);

    /**
     * 不分页查询所有Tuition
     *
     * @return 所有Tuition
     */
    List<TuitionEntity> findAllTuition();

    /**
     * 更新Tuition对象
     *
     * @return 更新的Tuition对象
     */
    TuitionEntity updateTuition(TuitionEntity tuition);

    /**
     * 保存Tuition对象
     *
     * @return 保存的Tuition对象
     */
    TuitionEntity saveTuition(TuitionEntity tuition);

    /**
     * 删除一个Tuition对象
     *
     */
    int deleteTuition(int tuitionId);

    /**
     * 根据Id查询Tuition
     *
     * @return 查询结果
     */
    TuitionEntity findTuitionById(int tuitionId);



}
