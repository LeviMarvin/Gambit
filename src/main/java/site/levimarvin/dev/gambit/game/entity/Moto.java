package site.levimarvin.dev.gambit.game.entity;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Moto extends ItemStack {
    public ItemStack Moto(int amount) {
        return new ItemStack(Material.GLOWSTONE_DUST, amount, (short) 1);
    }
}
