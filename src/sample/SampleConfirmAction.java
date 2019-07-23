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

		// 画面より名前を取得する
		SampleActionForm sampleForm = (SampleActionForm) form;
		String name = sampleForm.getUserName();

		// 初期値を設定する
		String status = null;
		ActionMessages msg = new ActionMessages();

		//ユーザ情報を登録する
		SampleDBAccess dba = new SampleDBAccess();

		//登録に失敗したら
		if (!dba.InsertUser(name)) {

			//エラーメッセージを登録
			msg.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("errors.register"));
		}

		//登録に成功したら
		if (msg.isEmpty()) {
			status = "success";

			//メッセージを登録、登録完了のメッセージを表示する
			msg.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage("success.register"));
			saveErrors(request, msg);

			// 登録に失敗した場合、登録画面にエラーメッセージを表示する
		} else {
			status = "error";
			saveErrors(request, msg);
		}

		return (mapping.findForward(status));
	}
}
