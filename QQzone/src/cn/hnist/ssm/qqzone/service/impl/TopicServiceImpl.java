package cn.hnist.ssm.qqzone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hnist.ssm.qqzone.dao.ReplyDAO;
import cn.hnist.ssm.qqzone.dao.TopicDAO;
import cn.hnist.ssm.qqzone.pojo.Reply;
import cn.hnist.ssm.qqzone.pojo.Topic;
import cn.hnist.ssm.qqzone.service.ReplyService;
import cn.hnist.ssm.qqzone.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Resource
	private TopicDAO topicDAO ;
	@Resource
	private ReplyService replyService ;
	@Override
	
	public List<Topic> getTopicList(int userId) {
		
		return topicDAO.getTopicList(userId);
	}

	@Override
	public Topic getTopic(int id) {
		Topic topic=topicDAO.getTopic(id);
		if(topic !=null) {
			List<Reply> replyList=replyService.getReplyList(topic.getId());
		    topic.setReplyList(replyList);
		}
		return topic;
	}

	@Override
	public void addTopic(Topic topic) {
		
	topicDAO.addTopic(topic);
	}

	@Override
	public void delTopic(int id) {
		List<Reply> replyList=replyService.getReplyList(id);
		if(replyList!=null&&replyList.size()>0) {
			for (Reply reply : replyList) {
				  replyService.delReply(reply.getId());
			}
		}
	  
		topicDAO.delTopic(id);
		
	}
       
}
