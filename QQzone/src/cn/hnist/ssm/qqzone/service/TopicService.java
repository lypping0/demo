package cn.hnist.ssm.qqzone.service;

import java.util.List;


import cn.hnist.ssm.qqzone.pojo.Topic;

public interface TopicService {
	 //获取特定用户的日志列表
		List<Topic> getTopicList(int userId);
		//获取特定日志信息
		Topic getTopic(int id);
		//添加新日志
		void addTopic(Topic topic);
		//删除特定日志
		void delTopic(int id);
}
