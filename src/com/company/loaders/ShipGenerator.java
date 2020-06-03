package com.company.loaders;

import com.company.ships.Ship;
import com.company.ships.Size;
import com.company.ships.Type;
import com.company.tunel.TunelShip;

import java.util.Random;

public class ShipGenerator implements Runnable {

    private int counterShip;
    private TunelShip tunelShip;

    public ShipGenerator(int counterShip, TunelShip tunelShip) {
        this.counterShip = counterShip;
        this.tunelShip = tunelShip;
    }

    @Override
    public void run() {
        int iter = 0;
        do {
            Thread.currentThread().setName("Converter vessel");
            iter++;
            tunelShip.ShipAdd(new Ship(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (iter < counterShip);
    }

    //вспомогательные методы для генерации кораблей.
    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}


