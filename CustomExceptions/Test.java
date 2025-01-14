package CustomExceptions;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account = new BankAccount(500);

        try {
            account.deposit(200);
            account.withdraw(800);
        } catch (InsufficientBalanceException | NegativeDepositException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            account.deposit(-50);
        } catch (NegativeDepositException e) {
            System.out.println("Error: " + e.getMessage());
        }
	}

}
