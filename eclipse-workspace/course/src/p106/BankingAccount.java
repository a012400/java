package p106;

public class BankingAccount extends Account {
	private int days;
	private double rate;

	public BankingAccount() {
		super();
	}

	public BankingAccount(String idCard, double balance) {
		super(idCard, balance);
		// TODO Auto-generated constructor stub
	}

	public BankingAccount(String idCard, double balance, int days, double rate) {
		super(idCard, balance);
		this.days = days;
		this.rate = rate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
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
		return this.getBalance() * this.getRate() * this.getDays() / 365;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s账户%.1f元存款的%d天的利息:%.2f(年利率为%.2f)", this.getIdCard(),
				this.getBalance(), this.getDays(), this.getInterest(), (this.getRate()*100));
	}

}
