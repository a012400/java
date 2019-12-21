package p133.app;

import p133.base.User;
import p133.intfc.UserDao;

import java.util.Scanner;

public class Application {
	private UserDao userDao;

	public Application(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		
	}

	public void registe() {
		Scanner scn = new Scanner(System.in);
		User user = new User();
		System.out.println("******ע���û�******");
		System.out.print("�������û���: ");
		String userName = scn.next();
		System.out.print("����������: ");
		String password = scn.next();
		System.out.print("��������������: ");
		if (password.equals(scn.next()) == false) {
			System.out.println("������������벻���, ����������!");
			this.registe();
		} else {
			user.setUserName(userName);
			user.setPassword(password);
			userDao.addUser(user);
		}
	}
	
	public void login() {
		Scanner scn = new Scanner(System.in);
		System.out.println("******��¼******");
		System.out.print("�������û���: ");
		String userName = scn.next();
		System.out.print("����������: ");
		String password = scn.next();
		User user = userDao.getUser(userName, password);
		if (user != null) {
			System.out.println(user.getUserName() + " �ѵ�¼");
		} else {
			System.out.println("��½ʧ��");
		}
		
		
	}
	
	

}
