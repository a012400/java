package p75;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel hotel = new Hotel("miniHilton");
		System.out.println("欢迎如您入住" + hotel.getHoterlName() + "酒店");
		Scanner scn = new Scanner(System.in);
		System.out.println("请输入您的指令: ");
		String command = scn.next();
		String roomNo;
		while (!command.equalsIgnoreCase("quit")) {
			if (command.equalsIgnoreCase("search")) {
				String para = scn.next();
				if (para.equalsIgnoreCase("all")) {
					hotel.searchAll();
				} else {
					hotel.searchByNo(para);
				}
			} else if (command.equalsIgnoreCase("in")) {
				roomNo = scn.next();
				String name = scn.next();
				int res = hotel.checkIn(roomNo, name);
				if (res == 1) {
					System.out.println(name + "成功入住!");
				} else if (res == 2) {
					System.out.println("该客房已有客人!");
				} else if (res == 3) {
					System.out.println("客房编号输入错误");
				}
			} else if (command.equalsIgnoreCase("out")) {
				roomNo = scn.next();
				int res = hotel.checkOut(roomNo);
				if (res == 1) {
					System.out.println(roomNo + "成功退房!");
				} else if (res == 2) {
					System.out.println("该客房没有客人!");
				} else if (res == 3) {
					System.out.println("客房编号输入错误");
				}
			} else {
				System.out.println("没有该指令");
			}
			System.out.println("请输入您的指令: ");
			command = scn.next();
		}
		System.out.println("欢迎您的下次光临" + hotel.getHoterlName());
		scn.close();
		System.exit(0);

	}
}
