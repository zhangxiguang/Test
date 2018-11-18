package CopyFIle;

import java.util.Date;

public class CopyFileDemo {
	public static void main(String[] args) {
//		long startTime = new Date().getTime();
		
		String path = "F:\\QQGame"; // 目标文件地址
		String copypath = "F:\\test"; // 复制文件地址
		
		InputFileDemo in1 = new InputFileDemo();
//		InputFileDemo in2 = new InputFileDemo();
//		InputFileDemo in3 = new InputFileDemo();
//		InputFileDemo in4 = new InputFileDemo();
		in1.Search(path, copypath);
//		in1.start();
//		in2.start();
//		in3.start();
//		in4.start();

		try {
//			in1.join();
//			in2.join();
//			in3.join();
//			in4.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			in1.stop();
//			in2.stop();
//			in3.stop();
//			in4.stop();
		}
//		long endTime = new Date().getTime();
//		System.out.println("共用时" + (endTime - startTime) / 1000 + "s");
	}
}
