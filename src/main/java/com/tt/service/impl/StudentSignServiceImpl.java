package com.tt.service.impl;

import com.tt.pojo.CoachEntity;
import com.tt.pojo.StudentSignEntity;
import com.tt.pojo.UserEntity;
import com.tt.repository.CoachRepository;
import com.tt.repository.StudentSignRepository;
import com.tt.repository.UserRepository;
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
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private UserRepository userRepository;


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
    public Map<String, Object> getListByPageAndOther(int page, int pageSize, String name,String studentName, String startTime, String endTime) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list;
        int total;

        String userId="";
        String studentId = studentName;
        if(!name.equals("")){
            CoachEntity coachEntity = this.coachRepository.findCoachEntityById(Integer.parseInt(name));
            if(coachEntity!=null){
                UserEntity userEntity = this.userRepository.findUserByName(coachEntity.getName());
                userId=String.valueOf(userEntity.getId());
            }
        }

        if(startTime.equals("") && endTime.equals("")){
            list = this.studentSignRepository.getListByPageAndOther((page-1)*pageSize,pageSize,userId,studentId);
            total = this.studentSignRepository.findAllStudentSignTotal(userId,studentId);
        }else{
            list = this.studentSignRepository.getListByPageAndOther2((page-1)*pageSize,pageSize,userId,studentId,startTime,endTime);
            total = this.studentSignRepository.findAllStudentSignTotal2(userId,studentId,startTime,endTime);
        }

        int pages=total/pageSize;
        if(total%pageSize!=0){
            pages++;
        }
        result.put("code", 0);
        result.put("data", list);
        result.put("pages", pages);
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
