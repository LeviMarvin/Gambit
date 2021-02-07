package site.levimarvin.dev.gambit.manager;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import site.levimarvin.dev.gambit.Gambit;

import java.util.List;

/**
 * @author Levi Marvin
 */
public class ArmorManager {
    private static ArmorManager manager;
    public static ArmorManager getManager() {
        if (manager == null) {
            manager = new ArmorManager();
        }
        return manager;
    }
    /**
     * Occupations' helmets.
     */
    public ItemStack invaderHelmet = null;
    public ItemStack collectorHelmet = null;
    public ItemStack reaperHelmet = null;
    public ItemStack sentryHelmet = null;
    /**
    * Other armor.
    */
    public ItemStack chestplate = null;
    public ItemStack leggings = null;
    public ItemStack boots = null;
    /**
     * helmets' lore.
     */
    List<String> invaderHelmetLore;
    List<String> collectorHelmetLore;
    List<String> reaperHelmetLore;
    List<String> sentryHelmetLore;
    /**
     * helmets' meta.
     */
    ItemMeta invaderHelmetMeta;
    ItemMeta collectorHelmetMeta;
    ItemMeta reaperHelmetMeta;
    ItemMeta sentryHelmetMeta;

    public void initArmor() {
        Gambit.getPlugin().getServer().getConsoleSender().sendMessage(Gambit.PREFIX + "§a + 初始化装备...");
        preInit();
    }

    private void preInit() {
        //Lore
        invaderHelmetLore.add("Invader");
        collectorHelmetLore.add("Collector");
        reaperHelmetLore.add("Reaper");
        sentryHelmetLore.add("Sentry");
        //MetaData
        invaderHelmetMeta.setUnbreakable(true);
        invaderHelmetMeta.setLocalizedName("Invader");
        invaderHelmetMeta.setLore(invaderHelmetLore);
        invaderHelmetMeta.addEnchant(Enchantment.MENDING, 1, true);
    }

}
