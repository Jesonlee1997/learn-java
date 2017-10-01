package hystrix;

import com.netflix.hystrix.*;

import java.util.concurrent.Future;

public class HelloWorldCommand extends HystrixCommand<String> {
    private final String name;
    public HelloWorldCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"))
                /* 配置依赖超时时间,500毫秒*/
                .andCommandKey(HystrixCommandKey.Factory.asKey("HelloWorldKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("hello world pool"))
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                        .withCoreSize(200)
                )
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)
                        .withCircuitBreakerRequestVolumeThreshold(3)
                        .withCircuitBreakerSleepWindowInMilliseconds(2000)
                        .withCircuitBreakerErrorThresholdPercentage(80)
                        .withExecutionTimeoutInMilliseconds(100)
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)

                )
        );
        this.name = name;
    }

    @Override
    protected String getFallback() {
        return "exeucute Falled";
    }
    @Override
    protected String run() throws Exception {
        //sleep 1 秒,调用会超时
        //TimeUnit.MILLISECONDS.sleep(1000);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            StringBuilder builder = new StringBuilder();


        }
        return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }


    public static void main(String[] args) throws Exception{
        HelloWorldCommand command = new HelloWorldCommand("test-Fallback");
        long start = System.currentTimeMillis();
        command.execute();
        Future<String> result = command.queue();
        String s = result.get();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(s);
        System.in.read();


    }
}