package shopTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    static Admin admin;


    @BeforeAll
    static void init(){
        admin = new Admin("Admin");

        admin.AddProducts("Apple", "Fruit", 10);
        admin.AddProducts("Orange", "Fruit", 15);


    }


    @Test
    void main() {
        assertEquals(2, admin.productItems.size());

        assertEquals("Apple", admin.productItems.get(0).Name);
        assertEquals("Fruit", admin.productItems.get(0).Group);
        assertEquals(1, admin.productItems.get(0).Id);
        assertEquals(10, admin.productItems.get(0).Price);
    }
}