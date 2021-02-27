package cn.hnist.ssm.qqzone.pojo;
/**
 * 话题类
 */
import java.util.Date;
import java.util.List;

public class Topic {
     private int id;
     //标题
     private String title;
     //内容
     private String content;
     //话题的时间
     private Date topicDate;
     //用户id
     private int userId;
     
     private List<Reply> replyList;
     
     private int replyCount;
     
     public Topic() {
		
	}

     
	public Topic(String title, String content, Date topicDate, int userId) {
		super();
		this.title = title;
		this.content = content;
		this.topicDate = topicDate;
		this.userId = userId;
	}


	public int getReplyCount() {
		return replyCount;
	}


	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}


	public List<Reply> getReplyList() {
		return replyList;
	}


	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTopicDate() {
		return topicDate;
	}

	public void setTopicDate(Date topicDate) {
		this.topicDate = topicDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
     
}
