package com.zy.ssh.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Implementation of <strong>ActionSupport</strong> that contains convenience
 * methods for subclasses. For example, getting the current user and saving
 * messages/errors. This class is intended to be a base class for all Action
 * classes.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class BaseAction extends ActionSupport { 
	private static final long serialVersionUID = 3525445612504421307L;
	public Map<String, Object> resultMap = new HashMap<String, Object> ();

	/**
	 * Constant for cancel result String
	 */
	public static final String CANCEL = "cancel";

	/**
	 * Transient log to prevent session synchronization issues - children can
	 * use instance for logging.
	 */
	protected transient final Log log = LogFactory.getLog(getClass());

	/**
	 * The UserManager
	 * 
	 * /** Indicator if the user clicked cancel
	 */
	protected String cancel;

	/**
	 * Indicator for the page the user came from.
	 */
	protected String from;

	/**
	 * Set to "delete" when a "delete" request parameter is passed in
	 */
	protected String delete;

	/**
	 * Set to "save" when a "save" request parameter is passed in
	 */
	protected String save;

	/**
	 * MailEngine for sending e-mail
	 */

	/**
	 * A message pre-populated with default data
	 */

	/**
	 * Velocity template to use for e-mailing
	 */
	protected String templateName;
	
	/**
	 * Simple method that returns "cancel" result
	 * 
	 * @return "cancel"
	 */
	public String cancel() {
		return CANCEL;
	}

	/**
	 * Save the message in the session, appending if messages already exist
	 * 
	 * @param msg
	 *            the message to put in the session
	 */
	@SuppressWarnings("unchecked")
	protected void saveMessage(String msg) {
		List messages = (List) getRequest().getSession().getAttribute(
				"messages");
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(msg);
		getRequest().getSession().removeAttribute("messages");
		getRequest().getSession().setAttribute("messages", messages);
	}

	/**
	 * Convenience method to get the Configuration HashMap from the servlet
	 * context.
	 * 
	 * @return the user's populated form from the session
	 */

	
	
	public List<Long> getGroups() {
		HttpSession session = getSession();
		List<Long> groups = new ArrayList<Long>();
		if (session.getAttribute("_sso_groups") != null) {
			String sgroups = (String) session.getAttribute("_sso_groups");
			String[] agroups = sgroups.split(",");
			for (String group : agroups) {
				if (group != null && group.length() > 0)
					groups.add(Long.valueOf(group));
			}
		}
		return groups;
	}
	
		HttpSession session = getSession();
		public String getGroupIds() {
		String sgroups="";
		if (session.getAttribute("_sso_groups") != null) {
			sgroups= (String) session.getAttribute("_sso_groups");
		}
		return sgroups;
	}

	
	/**
	 * Convenience method to get the request
	 * 
	 * @return current request
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * Convenience method to get the response
	 * 
	 * @return current response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * Convenience method to get the session. This will create a session if one
	 * doesn't exist.
	 * 
	 * @return the session from the request (request.getSession()).
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * Convenience method to send e-mail to users
	 * 
	 * @param user
	 *            the user to send to
	 * @param msg
	 *            the message to send
	 * @param url
	 *            the URL to the application (or where ever you'd like to send
	 *            them)
	 */


	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * Convenience method for setting a "from" parameter to indicate the
	 * previous page.
	 * 
	 * @param from
	 *            indicator for the originating page
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public void setSave(String save) {
		this.save = save;
	}

	// msg：传入返回对象JSON
	protected void writeResponseForForm(String msg) {
		String responseText = "";
		responseText = "{success: true,data: " + msg + "}";
		this.writeTextResponse(responseText);
	}

	protected void writeResponse(String msg) {
		try {
			if (msg != null) {
				getResponse().getWriter().write(msg);
				getResponse().getWriter().flush();
			}
		} catch (IOException e) {
			log.error(e.getCause());
			e.printStackTrace();
		}
	}

	protected void writeTextResponse(String msg) {
		getResponse().setContentType("text/plain");
		writeResponse(msg);
	}

	protected void writeHtmlResponse(String msg) {
		getResponse().setContentType("text/html");
		writeResponse(msg);
	}

	protected String reParam(HttpServletRequest request, String defaultValue,
			String fieldName) {
		String value = request.getParameter(fieldName) == null ? defaultValue
				: request.getParameter(fieldName);
		if (value != null) {
			return value.trim();
		} else {
			return null;
		}
	}

	/**
	 * 重载ActionSupport的getText方法，解决OMS系统中输出的的消息出现{0}等现象
	 */
	public String getText(String key, String arg1) {
		List args = new ArrayList();
		args.add(arg1);
		return super.getText(key, args);
	}

	/**
	 * 重载ActionSupport的getText方法，解决OMS系统中输出的的消息出现{0}等现象
	 */
	public String getText(String key, String arg1, String arg2) {
		List args = new ArrayList();
		args.add(arg1);
		args.add(arg2);
		return super.getText(key, args);
	}

	/**
	 * 重载ActionSupport的getText方法，解决OMS系统中输出的的消息出现{0}等现象
	 */
	public String getText(String key, String arg1, String arg2, String arg3) {
		List args = new ArrayList();
		args.add(arg1);
		args.add(arg2);
		args.add(arg3);
		return super.getText(key, args);
	}

	/**
	 * 重载ActionSupport的getText方法，解决OMS系统中输出的的消息出现{0}等现象
	 */
	public String getText(String key, String arg1, String arg2, String arg3,
			String arg4) {
		List args = new ArrayList();
		args.add(arg1);
		args.add(arg2);
		args.add(arg3);
		args.add(arg4);
		return super.getText(key, args);
	}

	/**
	 * 重载ActionSupport的getText方法，解决OMS系统中输出的的消息出现{0}等现象
	 */
	public String getText(String key, String arg1, String arg2, String arg3,
			String arg4, String arg5) {
		List args = new ArrayList();
		args.add(arg1);
		args.add(arg2);
		args.add(arg3);
		args.add(arg4);
		args.add(arg5);
		return super.getText(key, args);
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	
	
	/**
     * 将一个字符串数组转换为一个字符串
     * getRangeStr  
     * @param idList
     * @param str1
     * @param str2
     * @return    
     * String   
     * @exception    
     * @since  1.0.0
     */
    public static String getRangeStr(String[] arr,String str1,String str2) {
		return Arrays.toString(arr)
		  		     .replaceAll("\\[", getDefault(str1,""))
		  			 .replaceAll("\\]", getDefault(str2,""))
		  			 .replaceAll("\\s", "");
	}
    
    /**
     * 安全方法,如果对象为空或空字符串，将其转化为指定的值
     * @param str：要转换的对象
     * @param value：转换的值
     * @return String
     */
    public static String getDefault(String str,String value)
    {
    	return str == null ? value : str;
    }
	
}
