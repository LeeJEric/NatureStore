package com.tools.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtil {
	
	/**
	 * 从输出流中复制数据到文件
	 * 
	 * @param stream
	 * @param file
	 */
	public static void copyFile(InputStream stream, File file)throws IOException {
		File parent = file.getParentFile();
		if(!parent.exists())
			parent.mkdirs();
		if(!file.exists())
			file.createNewFile();
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(stream);

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(file));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}
	
	/**
	 * 复制文件
	 * @param channel
	 * @param targetFile
	 * @throws IOException
	 * @author Lee.J.Eric
	 * @time 2015年2月11日 下午5:01:32
	 */
	public static void copyFile(FileChannel channel,File targetFile) throws IOException {
		File parent = targetFile.getParentFile();
		if(!parent.exists())
			parent.mkdirs();
		if(!targetFile.exists())
			targetFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(targetFile);
		FileChannel fcout = fout.getChannel();
		
		 // 创建缓冲区  
        ByteBuffer buffer = ByteBuffer.allocate(1024*5);
        
        while (true) {  
            // clear方法重设缓冲区，使它可以接受读入的数据  
            buffer.clear();  
            // 从输入通道中将数据读到缓冲区  
            int r = channel.read(buffer);  
            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1  
            if (r == -1) {  
                break;  
            }  
            // flip方法让缓冲区可以将新读入的数据写入另一个通道  
            buffer.flip();  
            // 从输出通道中将数据写入缓冲区  
            fcout.write(buffer);  
        }
        fcout.close();
        channel.close();
        fout.close();
		
	}
	
	/**
	 * 复制文件
	 * 
	 * @param sourceFile
	 * @param targetFile
	 * @throws IOException
	 */
	public static void copyFile(File sourceFile, File targetFile) throws IOException {
		FileInputStream fin = new FileInputStream(sourceFile);  
        // 获取输入输出通道  
        FileChannel channel = fin.getChannel();  
        copyFile(channel, targetFile);
	}

	/**
	 * 复制文件夹
	 * 
	 * @param sourceDir
	 * @param targetDir
	 * @throws IOException
	 */
	public static void copyDirectiory(String sourceDir, String targetDir)
			throws IOException {
		// 新建目标目录
		(new File(targetDir)).mkdirs();
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(sourceDir)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 源文件
				File sourceFile = file[i];
				// 目标文件
				File targetFile = new File(
						new File(targetDir).getAbsolutePath() + File.separator
								+ file[i].getName());
				copyFile(sourceFile, targetFile);
			}
			if (file[i].isDirectory()) {
				// 准备复制的源文件夹
				String dir1 = sourceDir + "/" + file[i].getName();
				// 准备复制的目标文件夹
				String dir2 = targetDir + "/" + file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}

	/**
	 * 删除指定路径的文件夹或文件
	 * 
	 * @param filepath
	 * @throws IOException
	 */
	public static void delete(String filepath) throws IOException {
		File f = new File(filepath);// 定义文件路径
		if (f.exists() && f.isDirectory()) {// 判断是文件还是目录
			if (f.listFiles().length == 0) {// 若目录下没有文件则直接删除
				f.delete();
			} else {// 若有则把文件放进数组，并判断是否有下级目录
				File delFile[] = f.listFiles();
				int i = f.listFiles().length;
				for (int j = 0; j < i; j++) {
					if (delFile[j].isDirectory()) {
						delete(delFile[j].getAbsolutePath());// 递归调用del方法并取得子目录路径
					}
					delFile[j].delete();// 删除文件
				}
			}
		}
	}
}
