package p106;

public class FixedDepositAccount extends Account {
	private int months;
	private double rate;

	public FixedDepositAccount() {
		super();
	}

	public FixedDepositAccount(String idCard, double balance) {
		super(idCard, balance);
		// TODO Auto-generated constructor stub
	}

	public FixedDepositAccount(String idCard, double balance, int months, double rate) {
		super(idCard, balance);
		this.months = months;
		this.rate = rate;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double getInterest() {
		// TODO Auto-generated method stub
		return this.getBalance() * this.getRate() * this.getMonths() / 12;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s账户%.1f元存款的%d月的利息:%.2f(年利率为%.2f)", this.getIdCard(),
				this.getBalance(), this.getMonths(), this.getInterest(), (this.getRate()*100));
	}
}