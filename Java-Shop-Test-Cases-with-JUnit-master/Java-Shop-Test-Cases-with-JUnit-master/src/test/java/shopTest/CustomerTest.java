package shopTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class CustomerTest {
    static Customer customer1;
    static Customer customer2;

    static Products product1;
    static Products product2;

    @BeforeAll
    static void init() {
        customer1 = new Customer("John");
        customer2 = new Customer("Mary");

        product1 = new Products("Apple", "Fruit", 10);
        product2 = new Products("Orange", "Fruit", 15);

        customer1.AddToCart(product1);
        customer1.AddToCart(product2);

    }


    @Test
    void viewCartProducts() {
        assertEquals(2, customer1.cart.cartItems.size());
        assertEquals("Apple", customer1.cart.cartItems.get(0).Name);
        assertEquals("Fruit", customer1.cart.cartItems.get(0).Group);
        assertEquals(10, customer1.cart.cartItems.get(0).Price);

        assertSame(customer1.cart.ViewCart(), customer1.ViewCartProducts());
    }

    @Test
    void makePayment() {
        customer1.payment.MakePayment(customer1.cart.SumTotalPrice());
        assertEquals(25, customer1.cart.SumTotalPrice());
    }

    @Test
    void addToCart() {
        assertEquals(2, customer1.cart.cartItems.size());
        assertEquals("Apple", customer1.cart.cartItems.get(0).Name);
        assertEquals("Fruit", customer1.cart.cartItems.get(0).Group);
        assertEquals(10, customer1.cart.cartItems.get(0).Price);
    }

    @Test
    void deleteFromCart() {
        customer2.AddToCart(product1);
        customer2.AddToCart(product2);
        assertEquals(2, customer2.cart.cartItems.size());

        customer2.DeleteFromCart(1);
        assertEquals(1, customer2.cart.cartItems.size());

    }
}