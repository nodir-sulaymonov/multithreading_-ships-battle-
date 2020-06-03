package com.company.tunel;

import com.company.ships.Ship;
import com.company.ships.Type;

import java.util.ArrayList;
import java.util.List;

public class TunelShip {

    private static final int shipInTunMin = 0;
    private static final int shipInTunMax = 5;
    private int counterShip;
    private List<Ship> sklad;

    public TunelShip(){
        sklad = new ArrayList<>();
    }

    public synchronized boolean ShipAdd(Ship ship){

        try {
            if(counterShip < shipInTunMax){
                notifyAll();
                sklad.add(ship);
                System.out.println(sklad.size() + " Sudna come back: " + " | " + ship.getType()+ " | " + ship.getSize()+ " | " + Thread.currentThread().getName());
            }
            else {
                wait();
                return false;
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        return true;
    }
    public synchronized Ship get(Type shipType){
        try {
            if(counterShip > shipInTunMin){
                notifyAll();
                for (Ship sh: sklad){
                    if (sh.getType() == shipType){
                        counterShip--;
                        String str = Thread.currentThread().getName();
                        System.out.println(sklad.size()+"Ship get from Tunel" + str);
                        sklad.remove(sh);
                        return sh;
                    }
                }
            }
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
