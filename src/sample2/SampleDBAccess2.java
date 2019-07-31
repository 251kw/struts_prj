package sample2;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}
