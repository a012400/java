package java_collections.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		// ��properties���������
		props.setProperty("username", "yeeku");
		props.setProperty("password", "123456");
		// ��Properties�е�key-value�Ա��浽a.ini�ļ���
		props.store(new FileOutputStream("a.ini"), "comment line");
		// �½�һ��Properties����
		Properties props2 = new Properties();
		// ��Properties���������
		props2.setProperty("gender", "male");
		// ��a.ini�ļ��е�key-value��׷�ӵ�props2��
		props2.load(new FileInputStream("a.ini"));
		System.out.println(props2);
	}

}
