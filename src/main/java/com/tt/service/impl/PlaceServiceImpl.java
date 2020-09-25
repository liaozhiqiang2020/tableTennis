package com.tt.service.impl;

import com.tt.pojo.PlaceEntity;
import com.tt.repository.PlaceRepository;
import com.tt.service.PlaceService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public PlaceEntity findPlaceByPlaceName(String PlaceName) {
        return this.findPlaceByPlaceName(PlaceName);
    }

    @Override
    public Map<String, Object> findPlaceByPage(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<PlaceEntity> list = this.placeRepository.findAllPlaceByPage((page-1)*10,pageSize);
        int total = this.placeRepository.findAllPlaceTotal();
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public List<PlaceEntity> findAllPlace() {
        return this.placeRepository.findAllPlace();
    }

    @Override
    public PlaceEntity updatePlace(PlaceEntity place) {
        return this.placeRepository.save(place);
    }

    @Override
    public PlaceEntity savePlace(PlaceEntity place) {
        return this.placeRepository.save(place);
    }

    @Override
    public int deletePlace(int placeId) {
        return this.placeRepository.deleteById(placeId);
    }

    @Override
    public PlaceEntity findPlaceById(int placeId) {
        return this.placeRepository.findPlaceById(placeId);
    }
}
