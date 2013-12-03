package com.springapp.domain;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CashierTest {
    @Test
    public void should_write_content_into_files() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Cashier cashier = (Cashier)context.getBean("cashier");
        ShoppingCart shoppingCart = (ShoppingCart) context.getBean("prototypeShoppingCart");
        Product aaa = (Product) context.getBean("aaa");
        Product bbb = (Product) context.getBean("bbb");
        shoppingCart.addItem(aaa);
        shoppingCart.addItem(bbb);
        cashier.checkout(shoppingCart);

    }
}
