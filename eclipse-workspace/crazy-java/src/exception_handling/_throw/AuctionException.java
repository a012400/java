package exception_handling._throw;

public class AuctionException extends Exception {
	// 无参数的构造器
	public AuctionException() {
	}

	// 带一个字符串参数的构造器
	public AuctionException(String msg) {
		super(msg);
	}
}
