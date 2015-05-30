package cn.lee.j.eric.application;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Job{
	private static Logger log = Logger.getLogger(Job.class);
	
//	@Scheduled(cron = "0 0/1 * * * ?")
//	public void test() {
//		log.info("test---begin");
//		String str = "abc";
//		try {
//			info.info("test---info");
//			warn.warn("test---warn");
//			Integer i = Integer.valueOf(str);
//			System.out.println(i);
//		} catch (Exception e) {
//			// TODO: handle exception
////			e.printStackTrace();
//			error.error(e);
//		}
//		log.info("test---end");
//	}
}