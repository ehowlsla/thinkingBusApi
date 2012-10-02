package responseObj;

import java.util.Date;

import model.Contents;
import model.Users;

public class ContentsObj {

	public long id;
	public String title;
	public String contents;
	public String busTag;
	public Date createDate;
	public int recCount;	
	public int viewCount;
	public int replyCount;
	public char status;
	public char isBest;
	public char isNotice;
	public UsersObj user;
	
	public ContentsObj(Contents contents) {
		// TODO Auto-generated constructor stub
		this.id = contents.id;
		this.title = contents.title;
		this.contents = contents.contents;
		this.busTag = contents.busTag;
		this.createDate = contents.createDate;
		this.recCount = contents.recCount;
		this.viewCount = contents.viewCount;
		this.replyCount = contents.replyCount;
		this.status = contents.status;
		this.isBest = contents.isBest;
		this.isNotice = contents.isNotice;
		this.user = new UsersObj(contents.user);
	}
}
 