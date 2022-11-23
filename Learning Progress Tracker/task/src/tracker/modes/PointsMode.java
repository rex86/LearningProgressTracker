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
            boolean isIncorrect = false;
            Student student;
            int pointsJava = 0;
            int pointsDsa = 0;
            int pointsDatabases = 0;


            int pointsSpring = 0;
            while (!"back".equals(input)) {
                split_input = input.split(" ");

                isIncorrect = false;


                for (int i = 1; i < split_input.length; i++) {
                    if(isDigit(split_input[i])){

                        num = Integer.parseInt(split_input[i]);
                    }
                    else {
                        num = 0;
                    }
                    if (!isDigit(split_input[i]) ||  num < 0) {
                        System.out.println("Incorrect points format.");
                        isIncorrect = true;
                        break;
                    }

                }

                if (split_input.length != 5) {
                    System.out.println("Incorrect points format.");
                    isIncorrect = true;

                }
                if (!isDigit(split_input[0])) {
                    System.out.printf("No student is found for id=%s\n", split_input[0]);
                } else {
                    student = findUser(Integer.parseInt(split_input[0]));

                    if (!isIncorrect && student != null && split_input.length == 5) {

                        var everyStudentPoints = student.getEveryPoints();
                        pointsJava = student.getPointsJava()+Integer.parseInt(split_input[1]);
                        student.setPointsJava(pointsJava);
                        pointsDsa = student.getPointsDsa()+Integer.parseInt(split_input[2]);
                        student.setPointsDsa(pointsDsa);
                        pointsDatabases = student.getPointsDatabases()+Integer.parseInt(split_input[3]);
                        student.setPointsDatabases(pointsDatabases);
                        pointsSpring = student.getPointsSpring()+Integer.parseInt(split_input[4]);
                        student.setPointsSpring(pointsSpring);
                        everyStudentPoints.add(split_input[1]+" "+split_input[2]+" "+split_input[3]+" "+split_input[4]);
                        System.out.println("Points updated.");
                    }
                }


                input = tracker.Asker.userInput("");
            }
        } else {
            throw new UnsupportedCommandException(command);
        }
    }

    public Student findUser(int userId) {

        for (Student item : studentList) {
            if (item.getId() == userId) {
                return item;
            }
        }


        return null;
    }

    private boolean isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
