package network;

import network.implByMatrix.MatrixNetworking;
import network.implByMatrix.PoissonStrategy2;

/**
 * Created by lijs
 * on 2017/8/21.
 */
public class Entrance {
    public static void main(String[] args) {
        //Networking networking = new RandomNetWorking(100);
        Networking networking = new MatrixNetworking(500);
        NumberGenerateStrategy strategy = new PoissonStrategy2(networking.size(), networking.size() * 2);

        networking.setStrategy(strategy);
        networking.init();
        networking.print();
    }
}
