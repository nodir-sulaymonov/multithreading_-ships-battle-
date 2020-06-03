package com.company.ships;


public class Ship extends Thread {
    private int count;
    private Size size;
    private Type type;

    public Ship(Size size, Type type) {
        this.size = size;
        this.type = type;
    }

    public void addCount(int count){
        this.count = count;
    }

    public boolean checkCount(){
        if (count >= size.getValue()) {
            return false;
        }
        return true;
    }

    public int getCount() {
        return count;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }
}
