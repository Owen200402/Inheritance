package exceptions;

public class Account {
    private float balance = 1000;

    public void deposit(float value) {
        if (value <= 0)
            throw new IllegalArgumentException();
    }

    public void withdraw(float value) throws AccountException {
        if (value > balance) {
            throw new AccountException(new InsufficientFundsException());
        }
    }
}
