package april.day15.bank;

import java.util.Scanner;

//통장
public class CheckAccount {
	private String accountNumber; //계좌번호
	private String name; //이름
	private int balance; //잔액
	public CheckAccount(String accountNumber,String name){
		this(accountNumber,name,0);
	}
	public CheckAccount(String accountNumber,String name, int balance){
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "[고객이름 :" + name + ",계좌번호 : " + accountNumber + ",  잔액 : " + balance + "]";
	}

	public static void main(String[] args) {
		Bank b = new Bank();
		b.printCheckAccounts();

		Scanner keyboard = new Scanner(System.in);
		b.createCheckAccount(keyboard);

		b.printCheckAccounts();
	}

}
