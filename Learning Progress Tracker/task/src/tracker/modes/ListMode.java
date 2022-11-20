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

            if(studentList.size() == 0){
                System.out.println("No students found.");
            }
            else{

                System.out.println("Students:");
                for (Student item: studentList) {
                    System.out.println(item.getId());
                }
            }

        }else{
            throw new UnsupportedCommandException(command);
        }
    }

}
