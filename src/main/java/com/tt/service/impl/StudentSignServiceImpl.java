package com.tt.service.impl;

import com.tt.pojo.StudentSignEntity;
import com.tt.repository.StudentSignRepository;
import com.tt.service.StudentSignService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StudentSignServiceImpl implements StudentSignService {
    @Autowired
    private StudentSignRepository studentSignRepository;


    @Override
    public Map<String, Object> findStudentSignByPage(int page, int pageSize) {
        return null;
    }

    @Override
    public Map<String, Object> findStudentSignByPage2(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.studentSignRepository.findAllStudentSignByPage2((page-1)*pageSize,pageSize);
        int total = this.studentSignRepository.findAllStudentSignTotal();
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public List<StudentSignEntity> findAllStudentSign() {
        return null;
    }

    @Override
    public StudentSignEntity updateStudentSign(StudentSignEntity studentSignEntity) {
        return null;
    }

    @Override
    public StudentSignEntity saveStudentSign(StudentSignEntity studentSignEntity) {
        return this.studentSignRepository.save(studentSignEntity);
    }

    @Override
    public int deleteStudentSign(int studentSignId) {
        return 0;
    }

    @Override
    public StudentSignEntity findStudentSignById(int studentSignId) {
        return null;
    }

    @Override
    public List<StudentSignEntity> findStudentSignByPlaceId(int placeId) {
        return null;
    }

    @Override
    public StudentSignEntity querySign(int id) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String signtime = df.format(new Date());
        //改为一天可以签到多次
//        return this.studentSignRepository.querySign(id,signtime);
        return this.studentSignRepository.querySign(id);
    }
}
