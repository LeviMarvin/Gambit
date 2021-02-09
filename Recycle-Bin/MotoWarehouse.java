package site.levimarvin.dev.gambit.game;

import org.bukkit.Location;

/**
 * @author Levi Marvin
 */
public class MotoWarehouse {
    public Moto1 moto;
    public Location location;
    public MotoWarehouse(Moto1 moto, Location location) {
        this.moto = moto;
        this.location = location;
    }

    public MotoWarehouse getMotoWarehouse() {
        return this;
    }

    public void setMotoWarehouse(Location location) {
        this.location = location;
    }

    public void setMoto(Moto1 moto) {
        this.moto = moto;

    }
}
