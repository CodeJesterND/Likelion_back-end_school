package april.day11.ex;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName; // 은행 이름
    private List<Account> accounts; // 통장 목록

    // 은행 생성
    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    // 통장 개설 기능
    public void openAccount(String accountNumber, String accountHolder) {
        // 새로운 통장 생성 및 목록에 추가
        Account account = new Account(accountNumber, accountHolder);
        accounts.add(account);
        System.out.println(accountHolder + "님 통장이 개설되었습니다. 계좌번호는 " + accountNumber + " 입니다.");
    }

    // 특정 통장 정보 조회 기능 -> 입력된 계좌 번호와 일치하는 통장을 배열에서 찾아 반환
    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        // AccountNotFoundException -> 일치하는 통장이 없는 경우 예외 처리
        throw new AccountNotFoundException("통장을 찾을 수 없습니다.");
    }

    // 특정 통장 정보 출력 기능 -> 특정 통장의 정보를 출력
    public void printAccountInfo(String accountNumber) {
        try {
            Account account = getAccount(accountNumber); // 특정 통장 정보 조회
            System.out.println("통장 정보 ⤵\uFE0F");
            System.out.println("은행명: " + bankName);
            System.out.println("계좌번호: " + account.getAccountNumber());
            System.out.println("예금주: " + account.getAccountHolder());
            System.out.println("잔액: " + account.getBalance() + "원");
        } catch (AccountNotFoundException e) {
            System.out.println("통장을 찾을 수 없습니다.");
        }
    }
}