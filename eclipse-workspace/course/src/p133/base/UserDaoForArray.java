package p133.base;

import p133.intfc.UserDao;

public class UserDaoForArray implements UserDao {
	private User[] data;
	private int count;
	

	public UserDaoForArray() {
		super();
		this.data = new User[5];
		this.count = 0;
	}


	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		data[count] = new User();
		if (data[count] != null) {
			data[count].setUserName(user.getUserName());
			data[count].setPassword(user.getPassword());
			count++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getUser(String userName, String password) {
		// TODO Auto-generated method stub
		for (int i=0; i<count; i++) {
			if (data[i].getUserName().equals(userName)
					&& data[i].getPassword().equals(password)) {
				return data[i];
			}
		}
		return null;
	}

}
