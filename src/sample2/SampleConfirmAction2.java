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

/**
 * @author r.kawahara
 *
 */
public class SampleConfirmAction2 extends Action {

//	private final String SUCCESS = "success";
//	private final String CANCEL = "cancel";
//	private final String OK = "OK";
	/* (非 Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String username = request.getParameter("userName");
		SampleDBAccess2 dba = new SampleDBAccess2();
		boolean result = dba.InsertUserName(username);

		String btn = request.getParameter("btn");
		if(btn.equals(Teisu.OK)) {

			return (mapping.findForward(Teisu.SUCCESS));

		}else {

			request.setAttribute("userName", username);
			return (mapping.findForward(Teisu.CANCEL));
		}

	}
}
