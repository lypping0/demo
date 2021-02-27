package cn.hnist.ssm.qqzone.pojo;
/**
 * 用户详细信息
 * @author 曾宇哥
 *
 */

import java.util.Date;

public class UserDetail {
   
   private int id;
   //真实姓名
   private String realName;
  
   //生日
   private Date birth;
   //住址
   private String address;
   
   private int Uid;
   
   
   
public UserDetail() {
	super();
}






public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public int getUid() {
	return Uid;
}






public void setUid(int uid) {
	Uid = uid;
}






public String getRealName() {
	return realName;
}



public void setRealName(String realName) {
	this.realName = realName;
}


public Date getBirth() {
	return birth;
}



public void setBirth(Date birth) {
	this.birth = birth;
}


public String getAddress() {
	return address;
}



public void setAddress(String address) {
	this.address = address;
}
   
   
}
