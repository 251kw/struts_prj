package sample2;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import infr.DBAccess;

public class SampleDBAccess2 extends DBAccess {

	public boolean InsertUserName(String userName) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "INSERT INTO users (userName)VALUES(?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);

			int cnt = pstmt.executeUpdate();

			if(cnt == 1) {
				result = true;
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
			close(conn);
		}


		return result;
	}

	public boolean InsertUser(UserBean2 user) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO users (loginId, password, userName, icon, profile)VALUES(?, ?, ?, ?, ?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getLoginId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getIcon());
			pstmt.setString(5, user.getProfile());

			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				// INSERT 文の実行結果が１なら登録成功
				result = true;
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}

	public ArrayList<UserBean2> getSUser(String loginId){
		ArrayList<UserBean2> userlist = new ArrayList<UserBean2>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM users WHERE loginId=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				UserBean2 UB2 = new UserBean2();
				UB2.setLoginId(rset.getString(2));
				UB2.setPassword(rset.getString(3));
				UB2.setUserName(rset.getString(4));
				UB2.setIcon(rset.getString(5));
				UB2.setProfile(rset.getString(6));
				userlist.add(UB2);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
			close(conn);
		}

		return userlist;

	}

}
