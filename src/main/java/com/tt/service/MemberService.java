package com.tt.service;


import com.tt.pojo.MemberEntity;

import java.util.List;
import java.util.Map;

/**
 * 会员service
 * @param <T>
 */
public interface MemberService<T> {
    /**
     * 根据手机号查询
     * @param tel
     * @return
     */
    MemberEntity findMemberByTel(String tel);

    /**
     * 分页查询所有Member
     *
     * @return 分页集合
     */
    Map<String,Object> findMemberByPage(int page, int pageSize);
    Map<String,Object> getListByPageAndOther(int page, int pageSize, String name, String tel);


    /**
     * 不分页查询所有Member
     *
     * @return 所有Member
     */
    List<MemberEntity> findAllMember();


    /**
     * 更新Member对象
     *
     * @return 更新的Member对象
     */
    MemberEntity updateMember(MemberEntity Member);

    /**
     * 保存Member对象
     *
     * @return 保存的Member对象
     */
    MemberEntity saveMember(MemberEntity Member);

    /**
     * 删除一个Member对象
     *
     */
    int deleteMember(int MemberId);

    /**
     * 根据Id查询Member
     *
     * @param MemberId Member主键
     * @return 查询结果
     */
    MemberEntity findMemberById(int MemberId);



}
