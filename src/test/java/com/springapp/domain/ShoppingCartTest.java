package com.springapp.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShoppingCartTest {

    private ApplicationContext context;
    private Product aaa;
    private Product bbb;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("beans.xml");
        bbb = (Product) context.getBean("bbb");
        aaa = (Product) context.getBean("aaa");
    }

    @Test
    public void should_not_initial_two_bean_with_singleton_scope() throws Exception {
        ShoppingCart shoppingCart1 = (ShoppingCart) context.getBean("shoppingCart");
        ShoppingCart shoppingCart2 = (ShoppingCart) context.getBean("shoppingCart");

        shoppingCart1.addItem(aaa);
        shoppingCart2.addItem(bbb);

        assertThat(shoppingCart1.getItemName(),is("AAA && BBB"));
        assertThat(shoppingCart2.getItemName(),is("AAA && BBB"));
    }

    @Test
    public void should_init_two_bean_with_prototype_scope() throws Exception {

        ShoppingCart shoppingCart1 = (ShoppingCart) context.getBean("prototypeShoppingCart");
        ShoppingCart shoppingCart2 = (ShoppingCart) context.getBean("prototypeShoppingCart");

        shoppingCart1.addItem(aaa);
        shoppingCart2.addItem(bbb);

        assertThat(shoppingCart1.getItemName(),is("AAA"));
        assertThat(shoppingCart2.getItemName(),is("BBB"));
    }
}
