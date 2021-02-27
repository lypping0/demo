package cn.hnist.ssm.qqzone.service;

import cn.hnist.ssm.qqzone.pojo.User;

public interface UserService {
   User login(String loginId,String password);
}
