package hdfs;

import org.junit.Test;

/**
 * Created by JesonLee
 * on 2017/4/15.
 */
public class HdfsUtilsTest {
    private HdfsUtils hdfsUtils = new HdfsUtils("hdfs://192.168.56.100:9000");

    @Test
    public void list() throws Exception {
        hdfsUtils.list("/java");
    }

    @Test
    public void text() throws Exception {
        hdfsUtils.text("/hello.text");
    }

    @Test
    public void put() throws Exception {
        hdfsUtils.put("classpath:test.xml", "/test.xml");
    }

    @Test
    public void delete() throws Exception {
        hdfsUtils.delete("/input");
    }

    @Test
    public void makeDir() throws Exception {
        hdfsUtils.makeDir("/java");
        hdfsUtils.makeDir("/java/javase");
    }

    @Test
    public void convertPath() throws Exception {
        String classPath = "classpath:HDfsUtils.java";
        //System.out.println(HdfsUtils.convertPath(classPath));
    }

}