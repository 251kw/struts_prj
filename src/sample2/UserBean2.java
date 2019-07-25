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


}
