package PaymentHandling;

import Orders.Order;

public class PaymentHandling {
	 public void processPayment(Order order, double paymentAmount) throws InsufficientPaymentException, InvalidPaymentAmoutException {
	        
	        double totalAmount = order.calculateTotalPrice();
	        System.out.println("Total Amount: " + totalAmount);
	        
	        
	        if (paymentAmount < totalAmount) {
	            throw new InsufficientPaymentException("Payment is insufficient. Please pay the full amount.");
	        }
	        
	        
	        if (paymentAmount < 0) {
	            throw new InvalidPaymentAmoutException("Payment amount must be greater than zero.");
	        }

	        
	        double change = paymentAmount - totalAmount;
	        if (change > 0) {
	            System.out.println("Payment Successful! Your change is: " + change);
	        } else {
	            System.out.println("Payment Successful! No change is due.");
	        }
	    }
}
