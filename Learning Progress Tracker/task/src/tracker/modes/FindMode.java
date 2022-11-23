package tracker.modes;

import tracker.Student;

import java.util.List;

public class FindMode implements Mode {
    List<Student> studentList;

    public FindMode() {
    }

    public FindMode(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void execute(String command) {
        int userId;
        Student student;
        if ("find".equals(command)) {
            System.out.println("Enter an id or 'back' to return:");

            String input = tracker.Asker.userInput("");
            while (!"back".equals(input)) {
                userId = Integer.parseInt(input);
                student = findUser(userId);
                if (Integer.parseInt(input) > 0 && student != null) {
                    System.out.println(student);
                } else if (student == null) {
                    System.out.println("No student is found for id=" + userId + ".");
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
}
