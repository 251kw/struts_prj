/**
 *
 */
package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class SampleSearchAction extends Action {

	/* (非 Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String status = null;

		// キャンセルボタン押下時の処理
		if (this.isCancelled(request)) {
			status = "cancel";
		}

		// 検索の処理
		else {

			// 画面より検索条件を取得してmapに入れる
			HashMap<String, String> items = new HashMap<>();
			SampleSearchActionForm searchForm = (SampleSearchActionForm) form;
			String name = searchForm.getUserName();
			if (!"".equals(name)) {
				items.put("userName", name);
			}
			String loginId = searchForm.getLoginId();
			if (!"".equals(loginId)) {
				items.put("loginId", loginId);
			}
			String icon = searchForm.getIcon();
			if (!"".equals(icon)) {
				items.put("icon", icon);
			}
			String profile = searchForm.getProfile();
			if (!"".equals(profile)) {
				items.put("profile", profile);
			}

			// 初期値を設定する
			ActionMessages msg = new ActionMessages();
			SampleDBAccess dba = new SampleDBAccess();

			//何も入力されていないとき
			if (items.size() == 0) {

				// 全ユーザ検索
				List<UserBean> userList = dba.SearchAllUser();

				// 検索結果がなければ
				if (userList.size() == 0) {

					status = "null";

					// メッセージを登録
					msg.add(ActionMessages.GLOBAL_MESSAGE,
							new ActionMessage("null.search"));
					saveMessages(request, msg);
				}

				// 検索結果があれば
				else {

					status = "success";

					// 検索結果をリクエストに保存
					request.setAttribute("userlist", userList);
				}
			}

			//条件が入力されているとき
			else {

				// 検索結果を入れるリストを用意
				List<UserBean> userList = new ArrayList<>();

				// DBからユーザを検索する
				userList = dba.SearchUsers(items);

				// 検索結果がなければ
				if (userList.size() == 0) {

					status = "null";

					// メッセージを登録
					msg.add(ActionMessages.GLOBAL_MESSAGE,
							new ActionMessage("null.search"));
					saveMessages(request, msg);
				}

				// 検索結果があれば
				else {

					status = "success";

					// 検索結果をリクエストに保存
					request.setAttribute("userlist", userList);
				}
			}
		}
		return (mapping.findForward(status));
	}
}
