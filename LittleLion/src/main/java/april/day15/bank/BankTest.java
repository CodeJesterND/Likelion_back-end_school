package april.day15.bank;
import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		Bank bank = new Bank();

		Scanner keyboard = new Scanner(System.in);
		System.out.println("통장이 있으면 1을 없으시면 2번을 입력해 주세요. ");
		int accountInfo = keyboard.nextInt();
		CheckAccount checkAccount = null;
		if(accountInfo == 1){
			System.out.println("통장 번호를 입력하세요.");
			String accountNumber = keyboard.next();
			checkAccount = bank.getCheckAccount(accountNumber);
		}else{

			// 이분에서 하는 일을 bank 클래스에 메소드로 추가해서 (createCheckAccount()) 아래 부분을 수행할 수 있게
			//해주면 더 좋을거 같아요.
			checkAccount = bank.createCheckAccount(keyboard);
		}

		if(checkAccount == null){
			System.out.println("없는 계좌입니다. ");
			checkAccount = bank.createCheckAccount(keyboard);
		}
		a:while (true) {
			System.out.println("원하는 업무를 선택하세요.  입금은 1, 출금은 2, 업무를 종료하시려면 3 을 입력하세요.");
			int flag = keyboard.nextInt();
			switch (flag) {
				case 1:
					System.out.println("입금하려는 금액을 입력하세요.");
					int money = keyboard.nextInt();
					bank.deposit(checkAccount, money);
					System.out.println("입금이 완료되었습니다. 현재 잔액은 :"+checkAccount.getBalance());
					break;
				case 2:
					System.out.println("출금하려는 금액을 입력하세요.");
					int money2 = keyboard.nextInt();
					try {
						bank.withdraw(checkAccount, money2);
						System.out.println("출금이 완료되었습니다. 현재 잔액은 :"+checkAccount.getBalance());

					} catch (BankException e) {
						System.out.println(e);
						System.out.println("출금은 잔액보다 많이 할 수 없습니다. 다시 업무를 수행하세요.");
					}
					break;
				case 3:
					System.out.println("업무를 종료합니다. 안녕히 가세요.");
					break a;
				default:
					System.out.println("잘못입력하셨습니다. 다시 입력해 주세요.");
					break ;
			}

		}



		//종료될때  은행이 가지고 있는 모든 계좌정보를 출력해 주세요.
		bank.printCheckAccounts();
		//은행업무가 끝날때 파일에 계좌 정보를 저장한다.
		bank.saveFile();
	}

}
