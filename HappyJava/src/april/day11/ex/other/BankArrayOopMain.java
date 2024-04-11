package april.day11.ex.other;

import april.day11.ex.Account;
import april.day11.ex.AccountNotFoundException;
import april.day11.ex.InsufficientFundsException;

public class BankArrayOopMain {
    public static void main(String[] args) {
        BankArray ibkBank = new BankArray("기업은행", 10); // 은행 생성
        BankerArray ibkBanker = new BankerArray("신효승", "K980126"); // 은행원 생성

        ibkBanker.approveAccount(ibkBank, "97502249201018", "신재연"); //통장 개설 승인

        try {
            Account account = ibkBank.getAccount("97502249201018"); // 특정 통장 정보 조회
            account.deposit(50000); // 입금
            account.withdraw(20000); // 출금
        } catch (AccountNotFoundException e) {
            System.out.println("통장을 찾을 수 없습니다.");
        } catch (InsufficientFundsException e) {
            System.out.println("잔액이 부족합니다.");
        }
    }
}