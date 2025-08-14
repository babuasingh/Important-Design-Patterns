/*When to use the Strategy Pattern
    When you need to choose behavior/algorithm at runtime.
    To eliminate long if-else or switch statements.
    When you want to make a class open to extension but closed to modification. */

interface makePayment{
    void pay(double amount);
}

class creditCardPayment implements makePayment{
    public void pay(double amount){
        System.out.println("Making payment of rupees "+amount+" via CreditCard");
    }
}

class UPIPayment implements makePayment{
    public void pay(double amount){
        System.out.println("Making payment of rupees "+amount+" via UPI");
    }
}

class PaypalPayment implements makePayment{
    public void pay(double amount){
        System.out.println("Making payment of rupees "+amount+" via PayPal");
    }
}

class paymentStrategy{
    private makePayment payment;

    public paymentStrategy(makePayment payment){
        this.payment=payment;
    }

    public void processPayment(double amount){
        payment.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        
        paymentStrategy creditcard = new paymentStrategy(new creditCardPayment());
        creditcard.processPayment(1000.2);

        paymentStrategy UPI = new paymentStrategy(new UPIPayment());
        UPI.processPayment(1234.5);

    }    
}
