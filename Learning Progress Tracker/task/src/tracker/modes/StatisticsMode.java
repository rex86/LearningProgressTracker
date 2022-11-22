package tracker.modes;

import tracker.Student;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StatisticsMode implements Mode {
    List<Student> studentList;

    public StatisticsMode(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StatisticsMode() {
    }
    final double pointsToCompleteJava = 600.0;
    final double pointsToCompleteDsa = 400.0;
    final double pointsToCompleteDatabases = 480.0;
    final double pointsToCompleteSpring = 550.0;
    List<SortedStudents> sortedStudentsList = new ArrayList<>();


    @Override
    public void execute(String command) {


        if("statistics".equals(command)){
            System.out.println("Type the name of a course to see details or 'back' to quit:");

            String input = "";
//            input = tracker.Asker.userInput("");
            String [] testData = {"n/a","n/a","n/a","n/a","n/a","n/a"};
            sumStatisticsTable(testData);
            input = tracker.Asker.userInput("");
            while (!"back".equals(input)){

                if(isCourseExists(input)){
                    courseStatisticsTable(input);
                }else {
                    System.out.println("Unknown course.");
                }
                input = tracker.Asker.userInput("");

            }

        }else{
            throw new UnsupportedCommandException(command);
        }
    }

    private void sumStatisticsTable(String [] datas){

        System.out.println("Most popular: " + datas[0]+"\n" +
                "Least popular: " + datas[1] + "\n" +
                "Highest activity: " + datas[2] + "\n" +
                "Lowest activity: " + datas[3] + "\n" +
                "Easiest course: " + datas[4] + "\n" +
                "Hardest course: " + datas[5]);

    }

    private void courseStatisticsTable(String courseName){
        String firstLatterUpperCase = courseName.substring(0,1).toUpperCase();
        System.out.println(firstLatterUpperCase + courseName.substring(1));
        System.out.printf("id\tpoints\tcompleted\n");
        String completedValue;
        int courseNum=0;
        double coursePoint=0;
        int studentParticularCoursePoints=0;
        NumberFormat numf = NumberFormat.getNumberInstance();
        SortedStudents sortedStudents;
//        for (Student item: studentList) {

            switch (courseName){
                case "java":
                    for (Student student: studentList){
                        courseNum =student.getPointsJava();
                        coursePoint = pointsToCompleteJava;
                        studentParticularCoursePoints = student.getPointsJava();
                        if(studentParticularCoursePoints>0){
                            numf.setRoundingMode(RoundingMode.HALF_UP);
                            double num = (courseNum/coursePoint)*100;
                            double formattedNum = Double.parseDouble(numf.format(num));
                            String numformated = String.format("%.1f", formattedNum);
                            completedValue = numformated+"%";
                            sortedStudents = new SortedStudents(student.getId(),studentParticularCoursePoints,completedValue);
                            sortedStudentsList.add(sortedStudents);
                        }
                    }
                    printOrdered();
                    break;
                case "dsa":
                    for (Student student: studentList){
                        courseNum =student.getPointsDsa();
                        coursePoint = pointsToCompleteDsa;
                        studentParticularCoursePoints = student.getPointsDsa();
                        if(studentParticularCoursePoints>0){
                            numf.setRoundingMode(RoundingMode.HALF_UP);
                            double num = (courseNum/coursePoint)*100;
                            double formattedNum = Double.parseDouble(numf.format(num));
                            String numformated = String.format("%.1f", formattedNum);
                            completedValue = numformated+"%";
                            sortedStudents = new SortedStudents(student.getId(),studentParticularCoursePoints,completedValue);
                            sortedStudentsList.add(sortedStudents);
                        }
                    }
                    printOrdered();
                    break;
                case "databases":
                    for (Student student: studentList){
                        courseNum =student.getPointsDatabases();
                        coursePoint = pointsToCompleteDatabases;
                        studentParticularCoursePoints = student.getPointsDatabases();
                        if(studentParticularCoursePoints>0){
                            numf.setRoundingMode(RoundingMode.HALF_UP);
                            double num = (courseNum/coursePoint)*100;
                            double formattedNum = Double.parseDouble(numf.format(num));
                            String numformated = String.format("%.1f", formattedNum);
                            completedValue = numformated+"%";
                            sortedStudents = new SortedStudents(student.getId(),studentParticularCoursePoints,completedValue);
                            sortedStudentsList.add(sortedStudents);
                        }
                    }
                    printOrdered();
                    break;
                case "spring":
                    for (Student student: studentList){
                        courseNum =student.getPointsSpring();
                        coursePoint = pointsToCompleteSpring;
                        studentParticularCoursePoints = student.getPointsSpring();
                        if(studentParticularCoursePoints>0){
                            numf.setRoundingMode(RoundingMode.HALF_UP);
                            double num = (courseNum/coursePoint)*100;
                            double formattedNum = Double.parseDouble(numf.format(num));
                            String numformated = String.format("%.1f", formattedNum);
                            completedValue = numformated+"%";
                            sortedStudents = new SortedStudents(student.getId(),studentParticularCoursePoints,completedValue);
                            sortedStudentsList.add(sortedStudents);
                        }
                    }
                    printOrdered();
                    break;
            }
//            if(studentParticularCoursePoints>0){
//
//                completedValue = (courseNum/coursePoint)*100+"%";
////                System.out.printf("%d\t%d\t%s\n",item.getId(),studentParticularCoursePoints,completedValue);
//                sortedStudents = new SortedStudents(item.getId(),studentParticularCoursePoints,completedValue);
////                System.out.println(" - "+item.getId());
//                sortedStudentsList.add(sortedStudents);
//
//
//                printOrdered();
////                sortedStudentsList.sort(new StatisticsPointComperator().reversed());
////                sortedStudentsList.forEach(System.out::println);
//            }
//        }
    }

    private boolean isCourseExists(String courseName){

        return "java".equals(courseName) ||
                "dsa".equals(courseName) ||
                "databases".equals(courseName) ||
                "spring".equals(courseName);
    }


    private void printOrdered(){
        sortedStudentsList.sort(new StatisticsPointComperator().reversed());
        sortedStudentsList.forEach(System.out::println);
        sortedStudentsList.clear();

    }

}
class StatisticsPointComperator implements Comparator<SortedStudents> {

    @Override
    public int compare(SortedStudents o1, SortedStudents o2) {
        return Integer.compare(o1.getPoints(),o2.getPoints());
    }
//    @Override
//    public Comparator<SortedStudents> reversed() {
//        return Comparator.super.reversed();
//    }
}

class SortedStudents {
    private int id;
    private int points;
    private String completed;

    public SortedStudents(int id, int points, String completed) {
        this.id = id;
        this.points = points;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return id + "\t" +
                "\t"+ points +
                "\t" + completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
