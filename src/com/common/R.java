package com.common;

/**
 * 静态常量
 * @author Lee.J.Eric
 * 2013-12-31 下午5:53:56
 *
 */
public class R {
	
	/**
	 * 公共常量
	 * @author Lee.J.Eric
	 *
	 */
	public static class Common {
		/**
		 * 邮箱帐号
		 */
		public static String EMAIL_ACCOUNT = "yigather_support@163.com";
		/**
		 * 邮箱密码
		 */
		public static String EMAIL_PASSWORD = "yiqijuhuiadmin";
		/**
		 * 邮箱服务器
		 */
		public static String EMAIL_SMTP = "smtp.163.com";
		/**
		 * 公网访问地址
		 */

		public static String BASEPATH = "http://112.74.112.241:8084/";

		public static String IMG_DOWNLOAD =	BASEPATH + "download/img?type=0&p=";

		/**
		 * 图片目录
		 */
		public static String[] IMG_TMP = {"a","b","c"};
		
		/**
		 * 图片目录基址
		 */
		public static String IMG_DIR = "/home/www/pa/img/";
//		public static String IMG_DIR = "D:/www/pa/img/";
		public static String IMG_DEALT_DIR = "/home/www/pa/img/z/";

	}

	/**
	 * 云之讯
	 */
	public static class UCPAAS{
		public static String ACCOUNT_SID="8f25201ffc00066171afb3d187f578d6";
		public static String TOKEN="1aba45bbc6d57ca9f70f442b9e4e97ac";
		public static String APP_ID="5ba19ffc8b044e9885f9242dea3503cc";
		public static String TEMPLATE_ID="6380";
	}

	/**
	 * 保单
	 */
	public static class Policy{

		public static Float discountRate = 0.05f;//基准折现率
	}

}
