package site.levimarvin.dev.gambit.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import site.levimarvin.dev.gambit.manager.GameManager;

/**
 * @author Levi Marvin
 */
public class Leave implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly player can execute this!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (GameManager.getManager().teamRed.containsPlayer(player)) {
                GameManager.getManager().teamRed.leaveTeam(player);
                GameManager.getManager().defaultScoreBoard.setScoreboard(player);
                GameManager.getManager().playerInGame = false;
                player.sendMessage("§aYou have successfully left the red team!");
            }
            else if (GameManager.getManager().teamBlue.containsPlayer(player)) {
                GameManager.getManager().teamBlue.leaveTeam(player);
                GameManager.getManager().defaultScoreBoard.setScoreboard(player);
                GameManager.getManager().playerInGame = false;
                player.sendMessage("§aYou have successfully left the blue team!");
            }
            else {
                player.sendMessage("§cYou have not join any team!");
            }
        }
        else {
            player.sendMessage("§cThis command NOT need any option!");
        }
        return true;
    }
}