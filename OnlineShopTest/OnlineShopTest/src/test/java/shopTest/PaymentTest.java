package shopTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {



    @Test
    void makePayment() {
        Customer customer1 = new Customer("John");
        Products product1 = new Products("Apple", "Fruit", 10);
        Products product2 = new Products("Orange", "Fruit", 15);

        customer1.AddToCart(product1);
        customer1.AddToCart(product2);

        assertEquals(25, customer1.payment.MakePayment(customer1.cart.SumTotalPrice()));
    }
}