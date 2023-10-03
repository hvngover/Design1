public class PaymentGateway {
    private static PaymentGateway instance;

    private PaymentGateway() {
    }

    public static PaymentGateway getInstance() {
        if (instance == null) {
            instance = new PaymentGateway();
        }
        return instance;
    }

    public void processPayment(int amount, PaymentStrategy strategy) {
        strategy.pay(amount);
    }
}
