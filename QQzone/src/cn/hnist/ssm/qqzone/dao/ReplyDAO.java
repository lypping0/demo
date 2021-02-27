package cn.hnist.ssm.qqzone.dao;

import java.util.List;

import cn.hnist.ssm.qqzone.pojo.Reply;

public interface ReplyDAO {
    //查询特定日志的所有回复
	List<Reply> getReplyList(int topicId);
	//添加新回复
	void  addReply(Reply reply);
	//删除特定回复
	void delReply(int id);
	//获取回复数量
	int getReplyCount(int topicId);
}
