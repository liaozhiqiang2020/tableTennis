package com.tt.service.impl;

import com.tt.pojo.MemberEntity;
import com.tt.repository.MemberRepository;
import com.tt.service.MemberService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository MemberRepository;

    @Override
    public MemberEntity findMemberByTel(String tel) {
        return this.findMemberByTel(tel);
    }

    @Override
    public Map<String,Object> findMemberByPage(int page, int pageSize) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.MemberRepository.findAllMemberByPage((page-1)*pageSize,pageSize);
        int total = this.MemberRepository.findAllMemberTotal();
        result.put("code", 0);
        result.put("data", list);
        result.put("count", total);
        return result;
    }

    @Override
    public Map<String, Object> getListByPageAndOther(int page, int pageSize, String name,String tel) {
        Map<String,Object> result = new HashedMap();
        List<Map<String,Object>> list = this.MemberRepository.getListByPageAndOther((page-1)*pageSize,pageSize,name,tel);
        int total = this.MemberRepository.findAllMemberTotal(name,tel);
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
    public List<MemberEntity> findAllMember() {
        return this.MemberRepository.findAllMember();
    }

    @Override
    public MemberEntity updateMember(MemberEntity Member) {
        return this.MemberRepository.save(Member);
    }

    @Override
    public MemberEntity saveMember(MemberEntity Member) {
        return this.MemberRepository.save(Member);
    }

    @Override
    public int deleteMember(int MemberId) {
        return this.MemberRepository.deleteById(MemberId);
    }

    @Override
    public MemberEntity findMemberById(int MemberId) {
        return this.MemberRepository.findMemberById(MemberId);
    }
}
