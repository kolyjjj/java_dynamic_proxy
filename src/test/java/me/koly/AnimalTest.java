package me.koly;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class AnimalTest {
    @Test
    public void should_test() {
        Animal cat = new Cat();
//        Animal catProxy = (Animal)Proxy.newProxyInstance(Animal.class.getClassLoader(), Animal.class.getInterfaces(), new AnimalProxyInvoker(cat));
        Animal catProxy = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, new AnimalProxyInvoker(cat));
        System.out.println(catProxy.run());

    }

    @Test
    public void should_use_lambda() {
        Animal cat = new Cat();
        Animal animalProxy = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, (proxy, method, args) -> {
            System.out.println("---proxy start--");
            long startTime = System.currentTimeMillis();
            Object ret = method.invoke(cat, args);
            System.out.println("time spent is: " + (System.currentTimeMillis() - startTime));
            return ret;
        });
        System.out.println(animalProxy.run());
    }
}
