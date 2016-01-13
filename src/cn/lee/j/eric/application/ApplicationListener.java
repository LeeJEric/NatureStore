package cn.lee.j.eric.application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tools.utils.PropertyUtils;

/**
 * 程序启动监听
 * @author Lee.J.Eric
 * @time 2014年3月24日上午11:54:00
 */
public class ApplicationListener implements ServletContextListener{
	private static Logger log = LoggerFactory.getLogger(ApplicationListener.class);
	
	//private static ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		try {
			log.info("start to loading application...");
			// 加载配置信息
			String confile = sce.getServletContext().getRealPath("") + "/WEB-INF/classes/application.properties";
			PropertyUtils.loadFile(confile);
			log.info("...application loading is finished");
			/*--------------------------清理缓存文件-----------------------------------*/
			/*String tempPath = System.getProperty("catalina.home")+"\\temp";
			File file = new File(tempPath);
			if(file.isDirectory()){
				for (File f : file.listFiles()) {
					if (f.isDirectory()) {
						FileUtil fileUtil = new FileUtil();
						fileUtil.delete(f.getAbsolutePath());
					} else {
						f.delete();
					}
				}
			}*/
			/*--------------------------清理缓存文件-----------------------------------*/
			/*WebApplicationContext ctx = SpringUtils.getCtx(sce.getServletContext());
			TaskService task = (TaskServiceImpl)ctx.getBean("taskServiceImpl");
			//需要加载bean入口
			exec.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);//执行频率10秒*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
