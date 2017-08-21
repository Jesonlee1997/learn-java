package bank;

import java.util.Random;

/**
 * Created by lijs
 * on 2017/8/21.
 */
class RandomTools {
    private static final Random random = new Random();

    static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
