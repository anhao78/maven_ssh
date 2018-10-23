package com.zy.ssh.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.springframework.context.ApplicationContext;

public class Constants {
	public static final String BUNDLE_KEY = "ApplicationResources";
	public static final String FILE_SEP = System.getProperty("file.separator");

	public static final String USER_HOME = System.getProperty("user.home")
			+ FILE_SEP;
	public static final String CONFIG = "appConfig";
	public static final String CAS_USERINFO = "casUserinfo";
	public static final String CAS_NO_AUTH_REQUEST = "NoAuth";
	public static final String ADMIN_GROUDP_ID = "ADMIN_GROUDP_ID";
	public static final String PREFERRED_LOCALE_KEY = "org.apache.struts2.action.LOCALE";
	public static final String USER_KEY = "userForm";
	public static final String USER_LIST = "userList";
	public static final String REGISTERED = "registered";
	public static final String ADMIN_ROLE = "ROLE_ADMIN";
	public static final String USER_ROLE = "ROLE_USER";
	public static final String CONTENT_ROLE = "ROLE_CONTENT";
	public static final String PUBLISH_ROLE = "ROLE_PUBLISH";
	public static final String TEMPLATE_ROLE = "ROLE_TEMPLATE";
	public static final String APPMAN_ROLE = "ROLE_APPMAN";
	public static final String INTERFACE_ROLE = "ROLE_INTERFACE";
	public static final String USER_ROLES = "userRoles";
	public static final String AVAILABLE_ROLES = "availableRoles";
	public static final String CSS_THEME = "csstheme";
	public static final String CONTEENT_TREE_NODES = "CONTENT_TREE_NODES";
	public static final String USER_NODE_PERMISSION = "USER_NODE_PERMISSION";
	public static final String TEMPLATE_USER_NODE_PERMISSION = "TEMPLATE_USER_NODE_PERMISSION";
	public static final String TEMPLATE_CONTEENT_TREE_NODES = "TEMPLATE_CONTENT_TREE_NODES";
	public static final String SHOWPLACE_TREE_NODES = "SHOWPLACE_TREE_NODES";
	public static final String USER_SHOWPLACE_TREE_PERMISSION = "USER_SHOWPLACE_TREE_PERMISSION";
	public static final String RESOURCE_TREE_NODES = "RESOURCE_TREE_NODES";
	public static final String USER_RESOURCE_PERMISSION = "USER_RESOURCE_PERMISSION";
	public static final String UPLOADGRADE_TREE_NODES = "UPLOADGRADE_TREE_NODES";
	public static final String USER_UPLOADGRADE_PERMISSION = "USER_UPLOADGRADE_PERMISSION";
	public static final String TRUE = "Y";
	public static final String FALSE = "N";
	public static final String ROOT_NODENET_ID = "root";
	public static final String SESSITON_NODE_CONT_ID = "SESSITON_NODE_CONT_ID";
	public static final String SESSITON_CURRENT_USER = "current_user";
	public static final String SESSITON_CURRENT_USER_GROUPS = "current_user_groups";
	public static final String TEMPLATE_TREE_NODES = "TEMPLATE_TREE_NODES";
	public static final String USER_TEMPLATE_PERMISSION = "USER_TEMPLATE_PERMISSIONS";
	public static final String NODE_TEMPLATE_TREE_NODES = "NODE_TEMPLATE_TREE_NODES";
	public static final String NODE_USER_TEMPLATE_PERMISSION = "NODE_USER_TEMPLATE_PERMISSIONS";
	public static ApplicationContext ctx = null;
	public static ResourceBundle errorCodeResourceBundle = null;
	public static String WEB_SERVER_IP_ADDRESS = null;

	public static String SSO_USER_ID_KEY = "SSO_USER_ID_KEY";
	public static String SSO_USER_ID_VALUE = null;
	public static final String ADMINISTRATOR_NAME = "administrator";
	public static final String EVERYONE_NAME = "everyone";
	public static final Long ADMINISTRATOR_ID = new Long(0L);
	public static final Long EVERYONE_ID = new Long(1L);
	public static final int QUERY_PAGE_MAX_SIZE = 2000;
	public static final int NODE_TREE_PAGE_SIZE = 2000;
	public static final int DOWN_LOAD_MAX_SIZE = 2000;
	public static final String TEMPLATE_ENCODE = "UTF-8";
	public static final String TEMPLATE_XML_TYPE = ".xml";
	public static final String TEMPLATE_HTML_TYPE = ".html";
	public static final String SEACHE_OMS = "03";
	public static final String SEACHE_OMS_JSON = "json";
	public static String DEPOSITORY_PATH = "";
	public static final String DEPOSITORY = "depository";
	public static String CDN_VISIT_PASSWD = "";
	public static String CDN_VISIT_HTTP_URL = "";

	public static Long CLIENT_WAP_TYPE = Long.valueOf(1L);
	public static Long CLIENT_CLT_TYPE = Long.valueOf(2L);
	public static Long CLIENT_RMS_TYPE = Long.valueOf(3L);
	public static Long CLIENT_IPHONE_TYPE = Long.valueOf(4L);
	public static Long CLIENT_RMS2_TYPE = Long.valueOf(5L);
	public static Long CLIENT_CLT2_TYPE = Long.valueOf(6L);
	public static Long CLIENT_CLT3_TYPE = Long.valueOf(7L);
	public static Long CLIENT_AUDIO_TYPE = Long.valueOf(8L);

	public static String NODE_WORK_TYPE = "work";
	public static String NODE_PUBLISH_TYPE = "publish";

	public static Long DATA_OBJECT_NODE = new Long(0L);
	public static Long DATA_OBJECT_COMMON = new Long(1L);
	public static Long DATA_OBJECT_CONTENT = new Long(2L);
	public static Long DATA_OBJECT_PLAYBILL = new Long(6L);
	public static Long DATA_OBJECT_RECOMMEND = new Long(10L);
	public static Long DATA_OBJECT_WEIBO = new Long(11L);
	public static Long DATA_OBJECT_LINK = new Long(49L);
	public static Long DATA_OBJECT_MAGAZINE = new Long(50L);
	public static Long DATA_OBJECT_BULLETION = new Long(20L);
	public static Long DATA_OBJECT_KEYWORD = new Long(9L);
	public static Long DATA_OBJECT_MAM = new Long(99L);
	public static Long DATA_OBJECT_SCHEDULE = new Long(100L);

	public static String POST_NOTIFY_TYPE = "post";
	public static String PUT_NOTIFY_TYPE = "put";
	public static String DELETE_NOTIFY_TYPE = "delete";
	public static String COLUMEN_NOTIFY_DATA = "column";
	public static String CLMNCHARGE_NOTIFY_DATA = "clmncharge";
	public static String NAVIGATION_NOTIFY_DATA = "navigation";
	public static String CONTENT_NOTIFY_DATA = "content";
	public static String LIVING_NOTIFY_DATA = "living";
	public static String BULLETION_NOTIFY_DATA = "bulletin";
	public static String RECOMMAND_NOTIFY_DATA = "recommend";
	public static String HOTKEYWORD_NOTIFY_DATA = "hotkeyword";
	public static String VOTE_NOTIFY_DATA = "vote";
	public static String PRODUCT_NOTIFY_DATA = "product";
	public static String CHANNEL_NOTIFY_DATA = "channel";
	public static String WELCOME_NOTIFY_DATA = "welcome";
	public static String MAGAZINE_NOTIFY_DATA = "magazine";
	public static String ENFORCE_NOTIFY_DATA = "enforce/column";
	public static String CONTENTSET_NOTIFY_DATA = "contentset";
	public static Map<String, String> SYSTEMCONFIG = new HashMap();

	public static String APP_CHANNEL = "";
	public static final String CLIENT_TYPE_SUP = "sup";
	public static final String CLIENT_TYPE_SUP3 = "sup3";
	public static final String CLIENT_TYPE_WAP = "wap";
	public static final String CLIENT_TYPE_J2ME = "j2me";
	public static final String CLIENT_TYPE_OPHONE = "ophone";
	public static final String CLIENT_TYPE_IPHONE = "iphone";
	public static final String CLIENT_TYPE_FETION = "fetion";
	public static final String CLIENT_TYPE_MM = "mmarket";
	public static final String CLIENT_TYPE_MM_OPHONE = "ophone";
	public static final String CLIENT_TYPE_MM_SYMBIAN = "symbian";
	public static final String CLIENT_TYPE_MM_WM = "wm";
	public static String BC_RECEIVE_THREAD_IP;
	public static int BC_INPUT_RECEIVE_THREAD_PORT;
	public static int BC_UPLOAD_RECEIVE_THREAD_PORT;
	public static String CLIENT_CLT3_SKIN_TYPE;
	public static final String PUB_DIR_CONT = "cont";
	public static final String PUB_DIR_HTML = "html";
	public static final String PUB_DIR_IMAGE = "image";
	public static final String PUB_DIR_AUDIO = "audio";
	public static final String PUB_DIR_VIDEO = "video";
	public static final String PUB_DIR_BFILE = "bfile";
	public static final String PUB_SOFTWARE = "software";
	public static final String PUB_DEFAULT_PAGE = "index";
	public static final String PUB_DIR_TEMP = "temp";
	public static final String PUB_DIR_EXPORT = "export";
	public static final String PUB_DIR_TEMPLATE = "tpl";
	public static final String PUB_DIR_NODE = "node";
	public static final String PUB_DIR_VOTE = "vote";
	public static final String CP_NAMES = "allCpNames";
	public static final Map<String, String> ALL_CP_MAP = new HashMap();
}