package site.levimarvin.dev.gambit.game;

import site.levimarvin.dev.gambit.manager.GameManager;

/**
 * @author Levi Marvin
 */
public class Occupation {
    private static Occupation instance;
    public static Occupation getOccupation() {
        if (instance == null) {
            instance = new Occupation();
        }
        return instance;
    }

    public String helmetName;

    public String getPlayerOccupation() {
        if (GameManager.getManager().playerInGame) {
            //Invader
            if (helmetName.equals("Invader")) {
                return "Invader";
            }
            //Collector
            if (helmetName.equals("Collector")) {
                return "Collector";
            }
            //Reaper
            if (helmetName.equals("Reaper")) {
                return "Reaper";
            }
            //Sentry
            if (helmetName.equals("Sentry")) {
                return "Sentry";
            }
        } else {
            if (GameManager.getManager().occupation.equals("invader")) {
                return "Invader";
            }
            if (GameManager.getManager().occupation.equals("collector")) {
                return "Collector";
            }
            if (GameManager.getManager().occupation.equals("reaper")) {
                return "Reaper";
            }
            if (GameManager.getManager().occupation.equals("sentry")) {
                return "Sentry";
            }
        }
        return null;
    }
}
