package tracker.modes;

import tracker.Student;

import java.util.ArrayList;
import java.util.List;

public class TopLevelMode implements Mode{

    List<Student> students = new ArrayList<>();



    public TopLevelMode() {
    }

    public void execute(String command) {

        ModeChanger modeChanger = new ModeChanger();
        StudentsMode studentsMode = new StudentsMode();

        ListMode listMode = new ListMode();
        FindMode findMode = new FindMode();
        PointsMode pointsMode = new PointsMode();


        if("topLevel".equals(command)){

            do{
                String input = tracker.Asker.userInput("");

                switch (input){
                    case "add students":
                        modeChanger.run(studentsMode,input);
                        break;
                    case "list":
                        modeChanger.run(listMode,input);
                        break;
                    case "find":
                        modeChanger.run(findMode,input);
                        break;
                    case "points":
                        modeChanger.run(pointsMode,input);
                        break;
                    case "exit":
                        comExit();
                    case "back":
                        System.out.println("Enter 'exit' to exit the program.");;
                }
            }while (true);

        }else{
            throw new UnsupportedCommandException(command);
        }
    }

    private void comExit() {
        System.out.println("Bye!");
        System.exit(0);
    }

    public List<Student> getStudents() {
        return students;
    }
}
