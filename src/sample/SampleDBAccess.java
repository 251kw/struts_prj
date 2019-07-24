package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	// DBにユーザ情報を登録する
	public ArrayList<UserBean> SearchUserByName(String userName) {

		ArrayList<UserBean> list = new ArrayList<>();

		try {

			con = getConnection(); // データベース接続情報
			ps = con.prepareStatement("select * from users where userName=?"); // SQL用意
			ps.setString(1, userName);

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
