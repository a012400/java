package p106;

public class P106_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedDepositAccount f1 = new FixedDepositAccount("001", 100000.00, 36, 0.035);
		BankingAccount b1 = new BankingAccount("002", 100000, 182, 0.052);
		System.out.println(f1);
		System.out.println(b1);
	}
}
