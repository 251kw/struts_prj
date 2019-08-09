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
		String userName = saf.getUserName();
		String icon = saf.getIcon();
		String profile = saf.getProfile();
		SampleDBAccess2 dba = new SampleDBAccess2();

		//like検索の結果を受け取る
		ArrayList<UserBean2> Suserlist = dba.getSUser(loginId,userName,icon,profile);
		request.setAttribute("Suser", Suserlist);

		String btn = request.getParameter("btn");
		if(btn.equals(Teisu.CANCEL)) {
			return (mapping.findForward(Teisu.CANCEL));
		}else {
			return (mapping.findForward(Teisu.SUCCESS));
		}
		//return (mapping.findForward(Teisu.SUCCESS));
	}
}
