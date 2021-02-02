package site.levimarvin.dev.gambit.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class ArmorEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Player player;

    public ArmorEvent (Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isInvader() {
        return false;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    private boolean isWho() {

        return false;
    }
}
