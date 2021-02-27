package cn.hnist.ssm.qqzone.pojo;

import java.util.List;

/**
 * 用户类
 * @author 曾宇哥
 *
 */
public class User {
    private int id;
    //登录账号
    private String loginId;
    //密码
    private String password;
    //昵称
    private String nickName;
    
    private List<User> friends;
    
    public User() {
    	
    }

    
    
	public List<User> getFriends() {
		return friends;
	}



	public void setFriends(List<User> friends) {
		this.friends = friends;
	}



	public User(String loginId, String password, String nickName) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.nickName = nickName;
	}



	public User(int id, String loginId, String password, String nickName) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.nickName = nickName;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLoginId() {
		return loginId;
	}



	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

    
}
