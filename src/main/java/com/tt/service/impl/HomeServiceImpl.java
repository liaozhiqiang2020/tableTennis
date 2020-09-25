package com.tt.service.impl;

import com.tt.pojo.UserEntity;
import com.tt.pojo.vo.HomeVO;
import com.tt.service.HomeService;
import org.springframework.stereotype.Service;


/**
 * 主页面信息
 */
@Service
public class HomeServiceImpl implements HomeService {


    /**
     * 主页面显示数据
     * @param user 用户信息
     * @return 设备 订单 收入 故障 数据
     */
    @Override
    public HomeVO dataDisplay(UserEntity user) {
/*        //判断用户的等级
        int gradeId = user.getGradeId(); //用户等级
        int pId=user.getpId();//隶属单位
        HomeVO result = new HomeVO();//结果集

        result.setNmoDevice(deviceRepository.getDeviceCount());//正常设备数
        result.setExpDevice(deviceRepository.getDeviceErrorCount()); //异常设备数
        result.setYedOrder(12);//昨天的订单数
        result.setYedInc(new BigDecimal("12.3"));//昨天的收入*/

        return null;
    }
}
