package net.flyingfat.web.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.flyingfat.web.dao.UserMapper;
import net.flyingfat.web.model.UserVO;

@Repository
public class UserDAOImpl  {
	
	@Autowired
	private UserMapper userMapper;

    public List<UserVO> getAllUsers()
    {
        /*List<UserVo> users = new ArrayList<UserVo>();
        UserVo vo1 = new UserVo();
        vo1.setId(1);
        vo1.setFirstName("Lokesh");
        vo1.setLastName("Gupta");
        users.add(vo1);
        UserVo vo2 = new UserVo();
        vo2.setId(2);
        vo2.setFirstName("Raj");
        vo2.setLastName("Kishore");
        users.add(vo2);
        return users;*/
    	return userMapper.getAllUsers();
    }
    
    

}
