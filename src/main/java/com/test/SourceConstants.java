package com.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;

public class SourceConstants {
	public static ApplicationContext ctx = null;
	public static ResourceBundle errorCodeResourceBundle = null;
	public static String DEPOSITORY_PATH = "";
	public static String ADMIN_GROUDP_ID = "";
	public static String CAS_USER_INFO = "";
	public static boolean USE_SSO = true;
	public static String DEFINE_BC_IDS = "";
	public static String SYSTEM_NODES = "";
	public static String SYSTEM_PATHS = "";
	public static final int QUERY_PAGE_MAX_SIZE = 10000000;
	public static final int NODE_TREE_PAGE_SIZE = 1500;
	public static final Long ADMINISTRATOR_ID = 0L;
	public static String V_DEST_PATHS = "";// sysID1:path11,path12;sysID2:path21
	public static Map<String, String> SYSTEMPath = new HashMap<String, String>();
	public static Map<String, String> SYSTEMCONFIG = new HashMap<String, String>();
	public static Map<Long, String> ALL_USER = new HashMap<Long, String>();
	public static Map<String, Long> ALL_USER_NAMT_TO_ID = new HashMap<String, Long>();
	public static Map<Long, String> ALL_GROUP = new HashMap<Long, String>();
	public static Map<String, String> AREA_ID_MAP = new HashMap<String, String>();
	public static Map<Long, Map<Long, String>> MEDIA_HW_USAGE_CODE_MAP = new HashMap<Long, Map<Long, String>>();
	public static Map<Long, Map<Long, String>> MEDIA_RC_USAGE_CODE_MAP = new HashMap<Long, Map<Long, String>>();
	public static Map<Long, Double> PRDINFO_BATCH_CONTENT_MAP = new HashMap<Long, Double>();

	// 缓存产品包
	public static Date cacheTime = new Date();

	public static final int PUB_DIRNUM_MAX = 1000; // 发布文件夹数量最大值
	public static final String PATH_SEPARATOR = "/";
	public static final String HTTP_NOTIFYNUM = "notifynum";
	public static final String HTTP_NOTIFYTYPE = "notifytype";
	public static final String HTTP_FILENAME = "filename";
	public static final String STATISTICS_CONTEXT = "/statistics/";
	public static final String STATISTICS_CONTENT_FILENAME = "_exported.xls";
	public static final String USER_SSO = "true";

	// 发布内容存放路径定义
	public final static String DEPOSITORY = "depository";
	public final static String PUB_DIR_CONT = "cont";// 内容目录
	public final static String PUB_DIR_IMAGE = "image";// 图片目录
	public final static String PUB_DIR_AUDIO = "audio";// 音频目录
	public final static String PUB_DIR_VIDEO = "video";// 视频目录
	public final static String PUB_DIR_BFILE = "bfile";// 文件目录
	public final static String PUB_SOFTWARE = "software";// 客户端版本目录
	public final static String PUB_DEFAULT_PAGE = "index";// 主页文件名
	public final static String PUB_DIR_TEMP = "temp";// 文件目录
	public final static String PUB_DIR_EXPORT = "export"; // 文件导入目录

	public final static String DEST_SYSTEMS = "allDestSystems";
	public final static String ALL_CPS = "allCps";
	public final static String ALL_USERINFOS = "allUserInfos";
	public final static String ALL_GROUPINFOS = "allGroupInfos";
	public final static String IMAGE_SYSTEM = "imageSystem";

	public final static String TEMPLATE_ENCODE = "UTF-8";
	public final static String MULTI_SCREEN_SIGN = "支持多屏续播";

	/**
	 * 编码格式
	 */
	public static final class CHARACTER {
		public final static String CHARACTER_UTF8 = "UTF-8";// Utf-8编码格式
		public final static String CHARACTER_GBK = "GBK";// GBK编码格式
	}

	/**
	 * 加密官钥
	 */
	public static final class KEY {
		public final static String UPDATEMEDIAKEY = "test";// 未来电视加密密钥
	}

	public final static String imageLock = "";
	public static volatile int imageFlag = 0;

	public final static String kafka_topic = "test";
	public final static String kafka_ip = "127.0.0.1:9092";

}
