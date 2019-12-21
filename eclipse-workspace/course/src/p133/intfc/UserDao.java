package p133.intfc;

import p133.base.User;

public interface UserDao {
	public boolean addUser(User user);
	public User getUser(String userName, String password);

}
