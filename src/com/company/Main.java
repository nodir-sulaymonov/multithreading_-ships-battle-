package com.company;

import com.company.loaders.PierLoader;
import com.company.loaders.ShipGenerator;
import com.company.ships.Type;
import com.company.tunel.TunelShip;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        TunelShip tunnel = new TunelShip();

        ShipGenerator shipGenerator = new ShipGenerator(10, tunnel);

        PierLoader pierLoader1 = new PierLoader(tunnel, Type.DRESS);
        PierLoader pierLoader2 = new PierLoader(tunnel, Type.BANANA);
        PierLoader pierLoader3 = new PierLoader(tunnel, Type.MEAL);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator);
        service.execute(pierLoader1);
        service.execute(pierLoader2);
        service.execute(pierLoader3);

        service.shutdown();

    }
}
