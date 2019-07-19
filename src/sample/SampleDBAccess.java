package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;

import infr.DBAccess;

public class SampleDBAccess extends DBAccess {

	// 初期値を設定する
	PreparedStatement ps = null;
	Connection con = null;

	// DBに新卒者の情報を登録する
	public boolean InsertUser(String userName) {
		boolean result = false;
	try{
		con = getConnection(); // データベース接続情報
		ps = con.prepareStatement("Insert into users(userName) values(?)"); // SQL用意
		ps.setString(1, userName);

		int cnt = ps.executeUpdate();  //SQLの実行

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
}
