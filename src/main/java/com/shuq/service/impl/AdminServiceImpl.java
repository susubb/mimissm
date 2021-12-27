package com.shuq.service.impl;

import com.shuq.mapper.AdminMapper;
import com.shuq.pojo.Admin;
import com.shuq.pojo.AdminExample;
import com.shuq.service.AdminService;
import com.shuq.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //在业务逻辑层中，一定会有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        //根据传入的用户名或到DB中查询相应用户对象
        //如果有条件，则一定要创建AdminExample的对象，用来封装条件
        AdminExample example = new AdminExample();
        /**如何添加条件
         * select * from admin where a_name = 'admin'
         */
        //添加用户名a_name条件
        example.createCriteria().andANameEqualTo(name);

        List<Admin> list = adminMapper.selectByExample(example);
        if (list.size() > 0){
            Admin admin = list.get(0);
            //如果查询到用户对象，再进行密码的对比,注意：密码是密文
            /**
             * 分析：
             * admin.getApass=>c984aed014aec7623a54f0591da07a85fd4b762d
             * pwd==>000000
             * 在进行密码对比时，要将传入的pwd进行md5加密，再与数据库中查到的对象的密码进行对比
             */
            String miPwd = MD5Util.getMD5(pwd);
            if (miPwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }
}
