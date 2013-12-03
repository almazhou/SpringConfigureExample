package com.springapp.mvc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ApplicationTextTest {

    @Test
    public void testApplicationContext() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SequenceGenerator generator = (SequenceGenerator)context.getBean("sequenceGenerator");
        System.out.println(generator.getSequence());
        assertThat(generator.getSequence(),is("123456A"));
        System.out.println(SequenceGenerator.class.getResource("/"));
    }

    @Test
    public void testFileSystemXmlApplicationContext() throws Exception {
        String [] locations = {"classpath:bean1.xml","classpath:bean2.xml"};
        FileSystemXmlApplicationContext fileContext = new FileSystemXmlApplicationContext(locations);
        TestOne bean1 = (TestOne)fileContext.getBean("beanOne");
        TestTwo bean2 = (TestTwo)fileContext.getBean("beanTwo");
        assertThat(bean1.getSequence(),is(1));
        assertThat(bean2.getSequence(),is(2));
        System.out.println(TestOne.class.getResource(""));
        System.out.println(TestOne.class.getResource("/"));
    }


}
