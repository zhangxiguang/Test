package RememberTalkAboutDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RememberTalkAboutDemo {
	public static void main(String[] args) throws IOException {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String info;
		new Date().getTime();
		while((info=df.format(new Date())+": "+br.readLine()+"\r\n")!=null) {
			FileOutputStream out=new FileOutputStream("F:\\test\\Rember.txt",true);
			out.write(info.getBytes());
		}
	}
}
