package com.longwo.econ.interbank.contagion.network;

import com.longwo.econ.interbank.contagion.network.implByMatrix.MatrixNetworking;
import com.longwo.econ.interbank.contagion.network.implByMatrix.PoissonStrategy2;

/**
 * Created by lijs
 * on 2017/8/21.
 */
public class Entrance {
    public static void main(String[] args) {
        //Networking networking = new RandomNetWorking(100);
        Networking matrixnetworking = new MatrixNetworking(110);
        NumberGenerateStrategy poissonstrategy = new PoissonStrategy2(matrixnetworking.size(), matrixnetworking.size() * 2);

        matrixnetworking.setStrategy(poissonstrategy);
        matrixnetworking.init();
        matrixnetworking.print();
    }
}
