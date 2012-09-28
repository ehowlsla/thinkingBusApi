package responseObj;

import java.util.Date;

import javax.persistence.Column;

import model.Users;

import play.data.format.Formats;

public class UsersObj {

	public long id;
	public String nickname;
	public String udid;
	public String memo;
	public char status;
	public char gender;
	public Date createDate;
	public String imageURL;

	public UsersObj(Users user) {
		// TODO Auto-generated constructor stub
		this.id = user.id;
		this.nickname = user.nickname;
		this.udid = user.udid;
		this.memo = user.memo;
		this.status = user.status;
		this.gender = user.gender;
		this.createDate = user.createDate;
		this.imageURL = user.imageURL;
	}
}
