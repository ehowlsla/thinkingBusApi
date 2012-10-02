package model;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.swing.text.AbstractDocument.Content;

import play.data.format.Formats;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Replies extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	public Users user;
	
	public long content_id;
	
	@Column(columnDefinition = "text")
	public String replyContents;
	
	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date createDate;
	
	@Column(columnDefinition = "char(1)")
	public char status;

	public static Finder<Long,Replies> find = new Finder<Long,Replies>(Long.class, Replies.class); 
	
	
	public Replies(Users user, Contents content, String replyContents) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.content_id = content.id;
		this.replyContents = replyContents;
		this.createDate = new Date();
		this.status = 'Y';
	}	
	
	
	public static List<Replies> getContentReplies (String user_idx, String udid, String content_idx, String laReDate, String rSize) {
		if(laReDate.equals("0"))
			return find.where().eq("content_id", Long.parseLong(content_idx)).orderBy("create_date asc").findPagingList(Integer.valueOf(rSize)).getPage(0).getList();
		else
			return find.where().eq("content_id", Long.parseLong(content_idx)).gt("create_date", Integer.valueOf(laReDate)).orderBy("create_date asc").findPagingList(Integer.valueOf(rSize)).getPage(0).getList();
	}
	
	public static Replies getContentReplyByContent (String user_idx, String udid, String content_idx, String content) {
		return find.where().eq("user_id", Long.valueOf(user_idx)).eq("content_id", Long.valueOf(content_idx)).eq("reply_contents", content).eq("status", "Y").findUnique();
	}
	
	public static Replies getContentReplyByTime (String user_idx, String udid, String content_idx, String reDate) {
		return find.where().eq("user_id", Long.valueOf(user_idx)).eq("content_id", Long.valueOf(content_idx)).eq("create_date", reDate).findUnique();
	}
	
	
	public static Replies upload (String user_idx, String udid, String content_idx, String content) {
		Replies reply = null;
		if(Replies.getContentReplyByContent(user_idx, udid, content_idx, content) == null)
		{
			Users user = Users.getUserId(user_idx, udid);
			Contents contents = Contents.getContent(content_idx);
			int replyCount = contents.replyCount;
			contents.replyCount = replyCount + 1;
			contents.update();
			
			reply = new Replies(user, contents, content);
			reply.save();
		}
		return reply;
	}
	
	public static Replies delete (String user_idx, String udid, String content_idx, String reDate) {
		Replies reply = Replies.getContentReplyByTime(user_idx, udid, content_idx, reDate);
		if(user_idx.equals(String.valueOf(reply.user.id)) && udid.equals(reply.user.udid)) {
			reply.status = 'N';
			reply.update();
		}
		return reply;
	}
}
