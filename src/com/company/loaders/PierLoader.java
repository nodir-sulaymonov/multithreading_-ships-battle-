package com.company.loaders;

import com.company.ships.Ship;
import com.company.ships.Type;
import com.company.tunel.TunelShip;

public class PierLoader implements Runnable {
    private TunelShip tunnel;
    private Type shipType;

    public PierLoader(TunelShip tunnel, Type shipType) {
        this.tunnel = tunnel;
        this.shipType =shipType;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Zagruzka" + shipType);
                Thread.sleep(500);
                Ship sh = tunnel.get(shipType);
                if(sh != null)
                while (sh.checkCount()) {
                    Thread.sleep(100);
                    sh.addCount(10);
                    System.out.println(sh.getCount() + "Zagruzka" + Thread.currentThread());
                }
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }



        }

    }
}

