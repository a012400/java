package p83;

public class Point {
		// 坐标点x
		private int x;
		// 坐标点y
		private int y;
		
		/**
		 * 无参数的构造器
		 * @param void
		 * @return 类实例的引用
		 */
		public Point() {
			this.x = 0;
			this.y = 0;
		}
		
		/**
		 * 一个参数的构造器, 调用重载构造器, 减少代码复用
		 * @param x 
		 * @return 类实例的引用
		 */
		public Point(int x) {
			this.x = x;
			this.y = x;
		}
		
		/**
		 * 两个参数的构造器
		 * @param x 点坐标的x轴
		 * @param y 点坐标的y轴
		 * @return 类实例的引用
		 */
		public Point(int x, int y) {
			this(x);
			this.y = y;
		}
		
		/**
		 * 计算当前点到另一个点的距离
		 * @param  x int类型 点坐标的x
		 * @param  y int类型 点坐标的y
		 * @return   当前点到另一个点的据距离
		 */
		public double distance(int x, int y) {
			return Math.sqrt( Math.pow(x-this.x, 2)+Math.pow(y-this.y, 2));
		}
		
		/**
		 * 当前点到原点的距离, 直接调用重载的两个参数的方法, 减少代码复用
		 * @return 当前点到远点的距离
		 */
		public double distance() {
			return this.distance(0, 0);
		}
		/**
		 * 计算当前点到另一个点的距离, 同样调用重载的两个参数的方法, 减少代码复用
		 * @param  other 另一个点的实例
		 * @return   当前点到另一个点的据距离
		 */
		
		public double distance(Point other) {
			return other.distance(this.x, this.y);
		}
}