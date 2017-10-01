package concurrent.sync;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by JesonLee
 * on 2017/5/3.
 */
public class TestProxy {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        LogHandler logHandler = new LogHandler(calculator);
        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                logHandler);
        proxy.add(1, 1);
    }

    interface Calculator {
        void add(int a, int b);
    }

    static class CalculatorImpl implements Calculator {

        @Override
        public void add(int a, int b) {
            return;
        }
    }

    static class LogHandler implements InvocationHandler {
        Object object;

        public LogHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            this.doBefore();
            Object o = method.invoke(object, args);
            this.doAfter();
            return o;
        }

        public void doBefore() {
            System.out.println("do this before");
        }
        public void doAfter() {
            System.out.println("do this after");
        }
    }
}
