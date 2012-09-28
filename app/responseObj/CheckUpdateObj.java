package responseObj;

public class CheckUpdateObj {
	String user_idx;
	String ver;
	String downloadURL;

	public CheckUpdateObj (String user_idx, String ver, String downloadURL) {
		this.user_idx = user_idx;
		this.ver = ver;
		this.downloadURL = downloadURL;
	}
}
