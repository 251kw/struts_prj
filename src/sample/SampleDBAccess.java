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
	public boolean InsertUser(String userName) {

		boolean result = false;

		try {

			con = getConnection(); // データベース接続情報
			ps = con.prepareStatement("Insert into users(userName) values(?)"); // SQL用意
			ps.setString(1, userName);

			int cnt = ps.executeUpdate(); //SQLの実行

			// 実行出来たら登録成功
			if (cnt == 1) {
				result = true;
				// 実行できなければ登録失敗
			} else {
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
		boolean twice = false;
		for (String key : items.keySet()) {
			if (twice) { // 二週目ならばandをつける
				sql = sql + " and ";
			}
			if ("icon".equals(key)) {
				key = key + "=?";
			} else {
				key = key + " like ?";
			}
			sql = sql + key;

			twice = true;
		}

		try {

			con = getConnection(); // データベース接続情報

			ps = con.prepareStatement(sql); // SQL用意

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

			ResultSet rst = ps.executeQuery(); //SQLの実行

			// データがとれたらオブジェクトにセットしリストに追加する
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

	// DBからログインIDでユーザを検索する
	public ArrayList<UserBean> SearchUserByID(String loginId) {

		ArrayList<UserBean> list = new ArrayList<>();

		try {

			con = getConnection(); // データベース接続情報
			ps = con.prepareStatement("select * from users where loginId like ?"); // SQL用意
			ps.setString(1, "%" + loginId + "%");

			ResultSet rst = ps.executeQuery(); //SQLの実行

			// データがとれたらオブジェクトにセットしリストに追加する
			while (rst.next()) {
				UserBean user = new UserBean();
				user.setUserId(rst.getInt(1));
				user.setLoginId(rst.getString(2));
				user.setPassword(rst.getString(3));
				user.setUserName(rst.getString(4));
				user.setIcon(rst.getString(5));
				user.setProfile(rst.getString(6));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// データベース切断処理
			close(ps);
			close(con);
		}
		return list;
	}

	// DBからアイコンでユーザを検索する
	public ArrayList<UserBean> SearchUserByIcon(String icon) {

		ArrayList<UserBean> list = new ArrayList<>();

		try {

			con = getConnection(); // データベース接続情報
			ps = con.prepareStatement("select * from users where icon=?"); // SQL用意
			ps.setString(1, icon);

			ResultSet rst = ps.executeQuery(); //SQLの実行

			// データがとれたらオブジェクトにセットしリストに追加する
			while (rst.next()) {
				UserBean user = new UserBean();
				user.setUserId(rst.getInt(1));
				user.setLoginId(rst.getString(2));
				user.setPassword(rst.getString(3));
				user.setUserName(rst.getString(4));
				user.setIcon(rst.getString(5));
				user.setProfile(rst.getString(6));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// データベース切断処理
			close(ps);
			close(con);
		}
		return list;
	}

	// DBからプロフィールでユーザを検索する
	public ArrayList<UserBean> SearchUserByProfile(String profile) {

		ArrayList<UserBean> list = new ArrayList<>();

		try {

			con = getConnection(); // データベース接続情報
			ps = con.prepareStatement("select * from users where profile like ?"); // SQL用意
			ps.setString(1, "%" + profile + "%");

			ResultSet rst = ps.executeQuery(); //SQLの実行

			// データがとれたらオブジェクトにセットしリストに追加する
			while (rst.next()) {
				UserBean user = new UserBean();
				user.setUserId(rst.getInt(1));
				user.setLoginId(rst.getString(2));
				user.setPassword(rst.getString(3));
				user.setUserName(rst.getString(4));
				user.setIcon(rst.getString(5));
				user.setProfile(rst.getString(6));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// データベース切断処理
			close(ps);
			close(con);
		}
		return list;
	}
}
