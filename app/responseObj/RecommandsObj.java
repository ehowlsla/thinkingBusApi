package responseObj;

import java.util.Date;

import model.Recommands;

 
public class RecommandsObj {
	public String user_id;	 
	public String content_id;
 	public Date createDate;
 	public char status; 
 	
 	public RecommandsObj(Recommands recommands) {
		// TODO Auto-generated constructor stub
		this.user_id = recommands.user_id;
		this.content_id = recommands.content_id;
		this.createDate = recommands.createDate;
		this.status = recommands.status;
	}
}
