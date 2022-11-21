package OnlineShopTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    static Admin admin1;
    static Admin admin2;
    static Admin admin3;
    static Products product1;
    static Products product2;
    static Products product3;

    static Products product4;
    static Products product5;


    @BeforeAll
    static void init(){
        admin1 = new Admin("admin1");
        admin2 = new Admin("admin2");
        admin3 = new Admin("admin3");

        product1 = new Products("Apple", "Fruit", 250);
        product2 = new Products("Orange", "Fruit", 20);
        product3 = new Products("Banana", "Fruit", 20);
        product4 = new Products("Potato", "Vegetables", 30);
        product5 = new Products("Ilsa", "Fish", 150);

        admin1.AddProducts(product1.Name, product1.Group, product1.Price);
        admin1.AddProducts(product2.Name, product2.Group, product2.Price);
        admin1.AddProducts(product3.Name, product3.Group, product3.Price);

        admin2.AddProducts(product1.Name, product1.Group, product1.Price);
        admin2.AddProducts(product2.Name, product2.Group, product2.Price);


        admin3.AddProducts(product1.Name, product1.Group, product1.Price);
        admin3.AddProducts(product2.Name, product2.Group, product2.Price);
        admin3.AddProducts(product3.Name, product3.Group, product3.Price);
        admin3.AddProducts(product1.Name, product1.Group, product1.Price);
        admin3.AddProducts(product2.Name, product2.Group, product2.Price);
    }

    @Test
    void ProductsItemsSizeIsThree() {
        assertEquals(3, admin1.productItems.size());
    }

    @Test
    void ProductsItemsSizeIsTwo() {
        assertEquals(6, admin2.productItems.size());
    }

    @Test
    void ProductsItemsSizeIsFive() {
        assertEquals(7, admin3.productItems.size());
    }

    @Test
    void viewProducts() {

        assertEquals(3, admin1.productItems.size());

        assertEquals("Apple", admin1.productItems.get(0).Name);
        assertEquals("Fruit", admin1.productItems.get(0).Group);
        assertEquals(6, admin1.productItems.get(0).Id);
        assertEquals(250, admin1.productItems.get(0).Price);
    }

    @Test
    void addProducts() {
        admin2.AddProducts(product1.Name, product1.Group, product1.Price);
        assertEquals(3, admin2.productItems.size());

        admin2.AddProducts(product2.Name, product2.Group, product2.Price);
        assertEquals(4, admin2.productItems.size());

        admin3.AddProducts(product3.Name, product3.Group, product3.Price);
        assertEquals(6, admin3.productItems.size());

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
        admin3.AddProducts(product2.Name, product2.Group, product2.Price);
        admin2.AddProducts(product3.Name, product3.Group, product3.Price);


        admin2.ModifyProducts(0,"Peanut", "Nut", 40);
        assertEquals("Peanut", admin2.productItems.get(0).Name);
        assertEquals("Nut", admin2.productItems.get(0).Group);
        assertEquals(40, admin2.productItems.get(0).Price);

        admin3.ModifyProducts(1,"OIL","Coconut",250);
        assertEquals("Apple",admin3.productItems.get(0).Name);
        assertEquals("Fruit",admin3.productItems.get(0).Group);
        assertEquals(250,admin3.productItems.get(0).Price);
    }
}