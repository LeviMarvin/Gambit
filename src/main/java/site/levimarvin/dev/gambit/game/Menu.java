package site.levimarvin.dev.gambit.game;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @author Levi Marvin
 */
public class Menu {
    static Player player;
    static Inventory menu = Bukkit.createInventory(player, 3*9, "§l§6Gambit");
    ItemStack item_fence = new ItemStack(Material.IRON_FENCE);

    public Menu() {
        item_fence.getItemMeta().setDisplayName("边框");
        item_fence.setItemMeta(item_fence.getItemMeta());
        for (int i = 1; i <= 10; i++) {
            menu.setItem(i, item_fence);
        }
        for (int i = 18; i <= 28; i++) {
            menu.setItem(i, item_fence);
        }
    }

    public static void openMenu(Player player) {
        player.openInventory(menu);
    }
}
