package april.day11.ex;

public class BankOopMain {
    public static void main(String[] args) {
        Bank ibkBank = new Bank("기업은행"); // 은행 생성
        Banker ibkBanker = new Banker("신효승", "K980126"); // 은행원 생성

        ibkBanker.approveAccount(ibkBank, "201903281820", "효빈"); //통장 개설 승인

        // 출금 승인 및 출금 시도
        try {
            Account account = ibkBank.getAccount("201903281820"); // 특정 통장 정보 조회
            account.deposit(50000); // 입금
            account.withdraw(20000); // 출금
        } catch (AccountNotFoundException e) {
            System.out.println("통장을 찾을 수 없습니다.");
        } catch (InsufficientFundsException e) {
            System.out.println("잔액이 부족합니다.");
        }

        // 특정 통장 정보 출력
        ibkBank.printAccountInfo("201903281820");

        //
    }
}