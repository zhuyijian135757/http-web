package net.flyingfat.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.flyingfat.web.dao.UserMapper;
import net.flyingfat.web.model.UserVO;
import net.flyingfat.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper dao;
 
    public List<UserVO> getAllUsers()
    {
        return dao.getAllUsers();
    }

}
