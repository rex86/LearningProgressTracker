package tracker.modes;

import tracker.Student;

import java.util.List;

public class ListMode implements Mode {


    List<Student> studentList;

    public ListMode(List<Student> studentList) {
        this.studentList = studentList;
    }

    public ListMode() {
    }

    public void execute(String command) {
        if("list".equals(command)){

            for (Student item: studentList) {
                System.out.println("Students:");
                System.out.println(item.getId());
            }

        }else{
            throw new UnsupportedCommandException(command);
        }
    }

}
