package util;

import org.junit.Test;
import tool.GetPath;

/**
 * @Author lijs
 * @Create-time 2017/9/30.
 */
public class GetPathTest {
    @Test
    public void getClassPathOf() throws Exception {
        String path = GetPath.getClassPathOf(GetPath.class);
        System.out.println(path);
    }

}