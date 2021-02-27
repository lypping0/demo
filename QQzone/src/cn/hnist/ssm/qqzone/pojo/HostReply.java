package cn.hnist.ssm.qqzone.pojo;
/**
 * 话题人回复类
 * @author 曾宇哥
 *
 */

import java.util.Date;

public class HostReply {
	private int id;
	//回复内容
    private String content;
    //回复的日期
    private Date hostReplyDate;
    //主人话题id
    private int hostReplyId;
    //回复信息的id
    private int replyId;
    
    public HostReply() {
    	
    }
    

	public HostReply(String content, int hostReplyId, int replyId) {
		super();
		this.content = content;
		this.hostReplyId = hostReplyId;
		this.replyId = replyId;
	}


	public int getHostReplyId() {
		return hostReplyId;
	}

	public void setHostReplyId(int hostReplyId) {
		this.hostReplyId = hostReplyId;
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

	public Date getHostReplyDate() {
		return hostReplyDate;
	}

	public void setHostReplyDate(Date hostReplyDate) {
		this.hostReplyDate = hostReplyDate;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
    
}
