/*
 * $Id: SimpleActionForm.java 471754 2006-11-06 14:55:09Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package sample;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * A simple ActionForm
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
public class SampleActionForm extends ValidatorForm {

	// ------------------------------------------------------ Instance Variables

	/** Name */
	private String userName = null;

	// ------------------------------------------------------------ Constructors

	/**
	 * Constructor for MultiboxActionForm.
	 */
	public SampleActionForm() {
		super();
	}

	// ---------------------------------------------------------- Public Methods

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.userName = null;

		//文字化け対策
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * Validate the properties that have been set from this HTTP request,
	 * and return an <code>ActionMessages</code> object that encapsulates any
	 * validation errors that have been found.  If no errors are found, return
	 * <code>null</code> or an <code>ActionMessages</code> object with no
	 * recorded error messages.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 *
	 * @return ActionMessages if any validation errors occurred
	 */
	/*public ActionErrors validate(
			ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		// Name must be entered
		if ((userName == null) || (userName.length() < 1)) {
			errors.add("name", new ActionMessage("errors.name.required"));
		}

		return (errors);

	}*/

	// -------------------------------------------------------------- Properties

	/**
	 * Returns the hidden.
	 * @return String
	 */

	/**
	 * Returns the name.
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the hidden.
	 * @param hidden The hidden to set
	 */

	/**
	 * Sets the name.
	 * @param name The name to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
