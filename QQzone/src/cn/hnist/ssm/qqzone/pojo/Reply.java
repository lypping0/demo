package cn.hnist.ssm.qqzone.pojo;
import java.util.Date;
/**
 * 回复信息类
 * @author 曾宇哥
 *
 */
public class Reply {
    private int id;
    //回复内容
    private String content;
    //回复的日期
    private Date replyDate;
    //用户的id
    private int userId;
    //话题的id
    private int topicId;
    //主人回复
    private HostReply hostReply;
    
    private User author ;
    
    public Reply() {
    	
    }

	public Reply(String content, Date replyDate, int userId, int topicId) {
		super();
		this.content = content;
		this.userId = userId;
		this.topicId = topicId;
		this.replyDate=replyDate;
	}

	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public HostReply getHostReply() {
		return hostReply;
	}

	public void setHostReply(HostReply hostReply) {
		this.hostReply = hostReply;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
    
}
