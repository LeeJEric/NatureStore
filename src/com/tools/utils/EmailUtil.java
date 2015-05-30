package com.tools.utils;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

public class EmailUtil {
	private static Logger log = Logger.getLogger(EmailUtil.class);
	
	public void sendEmail(List<EmailEntity> emails){
		for (EmailEntity email : emails) {
			sendEmail(email);
		}
	}
	
	public void sendEmail(EmailEntity[] emails){
		for (EmailEntity email : emails) {
			sendEmail(email);
		}
	}
	/**
	 * 发送邮件
	 * @param email
	 * @throws InterruptedException 
	 */
	public void sendEmail(final EmailEntity email){
		try {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					send(email);
				}
			}).start();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error("sendEmail-InterruptedException-"+e);
		}
	}
	
	private void send(EmailEntity mail){
		HtmlEmail email = new HtmlEmail();
		email.setTLS(mail.getTLS());
		email.setHostName(mail.getHostName());//发送账户(我方)smtp.qq.com
		email.setAuthentication(mail.getAccount(), mail.getPassword());// 邮箱账号和密码
		try {
			for (int i =0;i<mail.getReceivers().size();i++) {
				email.addTo(mail.getReceivers().get(i));
			}
			email.setFrom(mail.getAccount(),mail.getFromName()); //发送方账户   我方
			email.setSubject(mail.getTitle()); // 标题
			email.setCharset(mail.getCharset()); // 设置Charset
			email.setHtmlMsg(mail.getContent()); // 内容
			if(mail.getAttachments()!=null){
				for (EmailAttachment attachment : mail.getAttachments()) {
					email.attach(attachment);
				}
			}
			email.setSentDate(new Date());
			email.send();
			log.info("邮件发送成功: from "+ mail.getAccount());
			System.out.println("邮件发送成功: from "+ mail.getAccount());
		} catch (EmailException e) {
			e.printStackTrace();
			log.error("邮件发送失败: from "+ mail.getAccount());
			System.out.println("邮件发送失败: from "+ mail.getAccount());
		}
	}
	
	/*public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException{
		EmailEntity email = new EmailEntity();
		EmailAttachment attachment = new EmailAttachment();
		List<EmailAttachment> attachments = new ArrayList<EmailAttachment>();
		
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("附件说明");
		attachment.setName(new String("新建 Microsoft Office Excel 工作表.xlsx".getBytes("gbk"),"iso-8859-1"));
		attachment.setPath("C:/Users/LeeJEric/Desktop/新建 Microsoft Office Excel 工作表.xlsx");
		attachments.add(attachment);
		StringBuffer sb = new StringBuffer();
		sb.append("test:<br>测试");
		email.setAccount("ljl434841@163.com");
		email.setPassword("Berrita538172002");
		email.setCharset("utf8");
		email.setContent(sb.toString());
		email.setHostName("smtp.163.com");
		email.setTitle("just for you!");
		email.setTLS(true);
		email.setFromName("Lee.J.Eric");
		
		List<String> receivers = new ArrayList<String>();
		receivers.add("1906439128@qq.com");
		//receivers.add("253282087@qq.com");
		List<String> names = new ArrayList<String>();
		names.add("n1");
		//names.add("n2");
		email.setReceivers(receivers);
		email.setToNames(names);
		
		//email.setAttachments(attachments);
		EmailUtil emailUtil = new EmailUtil();
		emailUtil.sendEmail(email);
	}*/
}
