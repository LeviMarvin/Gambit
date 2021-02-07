package site.levimarvin.dev.gambit.game;

import org.bukkit.Location;

/**
 * @author Levi Marvin
 */
public class MotoWarehouse {
    public Moto moto;
    public Location location;
    public MotoWarehouse(Moto moto, Location location) {
        this.moto = moto;
        this.location = location;
    }

    public MotoWarehouse getMotoWarehouse() {
        return this;
    }

    public void setMotoWarehouse(Location location) {
        this.location = location;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
}
