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


}
