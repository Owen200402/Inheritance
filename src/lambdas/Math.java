package lambdas;

import java.util.function.Supplier;

public class Math implements Supplier {
    @Override
    public Object get() {
        return java.lang.Math.random();
    }
}
