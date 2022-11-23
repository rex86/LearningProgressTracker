package tracker;

import tracker.modes.ModeChanger;
import tracker.modes.TopLevelMode;

public class Main {
    private static String command = "";

    public static void main(String[] args) {
        System.out.println("Learning Progress Tracker");
        new ModeChanger().run(new TopLevelMode(),"topLevel");

    }

}

