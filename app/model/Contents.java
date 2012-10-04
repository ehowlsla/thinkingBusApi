package model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Expr;

import play.data.format.Formats;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Contents extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	public long id;
	
	@Column(columnDefinition = "nvarchar(255)")
	public String title;
	
	@Column(columnDefinition = "text")
	public String contents;
	
	@Column(columnDefinition = "nvarchar(255)")
	public String busTag;
	
	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date createDate;
	
	public int recCount;
	
	public int viewCount;
	
	public int replyCount;
	
	@Column(columnDefinition = "char(1)")
	public char status;
	
	@Column(columnDefinition = "char(1)")
	public char isBest;
	
	@Column(columnDefinition = "char(1)")
	public char isNotice;
	
	@ManyToOne
	public Users user;
	
//	@Column(columnDefinition = "nvarchar(255)")
//	public String imageURL;
	
	public static Finder<Long,Contents> find = new Finder<Long,Contents>(Long.class, Contents.class); 
	
	
	public Contents(Users user, String title, String content, String busTag, String isNotice) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.contents = content;
		this.busTag = busTag;
		this.createDate = new Date();
		this.recCount = 0;
		this.viewCount = 0;
		this.status = 'Y';
		this.isBest = 'N';
		this.user = user;
		this.replyCount = 0;
		this.isNotice = isNotice.charAt(0);
		
		//this.imageURL = imageURL;
	}
	
	public static List<Contents> getContentList (String user_idx, String udid, String content_idx, String pSize) {
		if(content_idx.equals("0"))
			return find.where().orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
		else
			return find.where().gt("id", Integer.valueOf(content_idx)).orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
	}
	
	public static List<Contents> getBestContentList (String user_idx, String udid, String content_idx, String pSize) {
		if(content_idx.equals("0"))
			return find.where().eq("isBest", "Y").orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
		else
			return find.where().eq("isBest", "Y").gt("id", Integer.valueOf(content_idx)).orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
	}
	
	public static List<Contents> getContentListBySearch (String user_idx, String udid, String content_idx, String word, String mode, String pSize) {
		// 버스노선 1
		// 내용기반 2
		// 최신순 3
		// 추천순 4
		// 내가 쓴 글 보기 5
		switch(Integer.parseInt(mode)) {
			case 1:
				if(content_idx.equals("0"))
					return find.where().ilike("busTag", "%" + word + "%")
							.orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
				else			
					return find.where().lt("id", Integer.valueOf(content_idx)).ilike("busTag", "%" + word + "%")
					.orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
			case 2:
				if(content_idx.equals("0"))
					return find.where().or(Expr.ilike("contents", "%" + word + "%"), Expr.ilike("title", "%" + word + "%"))
							.orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
				else
					return find.where().lt("id", Integer.valueOf(content_idx)).or(Expr.ilike("contents", "%" + word + "%"), Expr.ilike("title", "%" + word + "%"))
						.orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
			case 3:
				if(content_idx.equals("0"))
					return find.where().orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
				else
					return find.where().lt("id", Integer.valueOf(content_idx)).orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
			case 4:
				if(content_idx.equals("0"))
					return find.where().orderBy("rec_count asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
				else
					return find.where().lt("id", Integer.valueOf(content_idx)).orderBy("rec_count asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
			case 5:
				if(content_idx.equals("0"))
					return find.where().eq("user_id", user_idx).orderBy("rec_count asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
				else
					return find.where().lt("id", Integer.valueOf(content_idx)).eq("user_id", user_idx).orderBy("rec_count asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
				
		}
		
		if(content_idx.equals("0"))
			return find.where().orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
		else
			return find.where().lt("id", Integer.valueOf(content_idx)).orderBy("id asc").findPagingList(Integer.valueOf(pSize)).getPage(0).getList();
	}
	
	
	public static Contents getContent (String content_idx) {
		return find.where().eq("id", Long.valueOf(content_idx)).findUnique();
	}
	
	public static Contents getContent (String user_idx, String udid, String title, String content, String busTag, String isNotice) {
		return find.where().eq("user_id", Long.valueOf(user_idx)).eq("title", title).eq("contents", content).eq("bus_tag", busTag).eq("is_notice", isNotice).findUnique();
	}
	
	public static Contents getContentDetail (String user_idx, String udid, String content_idx) {
		Contents contents = Contents.getContent(content_idx);
		int viewCount = contents.viewCount;
		contents.viewCount = viewCount + 1;
		contents.update();
		return contents;
	}
	
	public static Contents upload (String user_idx, String udid, String title, String content, String busTag, String isNotice) {
		Contents contents = null;
		//중복체크 
		if(Contents.getContent(user_idx, udid, title, content, busTag, isNotice) == null)
		{
			Users user = Users.getUserId(user_idx, udid);
			contents = new Contents(user, title, content, busTag, isNotice);
			contents.save();
		}
		return contents;
	}
	
	public static Contents update (String user_idx, String udid, String content_idx, String title, String content, String busTag, String isNotice) {
		Contents contents = Contents.getContent(content_idx);
		if(user_idx.equals(String.valueOf(contents.user.id)) && udid.equals(contents.user.udid)) {
			contents.title = title;
			contents.contents = content;
			contents.busTag = busTag;
			contents.isNotice = isNotice.charAt(0);
			contents.update();
			//이미지 로직 체크 
		}
		return contents;
	}
	
	public static Contents delete (String user_idx, String udid, String content_idx) {
		Contents contents = Contents.getContent(content_idx);
		if(user_idx.equals(String.valueOf(contents.user.id)) && udid.equals(contents.user.udid)) {
			contents.status = 'N';
			contents.update();
		}
		return contents;
	}
}
