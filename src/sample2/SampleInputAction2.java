/**
 *
 */
package sample2;

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
public class SampleInputAction2 extends Action {

	/* (非 Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		SampleActionForm2 saf = (SampleActionForm2) form;
		String loginId = saf.getLoginId();

		boolean STATE = true;
		String btn = request.getParameter("btn");

		//submitボタンが押されたら
		if (Teisu.SUBMIT.equals(btn)) {

			SampleDBAccess2 dba = new SampleDBAccess2();
			boolean result = dba.CheckUserId(loginId);
			if (result == false) {
				ActionMessages errors = new ActionMessages();
				errors.add("loginId", new ActionMessage("errors.loginId"));
				saveErrors(request, errors);

				STATE = false;
			}

			if (STATE == false) {
				return (mapping.findForward(Teisu.ERROR));
			} else {
				return (mapping.findForward(Teisu.SUCCESS));
			}

		} else {

			return (mapping.findForward(Teisu.CANCEL));
		}

	}
}
