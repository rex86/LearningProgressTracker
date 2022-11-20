package tracker.modes;

import tracker.Student;

import java.util.List;

public class ListMode implements Mode {


    public ListMode() {
    }



    public void execute(String command) {
        if("list".equals(command)){
//            System.out.printf("You have entered List mode");
            List<Student> studentList = new TopLevelMode().getStudents();

            for (Student item: studentList) {
                System.out.println(item.getId());
            }
            System.out.println("Y");

            new ModeChanger().run(new TopLevelMode(),"topLevel");
        }else{
            throw new UnsupportedCommandException(command);
        }
    }

}
