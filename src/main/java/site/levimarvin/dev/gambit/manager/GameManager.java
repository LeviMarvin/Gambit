package site.levimarvin.dev.gambit.manager;

import me.McVier3ck.arena.Arena;
import me.McVier3ck.scoreboard.CustomScoreboard;
import me.McVier3ck.team.Team;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import site.levimarvin.dev.gambit.Gambit;

import java.util.HashMap;

/**
 * @author Levi Marvin
 */
public class GameManager {
    private static GameManager manager;
    public static GameManager getManager() {
        if (manager == null) {
            manager = new GameManager();
        }
        return manager;
    }

    public final static String RED = "red";
    public final static String BLUE = "blue";

    public Arena arena;
    public Team teamRed;
    public Team teamBlue;
    public CustomScoreboard redScoreBoard;
    public CustomScoreboard blueScoreBoard;
    public CustomScoreboard defaultScoreBoard;
    //public MotoWarehouse redWarehouse;
    //public MotoWarehouse blueWarehouse;
    public HashMap<Team, Integer> teamRedMoteNumber = new HashMap<>();
    public HashMap<Team, Integer> teamBlueMoteNumber = new HashMap<>();
    public boolean playerInGame;
    public boolean invaderExist;
    public boolean collectorExist;
    public boolean sentryExist;
    public String occupation;

    //public GameManager () {}

    public Arena getArena() {
        return this.arena;
    }

    /**
     * @param id int, "1" is red team; "2" is blue team.
     * @return Team
     */
    public Team getTeam(int id) {
        switch (id) {
            case 1:
                return this.teamRed;
            case 2:
                return this.teamBlue;
            default:
                return null;
        }
    }

    public void initGame() {
        Gambit.getPlugin().getServer().getConsoleSender().sendMessage(Gambit.PREFIX + "§a + 初始化游戏...");
        //Init team
        Bukkit.getConsoleSender().sendMessage(Gambit.PREFIX + "§a |   注册队伍：");
        Bukkit.getConsoleSender().sendMessage(Gambit.PREFIX + "§a |     注册红队...");
        teamRed = new Team("红队");
        teamRed.setMinSize(4);
        teamRed.setMaxSize(4);
        teamRed.setColor(ChatColor.DARK_GRAY);
        teamRed.setSpawn(Gambit.getPlugin().teamRedLocation);
        Bukkit.getConsoleSender().sendMessage(Gambit.PREFIX + "§a |     注册蓝队...");
        teamBlue = new Team("蓝队");
        teamBlue.setMinSize(4);
        teamBlue.setMaxSize(4);
        teamBlue.setColor(ChatColor.DARK_GRAY);
        teamBlue.setSpawn(Gambit.getPlugin().teamBlueLocation);
        //Init Scoreboard
        Gambit.getPlugin().getServer().getConsoleSender().sendMessage(Gambit.PREFIX + "§a + 初始化计分板...");
        defaultScoreBoard = new CustomScoreboard("", DisplaySlot.SIDEBAR);
        redScoreBoard = new CustomScoreboard("计分板 - §c红队", DisplaySlot.SIDEBAR);
        redScoreBoard.setScore("TESTSCORE", 0);
        redScoreBoard.setScoreboard(teamRed);
        blueScoreBoard = new CustomScoreboard("计分板 - §1蓝队", DisplaySlot.SIDEBAR);
        blueScoreBoard.setScore("TESTSCORE", 0);
        blueScoreBoard.setScoreboard(teamBlue);
    }

    public void joinGame(Player player, String team) {
        playerInGame = true;
        if (RED.equals(team)) {
            //TODO teleport
            player.teleport(teamRed.getSpawn());
            //open menu
        }
        else if (BLUE.equals(team)){
            //TODO teleport
            player.teleport(teamBlue.getSpawn());
            //open menu
        }
    }
}
