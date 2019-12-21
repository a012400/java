package p75;

public class Hotel {
	private String hoterlName;
	private Room[][] rooms;
	public final int HEIGHT = 6;
	public final int WIDTH = 12;

	public Hotel() {
		super();
		rooms = new Room[HEIGHT][WIDTH];
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				rooms[i][j] = new Room();
				rooms[i][j].setId(i + 1, j + 1);
			}
		}
	}

	public Hotel(String hoterlName) {
		this();
		this.hoterlName = hoterlName;
	}

	public String getHoterlName() {
		return hoterlName;
	}

	public void setHoterlName(String hoterlName) {
		this.hoterlName = hoterlName;
	}

	public Room[][] getRooms() {
		return rooms;
	}

	public void setRooms(Room[][] rooms) {
		this.rooms = rooms;
	}

	public void searchAll() {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print(rooms[i][j].getId() + "\t");
			}
			System.out.println();
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print(rooms[i][j].getCustomerName() == null ? "\t" : rooms[i][j].getCustomerName() + "\t");
			}
			System.out.println();
			for (int j = 1; j <= 8 * WIDTH; j++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}

	private boolean testRoomNo(String roomNo) {
		int height = Integer.parseInt(roomNo.substring(0, 2));
		int width = Integer.parseInt(roomNo.substring(2, 4));
		if (height < 1 || height > HEIGHT || width < 1 || width > WIDTH) {
			return false;
		} else {
			return true;
		}
	}

	public void searchByNo(String roomNo) {
		if (testRoomNo(roomNo)) {
			int height = Integer.parseInt(roomNo.substring(0, 2));
			int width = Integer.parseInt(roomNo.substring(2, 4));
			System.out.println(rooms[height - 1][width - 1].getCustomerName() == null ? "该客房没有客人"
					: roomNo + "\t" + rooms[height - 1][width - 1].getCustomerName());
		} else {
			System.out.println("没有这个客房");
		}
	}

	public int checkIn(String roomNo, String name) {
		if (testRoomNo(roomNo)) {
			int height = Integer.parseInt(roomNo.substring(0, 2));
			int width = Integer.parseInt(roomNo.substring(2, 4));
			if (rooms[height - 1][width - 1].in(name)) {
				return 1;
			} else {
				return 2;
			}
		} else {
			return 3;
		}
	}

	public int checkOut(String roomNo) {
		if (testRoomNo(roomNo)) {
			int height = Integer.parseInt(roomNo.substring(0, 2));
			int width = Integer.parseInt(roomNo.substring(2, 4));
			if (rooms[height - 1][width - 1].out()) {
				return 1;
			} else {
				return 2;
			}
		} else {
			return 3;
		}
	}
}