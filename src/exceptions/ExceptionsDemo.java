package exceptions;

import java.io.IOException;

public class ExceptionsDemo {
    public static void show() throws IOException {
        var account = new Account();
        try {
            account.withdraw(1001);
        } catch (AccountException e) {
            Throwable cause = e.getCause();
            System.out.println(cause.getMessage());
        }
    }
}
