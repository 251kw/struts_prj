package sample2;

public class UserBean2 {

	private String loginId;		// ログインID
	private String password;	// パスワード
	private String userName;	// ユーザ名
	private String icon;		// ユーザアイコン
	private String profile;		// プロフィール

	UserBean2(){

	}

	UserBean2(String loginId, String password, String userName, String icon, String profile){
		this.loginId = loginId;
		this.password = password;
		this.userName = userName;
		this.icon = icon;
		this.profile = profile;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProfile() {
		return profile;
	}

}
