package model;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import play.data.format.Formats;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Recommands extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int numBest = 3;

	 
	public String user_id;
	 
	public String content_id;
	
	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date createDate;
	
	@Column(columnDefinition = "char(1)")
	public char status; 
	
	public static Finder<Long,Recommands> find = new Finder<Long,Recommands>(Long.class, Recommands.class); 
	
	
	
	public Recommands(String user_id, String content_id) {
		// TODO Auto-generated constructor stub
		this.user_id = user_id;
		this.content_id = content_id;
		this.createDate = new Date();
		this.status = 'Y';
	}
	
	public static Recommands getRecommands (String user_id, String content_id) {
		return find.where().eq("user_id", user_id).eq("content_id", content_id).findUnique();
	}
	
	public static Recommands addRecommands (String user_id, String content_id) {
		Recommands recommands = Recommands.getRecommands(user_id, content_id);
		if(recommands == null) {
			recommands = new Recommands(user_id, content_id);
			recommands.save();
			
			Contents contents = Contents.getContent(content_id);
			int recCount = contents.recCount;
			contents.recCount = recCount + 1;
			if(contents.recCount >= numBest)
				contents.isBest = 'Y';
			contents.update();
			
			return recommands;
		} else {
			return null;
		}
	}
	
	public static boolean removeRecommands (String user_id, String content_id) {
		Recommands recommands = Recommands.getRecommands(user_id, content_id);
		if(recommands != null) {
			recommands.delete();
			
			Contents contents = Contents.getContent(content_id);
			int recCount = contents.recCount - 1;
			if(recCount < 0)
				recCount = 0;
			contents.recCount = recCount;
			contents.update();
			
			return true;
		} else {
			return false;
		}
	}
}
