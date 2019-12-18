package p83;

public class Circle {
		// Բ�İ뾶
		private double radius;
		// Բ������x
		private int cx;
		// Բ������y
		private int cy;

		/**
		 * �޲����Ĺ�����
		 * @return ��ʵ��������
		 */
		public Circle() {
			this.radius = 0;
			this.cx = 0;
			this.cy = 0;
		}

		/**
		 * ���������Ĺ�����
		 * @param  cx     Բ������x
		 * @param  cy     Բ������y
		 * @param  radius Բ�İ뾶
		 * @return        ��ʵ��������
		 */
		public Circle(int cx, int cy, double radius) {
			this.cx = cx;
			this.cy = cy;
			this.radius = radius;
		}
		
		/**
		 * ����Բ�����
		 * @return Բ�����
		 */
		public double getArea() {
			return Math.PI * this.radius * this.radius;
		}
		
		/**
		 * �ж�һ�����Ƿ���Բ��
		 * @param  p ��������ʵ��
		 * @return   ��Բ�ڷ���true ��Բ�ⷵ��false
		 */
		public boolean contains(Point p) {
			Point cp = new Point(this.cx, this.cy);
			double len;
			len = p.distance(cp);
			if (len < this.radius) {
				return true;
			}else {
				return false;
			}
		}

		/**
		 * �ж�һ�����Ƿ���Բ��, �������ص�һ�������ķ���, ���ٴ��븴��
		 * @param  x ������x
		 * @param  y ������y
		 * @return   ��Բ�ڷ���true ��Բ�ⷵ��false
		 */
		public boolean contains(int x, int y) {
			Point p = new Point(x, y);
			return this.contains(p);
		}
}