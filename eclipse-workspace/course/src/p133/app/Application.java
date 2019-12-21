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
		System.out.println("******注册用户******");
		System.out.print("请输入用户名: ");
		String userName = scn.next();
		System.out.print("请输入密码: ");
		String password = scn.next();
		System.out.print("请重新输入密码: ");
		if (password.equals(scn.next()) == false) {
			System.out.println("两次输入的密码不相符, 请重新输入!");
			this.registe();
		} else {
			user.setUserName(userName);
			user.setPassword(password);
			userDao.addUser(user);
		}
	}
	
	public void login() {
		Scanner scn = new Scanner(System.in);
		System.out.println("******登录******");
		System.out.print("请输入用户名: ");
		String userName = scn.next();
		System.out.print("请输入密码: ");
		String password = scn.next();
		User user = userDao.getUser(userName, password);
		if (user != null) {
			System.out.println(user.getUserName() + " 已登录");
		} else {
			System.out.println("登陆失败");
		}
		
		
	}
	
	

}
