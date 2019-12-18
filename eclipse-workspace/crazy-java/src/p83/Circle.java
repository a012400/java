package p83;

public class Circle {
		// 圆的半径
		private double radius;
		// 圆心坐标x
		private int cx;
		// 圆心坐标y
		private int cy;

		/**
		 * 无参数的构造器
		 * @return 类实例的引用
		 */
		public Circle() {
			this.radius = 0;
			this.cx = 0;
			this.cy = 0;
		}

		/**
		 * 三个参数的构造器
		 * @param  cx     圆心坐标x
		 * @param  cy     圆心坐标y
		 * @param  radius 圆的半径
		 * @return        类实例的引用
		 */
		public Circle(int cx, int cy, double radius) {
			this.cx = cx;
			this.cy = cy;
			this.radius = radius;
		}
		
		/**
		 * 计算圆的面积
		 * @return 圆的面积
		 */
		public double getArea() {
			return Math.PI * this.radius * this.radius;
		}
		
		/**
		 * 判断一个点是否在圆内
		 * @param  p 坐标点类的实例
		 * @return   在圆内返回true 在圆外返回false
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
		 * 判断一个点是否在圆内, 调用重载的一个参数的方法, 减少代码复用
		 * @param  x 点坐标x
		 * @param  y 点坐标y
		 * @return   在圆内返回true 在圆外返回false
		 */
		public boolean contains(int x, int y) {
			Point p = new Point(x, y);
			return this.contains(p);
		}
}