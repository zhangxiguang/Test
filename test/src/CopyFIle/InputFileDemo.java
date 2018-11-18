package CopyFIle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InputFileDemo extends Thread {
	static CopyFileDemo c;
//	static String path = "F:\\QQGame"; // 目标文件地址
//	static String copypath = "F:\\test"; // 复制文件地址
	static Lock lock = new ReentrantLock();
	static int number = 0;
	static boolean flag = false;

	public InputFileDemo() {
		super();
	}

//	public static void main(String[] args) {
//		Search(path, copypath);
//	}

	public static void Search(String path, String copypath) {
		try {
			final File f = new File(path); // 源文件
			final File copyf = new File(copypath, f.getName()); // 目标文件
			copyf.mkdir();
			final String[] dir = f.list();
			for (int i = 0; i < dir.length; i++) {
				final File f2 = new File(f, dir[i]);
				if (f2.isDirectory()) {
					new Thread() {
						@Override
						public void run() {
							try {
								File copyf2 = new File(copyf.getAbsolutePath(), f2.getName());
								copyf2.mkdir();
								Search(f2.getAbsolutePath(), copyf2.getAbsolutePath());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}.start();
				} else {
					new Thread() {
						@Override
						public void run() {
							try {
								File copyf2 = new File(copyf.getAbsolutePath(), f2.getName());
								BufferedReader in = new BufferedReader(new FileReader(f2));
								BufferedWriter out = new BufferedWriter(new FileWriter(copyf2.getAbsolutePath()));
								String length;
								while ((length = in.readLine()) != null) {
									out.write(length);
								}
								in.close();
								out.flush();
								out.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}.start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void Search(String path, String copypath) {
//		lock.lock();
//		try {
//			File f = new File(path); // 源文件
//			File copyf = new File(copypath, f.getName()); // 目标文件
//			copyf.mkdir();
//			String[] dir = f.list();
//			for (int i = 0; i < dir.length; i++) {
////				lock.lock();
//				File f2 = new File(f, dir[i]);
//				if (f2.isDirectory()) {
//					File copyf2 = new File(copyf.getAbsolutePath(), f2.getName());
//					copyf2.mkdir();
//					Search(f2.getAbsolutePath(), copyf2.getAbsolutePath());
//				} else {
//					File copyf2 = new File(copyf.getAbsolutePath(), f2.getName());
//					BufferedReader in = new BufferedReader(new FileReader(f2));
//					BufferedWriter out = new BufferedWriter(new FileWriter(copyf2.getAbsolutePath()));
//					String length;
//					while ((length = in.readLine()) != null) {
//						out.write(length);
//					}
//					in.close();
//					out.flush();
//					out.close();
//				}
//			} 
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			lock.unlock();
//			System.out.println("释放了锁" + number);
//			number++;
//		}
//
//	}

//	public void run() {
//		Search(path, copypath);
//	}
}
