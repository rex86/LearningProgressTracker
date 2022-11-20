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
            Student student;
            int pointsJava=0;
            int pointsDsa=0;
            int pointsDatabases=0;



            int pointsSpring = 0;
            while (!"back".equals(input)) {
                 split_input = input.split(" ");
                try {

                    isIncorrect=false;
                    for (int i = 0; i < split_input.length; i++) {
                        if(split_input.length != 5){
                            System.out.println("Incorrect points format.");
                            isIncorrect = false;
                            break;
                        }
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
//                System.out.println("SDFDFDFDFDF");
                student = findUser(Integer.parseInt(split_input[0]));
//                System.out.println("GREEEEE");
                if(!isIncorrect && student != null && split_input.length == 5){
                    pointsJava +=Integer.parseInt(split_input[1]);
                    student.setPointsJava(pointsJava);
                    pointsDsa +=Integer.parseInt(split_input[2]);
                    student.setPointsDsa(pointsDsa);
                    pointsDatabases+=Integer.parseInt(split_input[3]);
                    student.setPointsDatabases(pointsDatabases);
                    pointsSpring+=Integer.parseInt(split_input[4]);
                    student.setPointsSpring(pointsSpring);

                    System.out.println("Points updated.");
                }

                input = tracker.Asker.userInput("");
            }
//            new ModeChanger().run(new TopLevelMode(),"topLevel");
        } else {
            throw new UnsupportedCommandException(command);
        }
    }
    public Student findUser(int userId){
        for (Student item: studentList) {
            if(item.getId() == userId){
                return item;
            }
        }
        return null;
    }
}
