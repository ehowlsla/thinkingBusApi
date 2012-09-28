package model;

import java.util.Date;

import javax.persistence.*;
 
 

import play.data.format.Formats;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Users extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	public long id;
	
	@Column(columnDefinition = "nvarchar(255)")
	public String nickname;
	
	@Column(columnDefinition = "nvarchar(100)")
	public String udid;
	
	@Column(columnDefinition = "text")
	public String memo;
	
	@Column(columnDefinition = "char(1)")
	public char status;
	
	@Column(columnDefinition = "char(1)")
	public char gender;
	
	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date createDate;
	
	@Column(columnDefinition = "nvarchar(255)")
	public String imageURL;

	public static Finder<Long,Users> find = new Finder<Long,Users>(Long.class, Users.class); 
	
	public Users (String udid) {
		this.nickname = "이름없음";
		this.udid = udid;
		this.memo = "자기소개가 없습니다.";
		this.status = 'Y';
		this.gender = 'F';
		this.createDate = new Date();
		this.imageURL = "";
	}
    
	public static Users getUserId(String user_idx, String udid) {
		Users user = null;
		
		if(user_idx.equals("0")) {
			user = getUser(udid);
			
			if(user == null) {
				//회원가입 
				user = new Users(udid);
				user.save();
			}
			
		}
		else {
			//user 정보 가져오기 
			user =  find.where().eq("udid", udid).findUnique();
		}
		
		return user;
	}
	
	public static Users getUser(String user_idx, String nickname) {
		return find.where().ne("id", Long.valueOf(user_idx)).eq("nickname", nickname).findUnique();
	}
	
	public static Users getUser(String udid) {
		return find.where().eq("udid", udid).findUnique();
	}
	
	public static Users update (String user_idx, String udid, String nickname, String gender, String memo) {
		Users user = null;
		if(Users.getUser(user_idx, nickname) == null)
		{
			user = Users.getUserId(user_idx, udid);
			//중복처리 해야
			user.nickname = nickname;
			user.gender = gender.charAt(0);
			user.memo = memo;
			//이미지 업로
			
			user.update();
		}
		
		
		return user;
	}
}
