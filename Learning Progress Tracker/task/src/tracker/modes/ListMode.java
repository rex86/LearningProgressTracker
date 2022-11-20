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
//            System.out.printf("You have entered List mode");

            System.out.println("List size: " + studentList.size());
            for (Student item: studentList) {
                System.out.println(item.getId());
            }

//            new ModeChanger().run(new TopLevelMode(),"topLevel");
        }else{
            throw new UnsupportedCommandException(command);
        }
    }
    public void listStudents(List<Student> studentList){
        for (Student item: studentList) {
            System.out.println(item.getId());
        }
    }

}
