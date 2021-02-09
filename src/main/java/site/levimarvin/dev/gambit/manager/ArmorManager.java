package site.levimarvin.dev.gambit.manager;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import site.levimarvin.dev.gambit.Gambit;
import site.levimarvin.dev.gambit.game.Occupation;

import java.util.ArrayList;
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
    List<String> invaderHelmetLore = new ArrayList<>();
    List<String> collectorHelmetLore = new ArrayList<>();
    List<String> reaperHelmetLore = new ArrayList<>();
    List<String> sentryHelmetLore = new ArrayList<>();
    /**
     * metas.
     */
    public LeatherArmorMeta invaderHelmetMeta =
            (LeatherArmorMeta) new ItemStack(Material.LEATHER_HELMET).getItemMeta();
    public LeatherArmorMeta collectorHelmetMeta =
            (LeatherArmorMeta) new ItemStack(Material.LEATHER_HELMET).getItemMeta();
    public LeatherArmorMeta reaperHelmetMeta =
            (LeatherArmorMeta) new ItemStack(Material.LEATHER_HELMET).getItemMeta();
    public LeatherArmorMeta sentryHelmetMeta =
            (LeatherArmorMeta) new ItemStack(Material.LEATHER_HELMET).getItemMeta();
    public LeatherArmorMeta chestplateMeta =
            (LeatherArmorMeta) new ItemStack(Material.LEATHER_CHESTPLATE).getItemMeta();
    public LeatherArmorMeta leggingsMeta =
            (LeatherArmorMeta) new ItemStack(Material.LEATHER_LEGGINGS).getItemMeta();
    public LeatherArmorMeta bootsMeta =
            (LeatherArmorMeta) new ItemStack(Material.LEATHER_BOOTS).getItemMeta();
    private boolean initialized = false;

    public void giveArmor(Player player) {
        switch (Occupation.getOccupation().getPlayerOccupation()) {
            case "Invader":
                player.getInventory().setHelmet(invaderHelmet);
            case "Collector":
                player.getInventory().setHelmet(invaderHelmet);
            case "Reaper":
                player.getInventory().setHelmet(invaderHelmet);
            case "Sentry":
                player.getInventory().setHelmet(invaderHelmet);
            default:
                player.getInventory().setHelmet(invaderHelmet);
        }
        player.getInventory().setChestplate(chestplate);
        player.getInventory().setLeggings(leggings);
        player.getInventory().setBoots(boots);
    }

    public void initArmor() {
        Gambit.getPlugin().getServer().getConsoleSender().sendMessage(Gambit.PREFIX + "§a + 初始化装备...");
        preInit();
        invaderHelmet.setItemMeta(invaderHelmetMeta);
        collectorHelmet.setItemMeta(collectorHelmetMeta);
        reaperHelmet.setItemMeta(reaperHelmetMeta);
        sentryHelmet.setItemMeta(sentryHelmetMeta);
        chestplate.setItemMeta(chestplateMeta);
        leggings.setItemMeta(leggingsMeta);
        boots.setItemMeta(bootsMeta);
        initialized = true;
    }

    private void preInit() {
        Bukkit.getConsoleSender().sendMessage(Gambit.PREFIX + "§a |   处理数据...");
        //Lore
        invaderHelmetLore.add("Invader");
        collectorHelmetLore.add("Collector");
        reaperHelmetLore.add("Reaper");
        sentryHelmetLore.add("Sentry");
        //MetaData
        setArmorMeta(invaderHelmetMeta, true,
                "Invader", "Invader",
                invaderHelmetLore);
        setArmorMeta(collectorHelmetMeta, true,
                "Collector", "Collector",
                collectorHelmetLore);
        setArmorMeta(reaperHelmetMeta, true,
                "Reaper", "Reaper",
                invaderHelmetLore);
        setArmorMeta(sentryHelmetMeta, true,
                "Sentry", "Sentry",
                sentryHelmetLore);
        setArmorMeta(chestplateMeta, true,
                "Chest", "Chest", null);
        setArmorMeta(leggingsMeta, true,
                "Leggings", "Leggings", null);
        setArmorMeta(bootsMeta, true,
                "Boots", "Boots", null);
    }

    /**
     * @param itemMeta LeatherArmorMeta - The changed armor meta.
     * @param unbreakable boolean - true or false.
     * @param displayName String - Display name.
     * @param localName String - Localized Name.
     * @param lore List<String> - The item's lore.
     */
    //@Deprecated
    public void setArmorMeta(LeatherArmorMeta itemMeta, boolean unbreakable,
                             String localName, String displayName, List<String> lore) {
        itemMeta.setUnbreakable(unbreakable);
        itemMeta.setLocalizedName(localName);
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
    }


    /**
     * @param itemMeta LeatherArmorMeta - The changed armor meta.
     * @param unbreakable boolean - true or false.
     * @param displayName String - Display name.
     * @param localName String - Localized Name.
     * @param lore List<String> - The item's lore.
     * @param color Color - The item's color.
     */
    /*
    public void setArmorMeta(LeatherArmorMeta itemMeta, boolean unbreakable,
                             String localName, String displayName, List<String> lore, Color color) {
        itemMeta.setUnbreakable(unbreakable);
        itemMeta.setLocalizedName(localName);
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemMeta.setColor(color);
    }
*/
    /**
     * @param itemMeta LeatherArmorMeta - The changed armor meta.
     * @param unbreakable boolean - true or false.
     * @param displayName String - Display name.
     * @param localName String - Localized Name.
     * @param lore List<String> - The item's lore.
     * @param color Color - The item's color.
     * @param enchantment Enchantment - The item's enchantment.
     * @param enchantmentLevel int - The enchantment's level.
     * @param ignoreLevelRestriction boolean - This indicates the enchantment should be applied,
     *                              ignoring the level limit.
     */
    /*
    public void setArmorMeta(LeatherArmorMeta itemMeta, boolean unbreakable,
                             String localName, String displayName, List<String> lore,
                             Color color,
                             Enchantment enchantment, int enchantmentLevel, boolean ignoreLevelRestriction) {
        itemMeta.setUnbreakable(unbreakable);
        itemMeta.setLocalizedName(localName);
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemMeta.setColor(color);
        itemMeta.addEnchant(enchantment, enchantmentLevel, ignoreLevelRestriction);
    }
*/
}
