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
		if ( this.isCancelled(request) ) {
			status = "cancel";
	    }
		// submitボタン押下時の処理
		else {
	    	status = "success";
	    }
		return (mapping.findForward(status));
	}
}
