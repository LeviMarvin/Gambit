package site.levimarvin.dev.gambit.game;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public interface Moto extends Entity {
    ItemStack getItemStack();

    void setItemStack(ItemStack var1);

    int getPickupDelay();

    void setPickupDelay(int var1);
}
