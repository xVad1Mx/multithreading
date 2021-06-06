package shipment.loader;

import shipment.Tunnel;
import shipment.ship.types.Ship;
import shipment.ship.types.Size;

import java.time.chrono.JapaneseEra;
import java.util.Random;

import static java.time.chrono.JapaneseEra.values;

public class ShipGenerator implements Runnable {
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count > shipCount) {
            Thread.currentThread().setName("Ship generator");
            count++;
            tunnel.add(new Ship(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private JapaneseEra getRandomType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}
