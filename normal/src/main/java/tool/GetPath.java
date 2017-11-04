package tool;

import java.io.InputStream;

/**
 * @Author lijs
 * @Create-time 2017/9/30.
 */
public class GetPath {
    public static String getClassPathOf(Class<?> clazz) {
        String path = clazz.getPackage().getName().replace('.', '/');
        return path;
    }

    public static InputStream getResourceOf(Class<?> clazz, String resourceName) {
        resourceName = resourceName.startsWith("/") ? resourceName : "/" + resourceName;
        String path ="/" + GetPath.getClassPathOf(clazz) + resourceName;
        return clazz.getResourceAsStream(path);
    }
}
