package april.day11.ex;

public class Banker {
    private String name; // 은행원 이름
    private String bankerId; // 은행원 ID

    // 은행원 생성자
    public Banker(String name, String bankerId) {
        this.name = name;
        this.bankerId = bankerId;
    }

    // 통장 개설 승인 기능
    public void approveAccount(Bank bank, String accountNumber, String accountHolder) {
        bank.openAccount(accountNumber, accountHolder);
    }

    // 출금 승인 기능 -> 일반적으로 은행 시스템에서는 출금 요청이 들어왔을 때 은행원이 직접적으로 승인하는 것이 아닌 시스템이 자동으로 처리하기 때문에 기능만 구현 실행 X
    public void approveWithdraw(Bank bank, String accountNumber, int amount) throws AccountNotFoundException, InsufficientFundsException {
        Account account = bank.getAccount(accountNumber);
        account.withdraw(amount);
        System.out.println("출금되었습니다. 출금액: " + amount);
    }
}