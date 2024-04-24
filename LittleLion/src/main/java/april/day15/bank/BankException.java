package april.day15.bank;


public class BankException extends Exception {
	public BankException(){
		super("잔액이 부족합니다.");
	}
	public BankException(String msg) {
		super(msg);
	}
}
