package network;

import network.implByMatrix.MatrixNetworking;

/**
 * Created by lijs
 * on 2017/8/21.
 */
public class Entrance {
    public static void main(String[] args) {
        //Networking networking = new RandomNetWorking(100);
        Networking networking = new MatrixNetworking(10);
        networking.init();
        networking.print();
    }
}
