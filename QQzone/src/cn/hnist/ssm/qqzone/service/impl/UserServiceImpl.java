package cn.hnist.ssm.qqzone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hnist.ssm.qqzone.dao.UserDAO;
import cn.hnist.ssm.qqzone.pojo.User;
import cn.hnist.ssm.qqzone.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDAO userDAO;
	
	@Override
	public User login(String loginId, String password) {
		
		User user=userDAO.getUser(loginId, password);
		if(user!=null) {
	   List<User> friends=userDAO.getFriends(user.getId());
			 user.setFriends(friends);
		}
		
		return  user;
	}
        
}
