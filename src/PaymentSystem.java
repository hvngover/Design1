import java.util.Scanner;

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentGateway paymentGateway = PaymentGateway.getInstance();

        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");

        int choice = scanner.nextInt();
        PaymentStrategy paymentStrategy;

        switch (choice) {
            case 1:
                paymentStrategy = new CreditCardPayment();
                break;
            case 2:
                paymentStrategy = new PayPalPayment();
                break;
            default:
                System.out.println("Invalid choice. Using default payment method (Credit Card).");
                paymentStrategy = new CreditCardPayment();
        }

        System.out.print("Enter your credit card number: ");
        String cardNumber = scanner.next();

        System.out.print("Enter the payment amount: $");
        int amount = scanner.nextInt();


        paymentGateway.processPayment(amount, paymentStrategy);

        
    }
}
