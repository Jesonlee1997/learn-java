package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hdfs工具类
 * Created by JesonLee
 * on 2017/4/15.
 */
public class HdfsUtils {
    private FileSystem fileSystem;

    public HdfsUtils(String url){
        try {
            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", url);
            fileSystem = FileSystem.get(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //列举目录下面的孩子节点
    public void list(String fileName) throws IOException {
        Path path = new Path(fileName);
        FileStatus[] statuses = fileSystem.listStatus(path);
        for (FileStatus status : statuses) {

            System.out.println((status.isDirectory() ? "DirectoryName: " : " filename: ")
                    + status.getPath().getName()
                    + "  permission: " + status.getPermission()
                    + "  replication: " + status.getReplication());
        }
    }

    //打印文本文件
    public void text(String fileName) throws IOException {
        InputStream inputStream = fileSystem.open(new Path(fileName));
        IOUtils.copyBytes(inputStream, System.out, 4096, true);
    }

    /**
     * 上传文件
     * @param src 本地的文件路径
     * @param dest hdfs上的路径
     */
    public boolean put(String src, String dest){
        src = convertPath(src);
        try {
            InputStream inputStream = new FileInputStream(src);
            if (fileSystem.exists(new Path(dest))){
                System.out.println("该文件已存在");
                return false;
            }
            FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path(dest), true);
            IOUtils.copyBytes(inputStream, fsDataOutputStream, 4096, true);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //删除文件
    public boolean delete(String fileName) throws IOException {
        return fileSystem.delete(new Path(fileName), true);
    }

    //创建文件夹
    public boolean makeDir(String dirName) throws IOException {
        Path path = new Path(dirName);
        if (fileSystem.exists(path)) {
            path = new Path(dirName + "-副本");
        }
        return fileSystem.mkdirs(path);
    }

    //创建文件夹
    public boolean makeDir(String dirName, boolean override) throws IOException {
        if (override)
            return fileSystem.mkdirs(new Path(dirName));
        return makeDir(dirName);
    }

    private String convertPath(String classPath) {
        if (classPath.startsWith("classpath:")) {
            return classPath.replace("classpath:", HdfsUtils.class.getResource("/").getPath());
        } else {
            return classPath;
        }
    }
}
