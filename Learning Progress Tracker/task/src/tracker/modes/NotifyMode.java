package tracker.modes;

import tracker.Student;

import java.util.*;

public class NotifyMode implements Mode {
    final int pointsToCompleteJava = 600;
    final int pointsToCompleteDsa = 400;
    final int pointsToCompleteDatabases = 480;
    final int pointsToCompleteSpring = 550;
    List<Student> studentList;

    static int calledNotify = 0;

    public NotifyMode(List<Student> studentList) {
        this.studentList = studentList;
        calledNotify++;
    }

    @Override
    public void execute(String command) {
        if ("notify".equals(command)) {

            int numNotify = 0;
            String[] course;
            if (calledNotify == 1) {

                for (var item : sortUserByCompletedCourse().entrySet()) {
                    numNotify = item.getValue().split(",").length;
                    course = item.getValue().split(",");
                    for (int i = 0; i < course.length; i++) {

                        System.out.println(notifyTemplate(item.getKey().getEmail(), item.getKey().getName(), course[i].strip()));
                    }

                }
                System.out.printf("Total %s students have been notified.\n", sortUserByCompletedCourse().size());
                calledNotify++;
            } else {
                System.out.println("Total 0 students have been notified.");
            }

        } else {
            throw new UnsupportedCommandException(command);
        }
    }

    private String notifyTemplate(String email, String name, String courseName) {
        return "To: " + email + "\n" +
                "Re: Your Learning Progress\n" +
                "Hello, " + name + "! You have accomplished our " + courseName + " course!";
    }

    private Map<Student, String> sortUserByCompletedCourse() {

        Map<String, Integer> needToComplateCourse = new HashMap<>();
        needToComplateCourse.put("Java", 600);
        needToComplateCourse.put("DSA", 400);
        needToComplateCourse.put("Databases", 480);
        needToComplateCourse.put("Spring", 550);

        var completedCourseUsers = new HashMap<Student, String>();
        var courseList = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        String resultStr = "";
        for (var student : studentList) {

            if (isCompleted(student.getPointsJava(), pointsToCompleteJava)) {
                courseList.add("Java");
            }
            if (isCompleted(student.getPointsDsa(), pointsToCompleteDsa)) {
                courseList.add("DSA");
            }
            if (isCompleted(student.getPointsDatabases(), pointsToCompleteDatabases)) {
                courseList.add("Database");
            }
            if (isCompleted(student.getPointsSpring(), pointsToCompleteSpring)) {
                courseList.add("Spring");
            }
            if (courseList.size() > 0) {
                for (var item : courseList) {
                    sb.append(item + ", ");
                }
                int lastIndex = sb.lastIndexOf(", ");
                resultStr = sb.substring(0, lastIndex);

            }

            if (courseList.size() > 0) completedCourseUsers.put(student, resultStr);
            courseList.clear();
        }

        return completedCourseUsers;
    }


    private boolean isCompleted(int studentPoints, int pointsToComplete) {
        return studentPoints >= pointsToComplete;
    }
}
