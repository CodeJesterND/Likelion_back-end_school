package april.day15.bank;

import april.day15.bank.BankException;
import april.day15.bank.CheckAccount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Bank {
	//속성 계좌들 선언
	private Map<String, CheckAccount> checkAccounts ;

	//생성자 (Bank가 생성될때 기본 고객 10명을 생성해서 계좌들이 가지고 있을 수 있게 구현
	public Bank(){
		checkAccounts = new HashMap<>();
		BufferedReader br = null;

//		try{
//			br = new BufferedReader(new FileReader("bankInfo.txt"));
//			String line = null;
//			while((line = br.readLine())!= null){
//				String[] values = line.split(":");
//				int balance = Integer.parseInt(values[2]);
//				CheckAccount ca = new CheckAccount(values[1], values[0],balance);
//				checkAccounts.put(values[1],ca );
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			try {
//				br.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		checkAccounts.put("1", new CheckAccount("1", "강경미"));
		checkAccounts.put("2", new CheckAccount("2", "김은영"));
		checkAccounts.put("3", new CheckAccount("3", "김지택"));
		checkAccounts.put("4", new CheckAccount("4", "김평안"));
		checkAccounts.put("5", new CheckAccount("5", "문명미"));
		checkAccounts.put("6", new CheckAccount("6", "박재현"));
		checkAccounts.put("7", new CheckAccount("7", "서기원"));
		checkAccounts.put("8", new CheckAccount("8", "손정환"));
		checkAccounts.put("9", new CheckAccount("9", "유동근"));
		checkAccounts.put("10", new CheckAccount("10", "유연주"));
	}

	//입금하다.
	public void deposit(CheckAccount checkAccount, int money){
		//파라메터로 받아들인 통장에 money를 입금한다.
		checkAccount.setBalance(checkAccount.getBalance()+money);

	}

	//출금하다
	public void withdraw(CheckAccount checkAccount, int money) throws BankException {
		//1. 통장객체의 잔액이 출금하려는 돈보다 작을때 BankException을 발생시키고 싶어요.
		if(checkAccount.getBalance() < money){
			throw new BankException("잔액이 출금할 금액보다 작습니다.  잔액 : "+checkAccount.getBalance());
		}else{
			//2. 그렇치 않다면, 통장 잔액에서 출금하려는 금액을 빼주면 됩니다.
			checkAccount.setBalance(checkAccount.getBalance() - money);
		}
	}

	//계좌번호를 이용해서 계좌 객체를 얻어오는 메소드
	public CheckAccount getCheckAccount(String accountNumber) {
		return checkAccounts.get(accountNumber);
	}
	//계좌를 신규로 개설하는 메소드
	public CheckAccount createCheckAccount(Scanner keyboard){
		System.out.println("고객의 이름을 입력하세요.");
		String name = keyboard.next();
		String accountNumber = null;
		do{
			System.out.println("사용할 계좌 번호를 입력하세요.");
			accountNumber = keyboard.next();
			if(isAccountNumber(accountNumber)){
				System.out.println("이미 존재하는 계좌번호 입니다.  다시 입력해 주세요.!!");
			}else{
				break;
			}
		}while(true);
		System.out.println("맡기실 금액이 있다면 입력하시고, 없으면 0을 입력해 주세요. ");
		int balance = keyboard.nextInt();
		//bank 객체가 가지고 있는 속성 checkAccounts 에 고객이 입력한 정보를 이용하여
		//CheckAccount 객체를 성성해서 넣어주세요.
		//이렇게 처리해도 괜찮고....
		/*	CheckAccount ca = new CheckAccount(accountNumber, name, balance);
		checkAccounts.put(accountNumber, ca);
		
		return ca;*/
		checkAccounts.put(accountNumber, new CheckAccount(accountNumber, name, balance));
		return checkAccounts.get(accountNumber);
	}

	private boolean isAccountNumber(String accountNumber){
		return checkAccounts.containsKey(accountNumber);
	}

	public void printCheckAccounts() {
		Set<String> keys = checkAccounts.keySet();
		for (String key : keys) {
			System.out.println(checkAccounts.get(key));
		}
	}

	public void saveFile(){
		PrintWriter pw = null;
		try{
			pw = new PrintWriter("bankInfo.txt");
			Set<String> keys = checkAccounts.keySet();
			for (String key : keys) {
				CheckAccount ca = checkAccounts.get(key);
				pw.println(ca.getName()+":"+ca.getAccountNumber()+":"+ca.getBalance());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.close();
		}


	}
}
