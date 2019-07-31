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

//		String username = request.getParameter("userName");
//		SampleDBAccess2 dba = new SampleDBAccess2();
//		boolean result = dba.InsertUserName(username);

		String btn = request.getParameter("btn");
		if(btn.equals(Teisu.OK)) {

			SampleActionForm2 saf = (SampleActionForm2)form;
			String loginId = saf.getLoginId();
			String userName = saf.getUserName();
			String password = saf.getPassword();
			String icon = saf.getIcon();
			String profile = saf.getProfile();

			UserBean2 UB2 = new UserBean2(loginId,password,userName,icon,profile);
			SampleDBAccess2 dba2 = new SampleDBAccess2();
			boolean result = dba2.InsertUser(UB2);

			return (mapping.findForward(Teisu.SUCCESS));

		}else {

			//request.setAttribute("userName", username);
			return (mapping.findForward(Teisu.CANCEL));
		}

	}
}
