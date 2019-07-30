package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import infr.DBAccess;

public class SampleDBAccess extends DBAccess {

	// 初期値を設定する
	PreparedStatement ps = null;
	Connection con = null;

	// DBにユーザ情報を登録する
	public boolean InsertUser(String loginId, String password, String userName, String icon, String profile) {

		boolean result = false;

		try {

			// データベース接続情報
			con = getConnection();

			// SQL用意
			ps = con.prepareStatement("Insert into users(loginId,password,userName,icon,profile) values(?,?,?,?,?)");
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, userName);
			ps.setString(4, icon);
			ps.setString(5, profile);

			//SQLの実行
			int cnt = ps.executeUpdate();

			// 実行出来たら登録成功
			if (cnt == 1) {
				result = true;
			}

			// 実行できなければ登録失敗
			else {
				result = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// データベース切断処理
			close(ps);
			close(con);
		}
		return result;
	}

	// DBからユーザを検索する
	public ArrayList<UserBean> SearchUsers(HashMap<String, String> items) {

		// 検索結果を入れるリスト
		ArrayList<UserBean> userlist = new ArrayList<>();

		String sql = "select * from users where ";

		// SQL文にキーを設定する
		boolean second = false;
		for (String key : items.keySet()) {

			// 二週目ならばandをつける
			if (second) {
				sql = sql + " and ";
			}
			if ("icon".equals(key)) {
				key = key + "=?";
			} else {
				key = key + " like ?";
			}
			sql = sql + key;

			second = true;
		}

		try {

			// データベース接続情報
			con = getConnection();

			// SQL用意
			ps = con.prepareStatement(sql);

			// SQL文に値を設定する
			int i = 0;
			for (Map.Entry<String, String> entry : items.entrySet()) {
				i++;
				if ("icon".equals(entry.getKey())) {
					ps.setString(i, entry.getValue());
				} else {
					ps.setString(i, "%" + entry.getValue() + "%");
				}
			}

			//SQLの実行
			ResultSet rst = ps.executeQuery();

			// データがとれたらBeanにセットしリストに追加する
			while (rst.next()) {
				UserBean user = new UserBean();
				user.setUserId(rst.getInt(1));
				user.setLoginId(rst.getString(2));
				user.setPassword(rst.getString(3));
				user.setUserName(rst.getString(4));
				user.setIcon(rst.getString(5));
				user.setProfile(rst.getString(6));
				userlist.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// データベース切断処理
			close(ps);
			close(con);
		}
		return userlist;
	}

	// 重複IDをチェック
	public boolean CheckId(String loginId) {
		boolean exist = false;

		try {
			con = getConnection();
			ps = con.prepareStatement("select * from users where loginId=?");
			ps.setString(1, loginId);

			//SQLの実行
			ResultSet rst = ps.executeQuery();

			// 検索結果があれば重複あり
			if (rst.next()) {
				exist = true;
			}

			// 検索結果がなければ重複無し
			else {
				exist = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// データベース切断処理
			close(ps);
			close(con);
		}
		return exist;
	}
}
