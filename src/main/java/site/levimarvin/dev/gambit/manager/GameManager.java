package site.levimarvin.dev.gambit.manager;

import me.McVier3ck.arena.Arena;
import me.McVier3ck.team.Team;

public class GameManager {
    private static GameManager manager;
    public static GameManager getManager() {
        if (manager == null) manager = new GameManager();
        return manager;
    }

    public Arena arena;
    public Team teamRed;
    public Team teamBlue;

    public GameManager () {}

    public GameManager (Arena arena, Team teamRed, Team teamBlue) {
        this.arena = arena;
        this.teamRed = teamRed;
        this.teamBlue = teamBlue;
    }

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
}
