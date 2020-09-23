package com.tt.service;


import com.tt.pojo.UserEntity;
import com.tt.pojo.vo.HomeVO;

public interface HomeService {

    //本接口用于登陆页面的数据显示

    HomeVO dataDisplay(UserEntity user);

}
