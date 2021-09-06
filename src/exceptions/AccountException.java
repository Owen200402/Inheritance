package exceptions;

public class AccountException extends Exception{
// Chaining Exception
    public AccountException(Exception cause){
        super(cause);
    }
}
