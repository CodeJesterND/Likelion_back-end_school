package april.day11.ex.other;

import april.day11.ex.Account;
import april.day11.ex.AccountNotFoundException;

public class BankArray {
    private String bankName; // 은행 이름
    private Account[] accounts; // 통장 목록
    private int numOfAccounts; // 등록된 통장 수

    // 은행 생성
    public BankArray(String bankName, int capacity) {
        this.bankName = bankName;
        this.accounts = new Account[capacity]; // 통장 객체 배열 생성
        this.numOfAccounts = 0; // 초기 등록된 통장 수는 0
    }

    // 통장 개설 기능
    public void openAccount(String accountNumber, String accountHolder) {
        // 새로운 통장 생성 및 목록에 추가
        Account account = new Account(accountNumber, accountHolder);
        accounts[numOfAccounts++] = account;
        System.out.println("통장이 개설되었습니다. 계좌번호: " + accountNumber);
    }

    // 특정 통장 정보 조회 기능 -> 입력된 계좌 번호와 일치하는 통장을 배열에서 찾아 반환
    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        for (int i = 0; i < numOfAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        // AccountNotFoundException -> 일치하는 통장이 없는 경우 예외 처리
        throw new AccountNotFoundException("통장을 찾을 수 없습니다.");
    }
}