/**
 *
 */
package sample;

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
public class SampleConfirmAction extends Action {

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

		// 登録処理
		else {

			// 画面より名前を取得する
			SampleActionForm sampleForm = (SampleActionForm) form;
			String loginId = sampleForm.getLoginId();
			String password = sampleForm.getPassword();
			String name = sampleForm.getUserName();
			String icon = sampleForm.getIcon();
			String profile = sampleForm.getProfile();

			// 初期値を設定する
			ActionMessages msg = new ActionMessages();
			SampleDBAccess dba = new SampleDBAccess();

			// ユーザ登録に失敗したら
			if (!dba.InsertUser(loginId,password,name,icon,profile)) {
				status = "error";

				// エラーメッセージを登録
				msg.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("errors.register"));
				saveErrors(request, msg);
			}

			// 登録に成功したら
			else {
				status = "success";

				// 登録完了のメッセージを表示する
				msg.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("complete.register"));
				saveMessages(request, msg);
			}
		}
		return (mapping.findForward(status));
	}
}
