/**
 *
 */
package sample;

import java.util.ArrayList;

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
			// 画面よりログインIDとパスワードを取得する
			SampleActionForm sampleForm = (SampleActionForm) form;
			String name = sampleForm.getUserName();

			// 初期値を設定する
			ActionMessages msg = new ActionMessages();

			// DBからユーザを検索する
			SampleDBAccess dba = new SampleDBAccess();
			ArrayList<UserBean> list = dba.SearchUserByName(name);

			// 検索結果がなければ
			if (list.size() == 0) {
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
				request.setAttribute("userlist", list);
			}
		}
		return (mapping.findForward(status));
	}
}
