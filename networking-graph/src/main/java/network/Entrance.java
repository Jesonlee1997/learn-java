package network;

import network.implByMatrix.MatrixNetworking;
import network.implByMatrix.PoissonStrategy;

/**
 * Created by lijs
 * on 2017/8/21.
 */
public class Entrance {
    public static void main(String[] args) {
        //Networking networking = new RandomNetWorking(100);
        Networking networking = new MatrixNetworking(50);
        NumberGenerateStrategy strategy = new PoissonStrategy(networking.size(), networking.size() * 2);

        networking.setStrategy(strategy);
        networking.init();
        networking.print();
    }
}
