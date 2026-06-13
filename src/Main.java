import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        BankAccount acc =
                new BankAccount("ACC001", 1000);

        Calendar today = Calendar.getInstance();

        DepositTransaction deposit =
                new DepositTransaction(
                        500,
                        today,
                        "D001");

        WithdrawalTransaction withdrawal =
                new WithdrawalTransaction(
                        300,
                        today,
                        "W001");

        // Test Deposit
        deposit.printTransactionDetails();
        deposit.apply(acc);
        acc.printAccount();

        System.out.println();

        // Test Withdrawal
        try {

            withdrawal.printTransactionDetails();
            withdrawal.apply(acc);

        } catch (InsufficientFundsException e) {

            System.out.println(e.getMessage());
        }

        acc.printAccount();

        System.out.println();

        // Reverse Withdrawal
        withdrawal.reverse();
        acc.printAccount();

        System.out.println();

        // Polymorphism
        BaseTransaction bt;

        bt = deposit;
        bt.apply(acc);

        bt = withdrawal;

        try {
            bt.apply(acc);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        acc.printAccount();
    }
}
