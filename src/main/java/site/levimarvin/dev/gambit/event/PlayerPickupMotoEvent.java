package site.levimarvin.dev.gambit.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import site.levimarvin.dev.gambit.game.entity.Moto;

public class PlayerPickupMotoEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Moto moto;
    private boolean cancelledFlag = false;
    private final int remaining;

    public PlayerPickupMotoEvent(Player player, Moto moto, int remaining) {
        super(player);
        this.moto = moto;
        this.remaining = remaining;
    }

    public Moto getMoto() {
        return this.moto;
    }

    public int getRemaining() {
        return this.remaining;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelledFlag;
    }

    @Override
    public void setCancelled(boolean cancelledFlag) {
        this.cancelledFlag = cancelledFlag;
    }
}
