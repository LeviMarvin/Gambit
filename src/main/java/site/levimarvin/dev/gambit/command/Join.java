package site.levimarvin.dev.gambit.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import site.levimarvin.dev.gambit.manager.GameManager;

/**
 * @author Levi Marvin
 */
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
                    if (GameManager.getManager().teamRed.containsPlayer(player) || GameManager.getManager().teamBlue.containsPlayer(player)) {
                        player.sendMessage("§cYou already in a Team!");
                    }
                    else {
                        GameManager.getManager().getTeam(1).joinTeam(player);
                        GameManager.getManager().redScoreBoard.setScoreboard(player);
                        player.sendMessage("§aYou have successfully join the RED Team!");
                        GameManager.getManager().joinGame(player, "red");

                    }
                    return true;
                case "blue":
                    if (
                            GameManager.getManager().teamRed.containsPlayer(player) ||
                            GameManager.getManager().teamBlue.containsPlayer(player)
                    ) {
                        player.sendMessage("§cYou already in a Team!");
                    }
                    else {
                        GameManager.getManager().getTeam(2).joinTeam(player);
                        GameManager.getManager().blueScoreBoard.setScoreboard(player);
                        player.sendMessage("§aYou have successfully join the BLUE Team!");
                        GameManager.getManager().joinGame(player, "blue");
                    }
                    return true;
                default:
                    player.sendMessage("§aThe \"red\" is §c§nRed Team§a.The \"blue\" is §1§nBlue Team§a.");
                    player.sendMessage("§cPlease use \"red\" or \"blue\".");
                    return true;
            }
        }
        else {
            player.sendMessage("§cPlease choose your team!");
        }
        return true;
    }
}