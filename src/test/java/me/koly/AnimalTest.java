package me.koly;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class AnimalTest {
    @Test
    public void should_test() {
        Cat cat = new Cat();
//        Animal catProxy = (Animal)Proxy.newProxyInstance(Animal.class.getClassLoader(), Animal.class.getInterfaces(), new AnimalProxyInvoker(cat));
        Animal catProxy = (Animal)Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, new AnimalProxyInvoker(cat));
        System.out.println(catProxy.run());

    }
}
