package java_collections.list;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue qp = new PriorityQueue();
		// �������������qp�м����ĸ�Ԫ��
		qp.offer(6);
		qp.offer(-3);
		qp.offer(20);
		qp.offer(18);
		// ���qp���У������ǰ�Ԫ�صļ���˳������
		System.out.println(qp);
		// ���ʶ��еĵ�һ��Ԫ�أ���ʵ���Ƕ�������С��Ԫ��
		System.out.println(qp.poll());
	}

}
