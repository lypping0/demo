package cn.hnist.ssm.qqzone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hnist.ssm.qqzone.dao.HostReplyDAO;
import cn.hnist.ssm.qqzone.dao.ReplyDAO;
import cn.hnist.ssm.qqzone.pojo.HostReply;
import cn.hnist.ssm.qqzone.pojo.Reply;
import cn.hnist.ssm.qqzone.service.ReplyService;
@Service
public class ReplyServiceImpl implements ReplyService {
   
	@Resource
	private ReplyDAO replyDAO;
	@Resource
	private HostReplyDAO hostReplyDAO;
	@Override
	public List<Reply> getReplyList(int topicId) {
	     
		List<Reply> replyList=replyDAO.getReplyList(topicId);
		if(replyList!=null&&replyList.size()>0) {
			for (Reply reply : replyList) {
				int replyId=reply.getId();
				HostReply hostReply=hostReplyDAO.getHostReplyByReplyId(replyId);
				reply.setHostReply(hostReply);
			}
		}
		return replyList;
	}

	@Override
	public void addReply(Reply reply) {
		replyDAO.addReply(reply);
		
	}

	@Override
	public void delReply(int id) {
		HostReply hostReply=hostReplyDAO.getHostReplyByReplyId(id);
        if(hostReply!=null) {
        	hostReplyDAO.delHostReply(hostReply.getId());
        }
		replyDAO.delReply(id);		
	}

	@Override
	public int getReplyCount(int topicId) {
		
		return replyDAO.getReplyCount(topicId);
	}

}
