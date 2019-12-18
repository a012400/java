package p83;

public class Point {
		// �����x
		private int x;
		// �����y
		private int y;
		
		/**
		 * �޲����Ĺ�����
		 * @param void
		 * @return ��ʵ��������
		 */
		public Point() {
			this.x = 0;
			this.y = 0;
		}
		
		/**
		 * һ�������Ĺ�����, �������ع�����, ���ٴ��븴��
		 * @param x 
		 * @return ��ʵ��������
		 */
		public Point(int x) {
			this.x = x;
			this.y = x;
		}
		
		/**
		 * ���������Ĺ�����
		 * @param x �������x��
		 * @param y �������y��
		 * @return ��ʵ��������
		 */
		public Point(int x, int y) {
			this(x);
			this.y = y;
		}
		
		/**
		 * ���㵱ǰ�㵽��һ����ľ���
		 * @param  x int���� �������x
		 * @param  y int���� �������y
		 * @return   ��ǰ�㵽��һ����ľݾ���
		 */
		public double distance(int x, int y) {
			return Math.sqrt( Math.pow(x-this.x, 2)+Math.pow(y-this.y, 2));
		}
		
		/**
		 * ��ǰ�㵽ԭ��ľ���, ֱ�ӵ������ص����������ķ���, ���ٴ��븴��
		 * @return ��ǰ�㵽Զ��ľ���
		 */
		public double distance() {
			return this.distance(0, 0);
		}
		/**
		 * ���㵱ǰ�㵽��һ����ľ���, ͬ���������ص����������ķ���, ���ٴ��븴��
		 * @param  other ��һ�����ʵ��
		 * @return   ��ǰ�㵽��һ����ľݾ���
		 */
		
		public double distance(Point other) {
			return other.distance(this.x, this.y);
		}
}