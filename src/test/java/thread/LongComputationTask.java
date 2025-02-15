package thread;

import java.math.BigInteger;

record LongComputationTask(BigInteger base, BigInteger power) implements Runnable {
    @Override
    public void run() {
        System.out.printf("%d^%d = %d\n", base, power, pow(base, power));
    }

    private BigInteger pow(BigInteger base, BigInteger power) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted !!!");
                return BigInteger.ZERO;
            }
            result = result.multiply(base);
        }
        return result;
    }
}
