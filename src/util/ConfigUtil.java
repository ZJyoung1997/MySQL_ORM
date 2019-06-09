package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	
	private Properties pro = null;
	private FileReader fileReader = null;
	
	public ConfigUtil() {
		pro = new Properties();
		try {
			fileReader = new FileReader("pro");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("��ConfigUtil����ȡ�����ļ��쳣");
		}
		
		try {
			pro.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("��ConfigUtil���������쳣");
		}
		
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("��ConfigUtil���ر����쳣");
		}
	}
	
	public String getValue(String key) {
		return pro.getProperty(key);
	}
}
