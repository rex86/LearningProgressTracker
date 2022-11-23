package tracker.modes;

import tracker.Student;

import java.util.ArrayList;
import java.util.List;

public class TopLevelMode implements Mode {

    public TopLevelMode() {
    }

    public void execute(String command) {

        ModeChanger modeChanger = new ModeChanger();
        StudentsMode studentsMode = new StudentsMode();
        StatisticsMode statisticsMode = new StatisticsMode(studentsMode.getStudents());

        ListMode listMode = new ListMode(studentsMode.getStudents());
        FindMode findMode = new FindMode(studentsMode.getStudents());
        PointsMode pointsMode = new PointsMode(studentsMode.getStudents());
        NotifyMode notifyMode = new NotifyMode(studentsMode.getStudents());


        if ("topLevel".equals(command)) {

            do {
                String input = tracker.Asker.userInput("");

                boolean isEnter = input.isEmpty() || input.isBlank();
                if (isEnter) {
                    System.out.println("No input");
                } else {


                    switch (input) {
                        case "add students":
                            modeChanger.run(studentsMode, input);
                            break;
                        case "list":
                            modeChanger.run(listMode, input);
                            break;
                        case "find":
                            modeChanger.run(findMode, input);
                            break;
                        case "add points":
                            modeChanger.run(pointsMode, input);
                            break;
                        case "statistics":
                            modeChanger.run(statisticsMode, input);
                            break;
                        case "exit":
                            comExit();
                        case "back":
                            System.out.println("Enter 'exit' to exit the program.");
                            break;
                        case "notify":
                            modeChanger.run(notifyMode, input);
                            break;
                        default:
                    System.out.println("Unknown command!");
                    }
                }
            } while (true);

        } else {
            throw new UnsupportedCommandException(command);
        }
    }

    private void comExit() {
        System.out.println("Bye!");
        System.exit(0);
    }


}
