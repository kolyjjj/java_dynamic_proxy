package me.koly;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalProxyInvoker implements InvocationHandler {
    private Cat cat;

    public AnimalProxyInvoker(Cat cat) {

        this.cat = cat;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---proxy start--");
        long startTime = System.currentTimeMillis();
        Object ret = method.invoke(cat, args);
        System.out.println("time spent is: " + (System.currentTimeMillis() - startTime));
        return ret;
    }
}
