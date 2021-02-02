package site.levimarvin.dev.gambit;

import me.McVier3ck.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;
import site.levimarvin.dev.gambit.command.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author Levi_Marvin
 * @apiNote Minigame-Api 3.3.2
 */
public final class Gambit extends JavaPlugin {
    private static Gambit plugin;
    public static Gambit getPlugin() {
        return plugin;
    }
    public final static String PREFIX = "§e[§6Gambit§e]§f ";
    public final static String VERSION = "1.0-SNAPSHOT";

    public Config config;
    public Location arenaCenter;
    public Location teamRed;
    public Location teamBlue;

    HashMap<String, Class<?>> cmdMap = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aStarting...");
        printPluginInfo();
        try {
            initConfig();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        initCommand();
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§a加载完毕!");
    }

    private void initConfig() throws IOException, InvalidConfigurationException {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§a + 初始化配置文件...");
        config = new Config("config", "Gambit");
        File configFile = new File(getDataFolder() + "/config.yml");
        if (!configFile.exists()) saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§a |   读入内存...");
        config.getConfig().load(configFile);
        arenaCenter = config.getLocation("arenaCenter", true);
        teamRed = config.getLocation("teamRed", true);
        teamBlue = config.getLocation("teamBlue", true);
    }

    private void initCommand() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§a + 初始化命令...");
        cmdMap.put("gambit", Gambit.class);
        cmdMap.put("debug", Debug.class);
        cmdMap.put("menu", Menu.class);
        cmdMap.put("leave", Leave.class);
        cmdMap.put("join", Join.class);
        cmdMap.put("remove", Remove.class);
        cmdMap.put("create", Create.class);
        cmdMap.forEach((k, v) -> {
            CommandExecutor CE = null;
            try {
                CE = (CommandExecutor) v.getDeclaredConstructor().newInstance();
            } catch (
                    InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e
            ) {
                e.printStackTrace();
            }
            Bukkit.getConsoleSender().sendMessage(PREFIX + "§a |  注册命令：" + k);
            Bukkit.getPluginCommand(k + "").setExecutor(CE);
        });
    }

    private void printPluginInfo() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§e+§6====================§e+");
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§6§lName: Gambit");
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§6§lVersion: " + VERSION);
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§6§lAuthor: Levi_Marvin");
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§e+§6====================§e+");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aClosing...");
    }

}
