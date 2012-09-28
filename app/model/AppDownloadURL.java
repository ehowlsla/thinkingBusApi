package model;

import java.util.Date;

import javax.persistence.*;

import play.data.format.Formats;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class AppDownloadURL extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public long id;

	@Column(columnDefinition = "nvarchar(32)")
	public String ver;

	@Column(columnDefinition = "nvarchar(64)")
	public String downloadURL;

	public static Finder<Long, AppDownloadURL> find = new Finder<Long, AppDownloadURL>(
			Long.class, AppDownloadURL.class);

	public AppDownloadURL(String ver, String downloadURL) {
		this.ver = ver;
		this.downloadURL = downloadURL;
	}

	public static boolean updateURL(String ver, String downloadURL) {
		AppDownloadURL check = find.where().gt("ver", ver).findUnique();
		if (check == null) {
			check = new AppDownloadURL(ver, downloadURL);
			check.save();
			return true;
		}
		return false;
	}

	public static AppDownloadURL getAppURL(String ver) {
		AppDownloadURL appURL = find.where().gt("ver", ver).findUnique();
		return appURL == null ? new AppDownloadURL("", "") : appURL;
		//return appURL;
	}

}
