package tracker.modes;

import tracker.Student;

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

    @Override
    public void execute(String command) {


        if("statistics".equals(command)){
            System.out.println("Type the name of a course to see details or 'back' to quit:");

            String input = "";
//            input = tracker.Asker.userInput("");
            String [] testData = {"n/a","n/a","n/a","n/a","n/a","n/a"};
            sumStatisticsTable(testData);
            while (!"back".equals(input)){

                input = tracker.Asker.userInput("");
                if(isCourseExists(input)){
                    courseStatisticsTable(input);
                }else {
                    System.out.println("Unknown course.");
                }

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

        for (Student item: studentList) {
            switch (courseName){
                case "java":
                    courseNum =item.getPointsJava();
                    coursePoint = pointsToCompleteJava;
                    studentParticularCoursePoints = item.getPointsJava();
                    break;
                case "dsa":
                    courseNum =item.getPointsDsa();
                    coursePoint = pointsToCompleteDsa;
                    studentParticularCoursePoints = item.getPointsDsa();
                    break;
                case "databases":
                    courseNum =item.getPointsDatabases();
                    coursePoint = pointsToCompleteDatabases;
                    studentParticularCoursePoints = item.getPointsDatabases();
                    break;
                case "spring":
                    courseNum =item.getPointsSpring();
                    coursePoint = pointsToCompleteSpring;
                    studentParticularCoursePoints = item.getPointsSpring();
                    break;
            }
            completedValue = (courseNum/coursePoint)*100+"%";
            System.out.printf("%d\t%d\t%s\n",item.getId(),studentParticularCoursePoints,completedValue);
        }
    }

    private boolean isCourseExists(String courseName){

        return "java".equals(courseName) ||
                "dsa".equals(courseName) ||
                "databases".equals(courseName) ||
                "spring".equals(courseName);
    }



}
