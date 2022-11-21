package shopTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    static Products product1;
    static Products product2;

    @BeforeAll
    static void init(){
        product1 = new Products("Apple", "Fruit", 10);
        product2 = new Products("Orange", "Fruit", 15);
    }


    @Test
    void setId() {
        product1.setId(1);
        assertEquals(1, product1.Id);
    }

    @Test
    void setName() {
        product1.setName("Pear");
        assertEquals("Pear", product1.Name);
    }

    @Test
    void setGroup() {
        product2.setGroup("Vegetable");
        assertEquals("Vegetable", product2.Group);
    }

    @Test
    void setPrice() {
        product1.setPrice(70);
        assertEquals(70, product1.Price);
    }
}