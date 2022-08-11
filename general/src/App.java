import java.math.BigInteger;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        A a = new B();
        a.sound();

        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger total = BigInteger.ZERO;
        total.add(fiveThousand);
        total.add(fiftyThousand);
        System.out.println(total);
        System.out.println(total.add(fiveThousand));
    }
}
