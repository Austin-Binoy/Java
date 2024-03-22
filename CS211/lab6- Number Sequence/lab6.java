import java.math.BigInteger;

public class lab6 {
    public static void main(String args[]) {
        BigInteger num = new BigInteger("400000000000");
        int seq = 0;
        
        while (!num.equals(BigInteger.ONE)) {
            if (num.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.valueOf(2));
            } else {
                num = num.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
            }
            seq++;

            System.out.println("Step" + seq +":" + num);
        }
        
        System.out.println("The sequence is: " + seq);
    }
}
