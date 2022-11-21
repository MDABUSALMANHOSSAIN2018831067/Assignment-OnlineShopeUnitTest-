package shopTestWithoutPayment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shopTest.Admin;
import shopTest.Products;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    static Admin admin1;
    static Admin admin2;
    static Products product1;
    static Products product2;
    static Products product3;


    @BeforeAll
    static void init(){
        admin1 = new Admin("admin1");
        admin2 = new Admin("admin2");

        product1 = new Products("Apple", "Fruit", 10);
        product2 = new Products("Orange", "Fruit", 15);
        product3 = new Products("Banana", "Fruit", 20);

        admin1.AddProducts(product1.Name, product1.Group, product1.Price);
        admin1.AddProducts(product2.Name, product2.Group, product2.Price);
        admin1.AddProducts(product3.Name, product3.Group, product3.Price);
    }

    @Test
    void ProductsItemsSizeIsThree() {
        assertEquals(3, admin1.productItems.size());
    }

    @Test
    void viewProducts() {

        assertEquals(3, admin1.productItems.size());

        assertEquals("Apple", admin1.productItems.get(0).Name);
        assertEquals("Fruit", admin1.productItems.get(0).Group);
        assertEquals(4, admin1.productItems.get(0).Id);
        assertEquals(10, admin1.productItems.get(0).Price);
    }

    @Test
    void addProducts() {
        admin2.AddProducts(product1.Name, product1.Group, product1.Price);
        assertEquals(1, admin2.productItems.size());

        admin2.AddProducts(product2.Name, product2.Group, product2.Price);
        assertEquals(2, admin2.productItems.size());

        admin2.AddProducts(product3.Name, product3.Group, product3.Price);
        assertEquals(3, admin2.productItems.size());
    }

    @Test
    void deleteProducts() {
        admin1.DeleteProducts(1);
        assertEquals(2, admin1.productItems.size());

        admin1.DeleteProducts(0);
        assertEquals(1, admin1.productItems.size());

    }

    @Test
    void modifyProducts() {
        admin2.AddProducts(product1.Name, product1.Group, product1.Price);
        admin2.AddProducts(product2.Name, product2.Group, product2.Price);
        admin2.AddProducts(product3.Name, product3.Group, product3.Price);


        admin2.ModifyProducts(0,"Peanut", "Nut", 30);
        assertEquals("Peanut", admin2.productItems.get(0).Name);
        assertEquals("Nut", admin2.productItems.get(0).Group);
        assertEquals(30, admin2.productItems.get(0).Price);
    }
}