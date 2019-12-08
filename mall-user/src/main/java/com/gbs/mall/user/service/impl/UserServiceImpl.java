package com.gbs.mall.user.service.impl;


import com.gbs.mall.user.bean.UmsMember;
import com.gbs.mall.user.bean.UmsMemberReceiveAddress;
import com.gbs.mall.user.mapper.UmsMemberReceiveAddressMapper;
import com.gbs.mall.user.mapper.UserMapper;
import com.gbs.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
//        List<UmsMember> umsMembers = userMapper.selectAllUser();//不使用通用mapper
        List<UmsMember> umsMembers = userMapper.selectAll();//使用通用mapper
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        /*根据umsMemberReceiveAddresses中不为空的的键进行查询*/
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }

}
