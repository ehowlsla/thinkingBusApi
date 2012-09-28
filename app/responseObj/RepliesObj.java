package responseObj;

import java.util.Date;

import model.Replies;

public class RepliesObj {

	public UsersObj user;
	public long content_id;
	public String replyContents;
	public Date createDate;
	public char status;

	public RepliesObj(Replies replies) {
		// TODO Auto-generated constructor stub
		this.user = new UsersObj(replies.user);
		this.content_id = replies.content_id;
		this.replyContents = replies.replyContents;
		this.createDate = replies.createDate;
		this.status = replies.status;
	}
}
