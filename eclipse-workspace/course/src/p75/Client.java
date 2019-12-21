package p75;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel hotel = new Hotel("miniHilton");
		System.out.println("��ӭ������ס" + hotel.getHoterlName() + "�Ƶ�");
		Scanner scn = new Scanner(System.in);
		System.out.println("����������ָ��: ");
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
					System.out.println(name + "�ɹ���ס!");
				} else if (res == 2) {
					System.out.println("�ÿͷ����п���!");
				} else if (res == 3) {
					System.out.println("�ͷ�����������");
				}
			} else if (command.equalsIgnoreCase("out")) {
				roomNo = scn.next();
				int res = hotel.checkOut(roomNo);
				if (res == 1) {
					System.out.println(roomNo + "�ɹ��˷�!");
				} else if (res == 2) {
					System.out.println("�ÿͷ�û�п���!");
				} else if (res == 3) {
					System.out.println("�ͷ�����������");
				}
			} else {
				System.out.println("û�и�ָ��");
			}
			System.out.println("����������ָ��: ");
			command = scn.next();
		}
		System.out.println("��ӭ�����´ι���" + hotel.getHoterlName());
		scn.close();
		System.exit(0);

	}
}
