package cn.hnist.ssm.qqzone.service;

import cn.hnist.ssm.qqzone.pojo.HostReply;

public interface HostReplyService {
	//添加主人回复
	  void addHostReply(HostReply hostReply);
		 
	 //删除特定主人回复
	  void delHostReply(int id);
	  
	 //查询主人回复
	  HostReply getHostReplyByReplyId(int replyId);
}
