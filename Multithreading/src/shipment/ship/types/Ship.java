package shipment.ship.types;

import java.lang.reflect.Type;
import java.time.chrono.JapaneseEra;

public class Ship {
    private int count;
    private Size size;
    private Type type;

    public Ship(int count, Size size, Type type) {
        this.count = count;
        this.size = size;
        this.type = type;
    }

    public Ship(Size randomSize, JapaneseEra randomType) {
    }


    public int getCountNew() {
        return count;
    }

    public void new(){

    }

    public boolean oneMoreNew(){
        return true;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    public boolean countCheck() {
        if (count >= size.getValue()) {
            return false;
        }
        return true;
    }
}
