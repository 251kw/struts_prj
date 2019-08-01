/**
 *
 */
package sample2;

import java.util.ArrayList;

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
public class SampleSearchAction2 extends Action {

	/* (非 Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		SampleActionForm2 saf = (SampleActionForm2)form;
		String loginId = saf.getLoginId();
		SampleDBAccess2 dba = new SampleDBAccess2();

		ArrayList<UserBean2> Suserlist = dba.getSUser(loginId);
		request.setAttribute("Suser", Suserlist);


		return (mapping.findForward(Teisu.SUCCESS));
	}
}
