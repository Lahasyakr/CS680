package edu.umb.cs680.hw03;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class SingletonDemoTest {
    @Test
	public void singleTonInstanceNotNull() {
		SingletonDemo instance1 = SingletonDemo.getInstance();
		Assertions.assertNotNull(instance1);
	}

	@Test
	public void singleTonMultipleInstanceNotNull() {
		SingletonDemo instance1 = SingletonDemo.getInstance();
        SingletonDemo instance2 = SingletonDemo.getInstance();
		Assertions.assertNotNull(instance1);
		Assertions.assertNotNull(instance2);
	}

    @Test
	public void SingletonDemoClassTestwith2instances() {
		SingletonDemo instance1 = SingletonDemo.getInstance();
        SingletonDemo instance2 = SingletonDemo.getInstance();
       	assertEquals(instance1.hashCode(), instance2.hashCode());
	}

	@Test
	public void SingletonDemoClassTestwithmultipleinstances() {
		SingletonDemo instance1 = SingletonDemo.getInstance();
        SingletonDemo instance2 = SingletonDemo.getInstance();
       	assertSame(instance1, instance2);
	}
	@Test
    public void testSingleton() {
         
        SingletonDemo instance1 = SingletonDemo.getInstance();
        SingletonDemo instance2 = SingletonDemo.getInstance();
        System.out.println("checking singleton objects equality");
        assertEquals(true, instance1==instance2);
    }
}
