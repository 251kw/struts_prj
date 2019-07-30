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
public class SampleInputAction extends Action {

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

		// submitボタン押下時の処理
		else {

			// 初期値を設定する
			SampleActionForm sampleForm = (SampleActionForm) form;
			SampleDBAccess dba = new SampleDBAccess();
			ActionMessages msg = new ActionMessages();

			// iconの値を保持
			String icon = sampleForm.getIcon();
			if("icon-user".equals(icon)) {
				msg.add("", new ActionMessage("selected"));
			}

			// 画面よりログインIDを取得する
			String loginId = sampleForm.getLoginId();

			// ログインIDが重複してたら
			if (dba.CheckId(loginId)) {
				status = "error";

				// エラーメッセージの登録
			    msg.add("loginId", new ActionMessage("errors.loginId"));
			    saveErrors(request, msg);
			}

			// 重複していなければ
			else {
				status = "success";
			}
		}
		return (mapping.findForward(status));
	}
}
