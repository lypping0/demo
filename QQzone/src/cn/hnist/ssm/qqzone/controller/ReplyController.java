package cn.hnist.ssm.qqzone.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.ssm.qqzone.pojo.Reply;
import cn.hnist.ssm.qqzone.pojo.Topic;
import cn.hnist.ssm.qqzone.pojo.User;
import cn.hnist.ssm.qqzone.service.ReplyService;



@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Resource
	private ReplyService replyService ;
	
	@RequestMapping("addReply")
	public String addReply(HttpServletRequest request , Model model){
		
		String content = request.getParameter("content");
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		
		HttpSession session = request.getSession() ;
		User user = (User)session.getAttribute("currUser");
		
		Reply reply = new Reply(content,new Date(), user.getId(), topicId);
		
		replyService.addReply(reply);
		
		return "redirect:/topic/topicDetail.do?topicId="+topicId;
	}
	
	@RequestMapping("delReply")
	public String delReply(HttpServletRequest request , Model model){
		
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		
		HttpSession session = request.getSession() ;
		Topic currTopic = (Topic)session.getAttribute("topic");
		
		replyService.delReply(replyId);
		
		return "redirect:/topic/topicDetail.do?topicId="+currTopic.getId();
	}
}
