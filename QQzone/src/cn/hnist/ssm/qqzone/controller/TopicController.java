package cn.hnist.ssm.qqzone.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.ssm.qqzone.pojo.Topic;
import cn.hnist.ssm.qqzone.pojo.User;
import cn.hnist.ssm.qqzone.service.ReplyService;
import cn.hnist.ssm.qqzone.service.TopicService;
 
@Controller
@RequestMapping("/topic")
public class TopicController {  
	
	@Resource
	private TopicService topicService;
	@Resource
	private ReplyService replyService;
	
	
     @RequestMapping("/topicList")
	public String topicList(HttpServletRequest request ,Model model ) {
		String fidString=request.getParameter("fid");
		int fid=Integer.parseInt(fidString);
	
		List<Topic> topicList =topicService.getTopicList(fid);
		HttpSession session=request.getSession();
		session.setAttribute("topicList",topicList);
		session.setAttribute("fid",fid);
		
		return "main";
	}
     
     @RequestMapping("/addTopic")
 	public String addTopic(HttpServletRequest request ,Model model ) {
 		
    	HttpSession session=request.getSession();
 		User user =(User) session.getAttribute("currUser");
    	String title=request.getParameter("title");
 		String content=request.getParameter("content");
 		Topic topic=new Topic(title,content,new Date(),user.getId());
 		topicService.addTopic(topic);
 		return "redirect:/topic/topicList?fid="+user.getId();
 	}
     @RequestMapping("/topicDetail")
 	public String topicDetail(HttpServletRequest request , Model model){
 		
 		int topicId = Integer.parseInt(request.getParameter("topicId"));
 		Topic topic = topicService.getTopic(topicId);
 		
 		int replyCount = replyService.getReplyCount(topicId);
 		topic.setReplyCount(replyCount);
 		
 		HttpSession session = request.getSession() ;
 		session.setAttribute("topic",topic);
 		
 		return "detail";
 	}
     @RequestMapping("delTopic")
 	public String delTopic(HttpServletRequest request , Model model){
 		int topicId = Integer.parseInt(request.getParameter("topicId"));
 		topicService.delTopic(topicId);
 		HttpSession session = request.getSession() ;
 		User user = (User)session.getAttribute("currUser");
 		return "redirect:/topic/topicList.do?fid="+user.getId();
 	}
}
