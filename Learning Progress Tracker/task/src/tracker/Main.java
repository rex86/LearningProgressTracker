package tracker;

import tracker.modes.ModeChanger;
import tracker.modes.TopLevelMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static String command = "";

    public static void main(String[] args) {
//        System.out.println("Learning Progress Tracker");
//        Scanner scanner = new Scanner(System.in);

//        command = Asker.userInput("Learning Progress Tracker\n");
        System.out.println("Learning Progress Tracker");
//        do {
//            commands(command);
//
//            command = Asker.userInput("");
//        } while (!"exit".equals(command));


//        System.out.println("Bye!");
        new ModeChanger().run(new TopLevelMode(),"topLevel");


    }


//    private static void commands(String command) {
//
//        boolean isEnter = command.isEmpty() || command.isBlank();
//        if (isEnter) {
//            System.out.println("No input");
//        } else {
//
//            switch (command) {
//                case "exit":
//                    comExit();
//                    break;
//                case "add students":
//                    addStudents();
//                    break;
//                case "back":
//                    System.out.println("Enter 'exit' to exit the program.");
//                    break;
//                default:
//                    System.out.println("Unknown command!");
//            }
////                command = Asker.userInput("C");
//
//        }
//
//    }
//
//
//

}

