package april.day11.ex;

public class Account {
    private String accountNumber; // 통장번호
    private String accountHolder; // 예금주 이름
    private int balance = 0; // 잔액

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0; // 초기 잔액은 0으로 설정
    }

    // 통장번호
    public String getAccountNumber() {
        return accountNumber;
    }

    // 예금주 이름
    public String getAccountHolder() {
        return accountHolder;
    }

    public int getBalance() {
        return balance;
    }

    // 입금 기능
    public void deposit(int amount) {
        balance += amount;
    }

    // 출금 기능
    public void withdraw(int amount) throws InsufficientFundsException {
        // InsufficientResourcesException -> 출금 금액이 잔액보다 큰 경우 예외처리
        if (balance < amount) {
            throw new InsufficientFundsException("잔액이 부족합니다.");
        }
        balance -= amount;
    }
}