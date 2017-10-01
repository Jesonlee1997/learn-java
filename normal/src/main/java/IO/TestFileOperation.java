package IO;

import java.io.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lijs
 * on 2017/8/24.
 */
public class TestFileOperation {
    public static void main(String[] args) throws IOException {
        ReentrantLock lock = new ReentrantLock();
        Condition readCondition = lock.newCondition();

        String path = "J:\\Java\\projects\\learn-java\\src\\main\\java\\IO\\test.dat";
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sdf");
                lock.lock();
                try {
                    writer.write("count:" + count++ + "\n");
                    writer.flush();
                    readCondition.signal();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            String line;
            while (true) {
                lock.lock();
                try {
                    while ((line = reader.readLine()) == null) {
                        readCondition.await();
                    }
                    System.out.println(line);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
