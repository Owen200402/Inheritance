package lambdas;

public class ConsolePrinter2 implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message.toUpperCase());
    }
}
