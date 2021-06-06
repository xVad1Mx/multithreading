package shipment;

import shipment.loader.PierLoader;
import shipment.loader.ShipGenerator;
import shipment.ship.types.Types;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();
        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 10);

        PierLoader pierLoaderForBread = new PierLoader(tunnel, Types.BREAD);
        PierLoader pierLoaderForBananas = new PierLoader(tunnel, Types.BANANAS);
        PierLoader pierLoaderForClothes = new PierLoader(tunnel, Types.CLOTHES);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(shipGenerator);
        service.execute(pierLoaderForBread);
        service.execute(pierLoaderForBananas);
        service.execute(pierLoaderForClothes);

        service.shutdown();
    }
}