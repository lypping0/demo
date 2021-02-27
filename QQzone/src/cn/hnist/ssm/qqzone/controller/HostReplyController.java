package cn.hnist.ssm.qqzone.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.ssm.qqzone.pojo.HostReply;
import cn.hnist.ssm.qqzone.pojo.Topic;
import cn.hnist.ssm.qqzone.pojo.User;
import cn.hnist.ssm.qqzone.service.HostReplyService;

@Controller
@RequestMapping("hostReply")
public class HostReplyController {
	
	@Resource
	private HostReplyService hostReplyService ;
	
	@RequestMapping("addHostReply")
	public String addHostReply(HttpServletRequest request , Model model){
		
		String content = request.getParameter("content");
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		
		HttpSession session = request.getSession() ;
		User user = (User) session.getAttribute("currUser");
		
		HostReply hostReply = new HostReply(content, user.getId(), replyId);
		hostReplyService.addHostReply(hostReply);
		
		Topic currTopic = (Topic)session.getAttribute("topic");
		return "redirect:/topic/topicDetail.do?topicId="+currTopic.getId();
	}
	
	@RequestMapping("delHostReply")
	public String delHostReply(HttpServletRequest request , Model model){
		int hostReplyId = Integer.parseInt(request.getParameter("hostReplyId"));
		
		HttpSession session = request.getSession() ;
		hostReplyService.delHostReply(hostReplyId);
		
		Topic currTopic = (Topic)session.getAttribute("topic");
		return "redirect:/topic/topicDetail.do?topicId="+currTopic.getId();
	}
	
}
