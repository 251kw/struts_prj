/**
 *
 */
package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * @author r.kawahara
 *
 */
public class SampleAction extends Action {

	/* (非 Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 画面よりログインIDとパスワードを取得する
		SampleActionForm sampleForm = (SampleActionForm) form;
		String name = sampleForm.getName();

		// 初期値を設定する
		Connection con = null;
		String status  = null;
		ActionMessages errors = new ActionMessages();

		try {
			// DBより登録者の情報を取得する
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users");

			ResultSet rs = ps.executeQuery();

			/***********************
			 ***  ここから先は適当です  ***
			 ***********************/

			// 認証を行う
			int count = 0;
			while (rs.next()) {
				count++;
				if (count == 1) {

					// ログインIDとパスワードが登録者の情報と
					// 一致しなければ認証失敗
					if (!name.equals(rs.getString("userName"))) {
						errors.add(ActionMessages.GLOBAL_MESSAGE,
								new ActionMessage("errors.login"));
					}

					// ログインIDが2件以上存在したら認証失敗
				} else {
					errors.add(
							ActionMessages.GLOBAL_MESSAGE,
							new ActionMessage("errors.login"));
				}
			}

			// ログインIDが0件なら認証失敗
			if (count == 0) {
				errors.add(
						ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("errors.login"));
			}

			// 認証に成功した場合、トップ画面に
			// 登録者の一覧を表示する
			List<UserBean> usersList = null;
			if (errors.isEmpty()) {
				status = "success";
				usersList = new ArrayList<UserBean>();
				ps = con.prepareStatement(
						"select id, name from users order by id");
				rs = ps.executeQuery();
				while (rs.next()) {
					UserBean sampleUser = new UserBean();
					sampleUser.setLoginId(rs.getString("loginId"));
					sampleUser.setPassword(rs.getString("password"));
					sampleUser.setUserName(rs.getString("userName"));
					usersList.add(sampleUser);
				}
				request.setAttribute("userslist", usersList);

				// 認証に失敗した場合、ログイン画面に
				// エラーメッセージを表示する
			} else {
				status = "error";
				saveErrors(request, errors);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con!=null) {
				con.close();
			}
		}

		return (mapping.findForward(status));
	}
}
