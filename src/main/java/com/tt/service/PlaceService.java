package com.tt.service;


import com.tt.pojo.PlaceEntity;

import java.util.List;
import java.util.Map;

/**
 * 场地service
 * @param <T>
 */
public interface PlaceService<T> {

    /**
     * 根据名字查询
     * @return
     */
    PlaceEntity findPlaceByPlaceName(String placeName);

    /**
     * 分页查询所有Place
     *
     * @return 分页集合
     */
    Map<String,Object> findPlaceByPage(int page, int pageSize);

    /**
     * 不分页查询所有Place
     *
     * @return 所有Place
     */
    List<PlaceEntity> findAllPlace();

    /**
     * 更新Place对象
     *
     * @return 更新的Place对象
     */
    PlaceEntity updatePlace(PlaceEntity place);

    /**
     * 保存Place对象
     *
     * @return 保存的Place对象
     */
    PlaceEntity savePlace(PlaceEntity place);

    /**
     * 删除一个Place对象
     *
     */
    int deletePlace(int placeId);

    /**
     * 根据Id查询Place
     *
     * @return 查询结果
     */
    PlaceEntity findPlaceById(int placeId);



}
