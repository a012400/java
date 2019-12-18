package p133;

import p133.app.Application;
import p133.base.UserDaoForArray;

public class ApplicationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDaoForArray userDao = new UserDaoForArray();
		Application app = new Application(userDao);
		app.registe();
		app.login();
	}
}
