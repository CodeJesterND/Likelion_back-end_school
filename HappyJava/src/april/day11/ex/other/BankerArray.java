package april.day11.ex.other;

import april.day11.ex.Account;
import april.day11.ex.AccountNotFoundException;
import april.day11.ex.InsufficientFundsException;

public class BankerArray {
    private String name; // 은행원 이름
    private String bankerId; // 은행원 ID

    // 은행원 생성자
    public BankerArray(String name, String bankerId) {
        this.name = name;
        this.bankerId = bankerId;
    }

    // 통장 개설 승인 기능
    public void approveAccount(BankArray bankArray, String accountNumber, String accountHolder) {
        bankArray.openAccount(accountNumber, accountHolder);
    }

    // 출금 승인 기능
    public void approveWithdraw(BankArray bankArray, String accountNumber, int amount) throws AccountNotFoundException, InsufficientFundsException {
        Account account = bankArray.getAccount(accountNumber);
        account.withdraw(amount);
        System.out.println("출금이 송금되었습니다. 출금액: " + amount);
    }
}