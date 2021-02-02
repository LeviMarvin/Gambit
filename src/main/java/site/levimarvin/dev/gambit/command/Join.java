package site.levimarvin.dev.gambit.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import site.levimarvin.dev.gambit.manager.GameManager;

public class Join implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly player can execute this!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "red":
                    GameManager.getManager().getTeam(1).joinTeam(player);
                case "blue":
                    GameManager.getManager().getTeam(2).joinTeam(player);
                default:
                    GameManager.getManager().getTeam(1).joinTeam(player);
            }
        }
        else {
            player.sendMessage("§cThis command must have option!");
        }
        return true;
    }
}