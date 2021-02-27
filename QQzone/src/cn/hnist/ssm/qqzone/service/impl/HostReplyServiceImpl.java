package cn.hnist.ssm.qqzone.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hnist.ssm.qqzone.dao.HostReplyDAO;
import cn.hnist.ssm.qqzone.pojo.HostReply;
import cn.hnist.ssm.qqzone.service.HostReplyService;

@Service
public class HostReplyServiceImpl implements HostReplyService {
   
	@Resource
	private HostReplyDAO hostReplyDAO;
	@Override
	public void addHostReply(HostReply hostReply) {
	     hostReplyDAO.addHostReply(hostReply);
		
	}

	@Override
	public void delHostReply(int id) {
		hostReplyDAO.delHostReply(id);
		
	}

	@Override
	public HostReply getHostReplyByReplyId(int replyId) {
		
		return hostReplyDAO.getHostReplyByReplyId(replyId);
	}

}
