package tracker.modes;

import tracker.Student;

import java.util.List;

public class PointsMode implements Mode {

    List<Student> studentList;

    public PointsMode(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public void execute(String command) {
        if ("add points".equals(command)) {
//            System.out.printf("You have entered Points mode");
//            System.out.println();

            String input = tracker.Asker.userInput("Enter an id and points or 'back' to return:\n");
            String[] split_input;
//            System.out.println(split_input.length);
            int num = 0;
            boolean isIncorrect=false;
            while (!"back".equals(input)) {
                 split_input = input.split(" ");
                try {

                    isIncorrect=false;
                    for (int i = 0; i < split_input.length; i++) {
                        num = Integer.parseInt(split_input[i]);
                        if (num < 0 && !isIncorrect) {
                            System.out.println("Incorrect points format.");
                            isIncorrect = true;
                            break;
                        }
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Incorrect points format.");
                    isIncorrect = true;

                }
                if(!isIncorrect) System.out.println("Points updated.");

                input = tracker.Asker.userInput("");
            }
//            new ModeChanger().run(new TopLevelMode(),"topLevel");
        } else {
            throw new UnsupportedCommandException(command);
        }
    }
}
