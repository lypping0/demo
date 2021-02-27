package cn.hnist.ssm.qqzone.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.hnist.ssm.qqzone.pojo.User;

public interface UserDAO {
    User getUser(@Param("loginId")String loginId,@Param("password")String password);
    
    List<User> getFriends(int id);
}
