package site.levimarvin.dev.gambit.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import site.levimarvin.dev.gambit.manager.GameManager;

import java.util.Arrays;

/**
 * @author Levi Marvin
 */
public class Debug implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can execute this!");
        }
        assert sender instanceof Player;
        Player player = (Player) sender;
        sender.sendMessage(Arrays.toString(player.getInventory().getArmorContents()));
        sender.sendMessage(
                "Boots_Type: " + player.getInventory().getBoots().getType() + "\n" +
                "Boots_Data: " + player.getInventory().getBoots().getData() + "\n" +
                "Boots_ItemMeta: " + player.getInventory().getBoots().getItemMeta() + "\n" +
                "PlayerInGame: " + GameManager.getManager().playerInGame
        );
        return true;
    }
}