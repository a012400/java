package exception_handling._throw;

public class AuctionException extends Exception {
	// �޲����Ĺ�����
	public AuctionException() {
	}

	// ��һ���ַ��������Ĺ�����
	public AuctionException(String msg) {
		super(msg);
	}
}
