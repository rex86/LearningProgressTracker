package tracker.modes;

import tracker.Student;
import tracker.Validate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsMode implements Mode{

    List<Student> students = new ArrayList<>();
    boolean isOK = false;
    boolean isEnd = false;
    String fullName = "";
    String firstName = "";
    String lastName = "";
    String emailAddress = "";
    int lastSpaceIndex = 0;
    int firstSpaceIndex = 0;

    @Override
    public void execute(String modeCommand) {
        if("add students".equals(modeCommand)){

            int userId=10000;
            String command = "";
            command = tracker.Asker.userInput("Enter student credentials or 'back' to return:\n");
            while (!"back".equals(command)){

//                if (!command.matches(".+@.+") ) {
//                    System.out.println("Incorrect credentials.");

//                } else if (command.matches(".+@.+")) {
                 if (command.matches(".+[@\\.].+")) {
                    firstSpaceIndex = command.indexOf(" ");
                    lastSpaceIndex = command.lastIndexOf(" ");
                    firstName = command.strip().substring(0, firstSpaceIndex);
                    lastName = command.strip().substring(firstSpaceIndex + 1, lastSpaceIndex);
                    fullName = firstName + " " + lastName;
                    emailAddress = command.strip().substring(lastSpaceIndex + 1).strip();
                    boolean isExistStudent = isExistStudent(emailAddress);
                    if (Validate.checkData(firstName, lastName, emailAddress) && !isExistStudent) {
                        students.add(new Student(userId++,fullName, emailAddress));
                        System.out.println("The student has been added.");
                    } else if (isExistStudent) {
                        System.out.println("This email is already taken.");
                    }
                }
                 else {
                     System.out.println("Incorrect credentials.");
                 }
                command = tracker.Asker.userInput("");
            }

            int studentListSize = students.size();
            System.out.println("Total " + studentListSize + " students have been added.");


        }else{
            throw new UnsupportedCommandException(modeCommand);
        }
    }
    public List<Student> getStudents() {
        return students;
    }

    private boolean isExistStudent(String emailAddress){
        for (Student item: students) {
            if(item.getEmail().equals(emailAddress)) return true;
        }
        return false;
    }
}
