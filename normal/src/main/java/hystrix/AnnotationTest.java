package hystrix;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lijs
 * on 2017/9/26.
 */
public class AnnotationTest {
    public static void main(String[] args) {
        String config = HelloWorldCommand.class.getPackage().getName().replace('.', '/') + "/spring-mvc.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
    }
}
