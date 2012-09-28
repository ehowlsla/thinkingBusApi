package model;
import java.util.Date;

import javax.persistence.*;

import play.data.format.Formats;
import play.db.ebean.Model;

@Entity
public class Recommands extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	public Users user;
	
	@ManyToOne
	public Contents content;
	
	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date createDate;
	
	@Column(columnDefinition = "char(1)")
	public char status; 
}
