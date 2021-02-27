package cn.hnist.ssm.qqzone.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.ssm.qqzone.pojo.Topic;
import cn.hnist.ssm.qqzone.pojo.User;
import cn.hnist.ssm.qqzone.service.TopicService;
import cn.hnist.ssm.qqzone.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	   @Resource
       private UserService userService;
	   @Resource
	   private TopicService topicService;
	   @RequestMapping("/login")
	   public String login(HttpServletRequest request,Model model) {
		   String loginId=request.getParameter("loginId");
		   String password=request.getParameter("password");
		   //1.登陆验证和好友列表
		  User currUser =userService.login(loginId, password);
		   //2.日志列表
		  if(currUser!=null) {
			  HttpSession session=request.getSession();
				session.setAttribute("currUser", currUser);
				session.setAttribute("fid", currUser.getId());
			  List<Topic> topicList=topicService.getTopicList(currUser.getId());
			
			session.setAttribute("topicList", topicList);
		  }
		   
		  return "index";
	   }
}
