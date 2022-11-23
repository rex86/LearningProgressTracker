package tracker.modes;

import tracker.Student;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;

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
    Map<String,Integer> popularList;
    Map<String,Integer> activityList;
    int countjava=0;
    int countdsa=0;
    int countdatabase=0;
    int countspring=0;

    @Override
    public void execute(String command) {

        if("statistics".equals(command)){
            System.out.println("Type the name of a course to see details or 'back' to quit:");

            String input = "";
//            input = tracker.Asker.userInput("");
            popularList = new HashMap<>();
            popularList.put("Java",0);
            popularList.put("DSA",0);
            popularList.put("Databases",0);
            popularList.put("Spring",0);

            activityList = new HashMap<>();
            activityList.put("Java",0);
            activityList.put("DSA",0);
            activityList.put("Databases",0);
            activityList.put("Spring",0);

            String [] testData = {"n/a","n/a","n/a","n/a","n/a","n/a"};
            sumStatisticsTable(testData);
            input = tracker.Asker.userInput("");
            while (!"back".equals(input)){
//                System.out.println("isCourseExists: " + input);
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

        System.out.println("Most popular: " + popular("most")+"\n" +
                "Least popular: " + popular("least") + "\n" +
                "Highest activity: " + activity("highest") + "\n" +
                "Lowest activity: " + activity("lowest") + "\n" +
                "Easiest course: " + course("easiest") + "\n" +
                "Hardest course: " + course("hardest"));
//        activity("highest");

    }

    private void courseStatisticsTable(String courseName){
        String firstLatterUpperCase = courseName.substring(0,1).toUpperCase();

        if("dsa".equals(courseName)) {
            System.out.println(courseName.toUpperCase());
        }else {

            System.out.println(firstLatterUpperCase + courseName.substring(1));
        }
        System.out.printf("id    points    completed\n");
        String completedValue;
        int courseNum=0;
        double coursePoint=0;
        int studentParticularCoursePoints=0;
        NumberFormat numf = NumberFormat.getNumberInstance();
        SortedStudents sortedStudents;
//        for (Student item: studentList) {
//        System.out.println("BS"+courseName);
            switch (courseName){
                case "Java":
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
                case "DSA":
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
                case "Databases":
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
                case "Spring":
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

        return "Java".equals(courseName) ||
                "DSA".equals(courseName) ||
                "Databases".equals(courseName) ||
                "Spring".equals(courseName);
    }


    private void printOrdered(){
        sortedStudentsList.sort(new StatisticsPointComperator().reversed());
        sortedStudentsList.forEach(System.out::println);
        sortedStudentsList.clear();

    }
    private String popular(String mostOrLeastPopular){
        StringBuilder sb = new StringBuilder();
        int countJava=0;
        int countDsa=0;
        int countDatabases=0;
        int countSpring=0;
        if(studentList.size() == 0) return "n/a";

        if("most".equals(mostOrLeastPopular)){
            for (Student student: studentList) {
                if(student.getPointsJava()>0) {
                    countJava++;
                }
                if(student.getPointsDsa()>0) {
                    countDsa++;
                }
                if(student.getPointsDatabases()>0) {
                    countDatabases++;
                }
                if(student.getPointsSpring()>0) {
                    countSpring++;
                }
            }
            popularList.replace("Java",countJava);
            popularList.replace("DSA",countDsa);
            popularList.replace("Databases",countDatabases);
            popularList.replace("Spring",countSpring);
            int max=Collections.max(popularList.values());

            List<String> deleteKeys = new ArrayList<>();
            for (var item: popularList.entrySet()) {
                if(item.getValue() == max) {
                    deleteKeys.add(item.getKey());
//                    sb.append(item.getKey()+",");
                }
            }
            for (String item: deleteKeys) {
                popularList.remove(item);
                sb.append(item+", ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
//            System.out.println(sb);

        } else if ("least".equals(mostOrLeastPopular)) {
            if (popularList.size() > 0) {


                int min=Collections.min(popularList.values());

                for (var item: popularList.entrySet()) {
                    if(item.getValue() == min) {
//                    deleteKeys.add(item.getKey());
                        sb.append(item.getKey()+",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
            }
            else{

                sb.append("n/a");
            }
        }
//        for (String item: deleteKeys) {
//            popularList.remove(item);
//        }
        return sb.toString();
    }

    private String activity(String highestorLowest){
        StringBuilder sb = new StringBuilder();
        if(studentList.size() == 0) return "n/a";

        Map<String,Integer> studentMap;

         int javaPoint=0;
         int dsaPoint=0;
         int databasesPoint=0;
         int springPoint=0;



         String [] split_points;
        if("highest".equals(highestorLowest)){
            for (var student:studentList) {

                for (String item:student.getEveryPoints()) {
                    split_points = item.split(" ");
                    javaPoint = Integer.parseInt(split_points[0]);
                    dsaPoint = Integer.parseInt(split_points[1]);
                    databasesPoint = Integer.parseInt(split_points[2]);
                    springPoint = Integer.parseInt(split_points[3]);


                    if(javaPoint>0){
                        countjava++;
                    }if (dsaPoint>0) {
                        countdsa++;
                    }if (databasesPoint>0) {
                        countdatabase++;
                    }if (springPoint>0) {
                        countspring++;
                    }
                }

//                System.out.printf("%s-%s-%s-%s\n",javaPoint,dsaPoint,databasesPoint,springPoint);
            }
//            System.out.printf("VAA %s-%s-%s-%s\n",countjava,countdsa,countdatabase,countspring);

//            var listSumActivity = new ArrayList<Integer>();
//            listSumActivity.add(countjava);
//            listSumActivity.add(countdsa);
//            listSumActivity.add(countdatabase);
//            listSumActivity.add(countspring);
            activityList.put("Java",countjava);
            activityList.put("DSA",countdsa);
            activityList.put("Databases",countdatabase);
            activityList.put("Spring",countspring);

            int max = Collections.max(activityList.values());

            List<String> deleteKeys = new ArrayList<>();
            for (var item: activityList.entrySet()) {
                if(item.getValue() == max) {
                    deleteKeys.add(item.getKey());
//                    sb.append(item.getKey()+",");
                }
            }

            for (String item: deleteKeys) {
                activityList.remove(item);
                sb.append(item+",");
            }
            sb.deleteCharAt(sb.length()-1);
        } else if ("lowest".equals(highestorLowest)) {
            if(activityList.size()>0){

                int min = Collections.min(activityList.values());
                List<String> deleteKeys = new ArrayList<>();
                for (var item: activityList.entrySet()) {
                    if(item.getValue() == min) {
                        deleteKeys.add(item.getKey());
//                    sb.append(item.getKey()+",");
                    }
                }

                for (String item: deleteKeys) {
                    activityList.remove(item);
                    sb.append(item+",");
                }
                sb.deleteCharAt(sb.length()-1);
            }else{

                sb.append("n/a");
            }
        }

        return sb.toString();
    }

    private String course(String easiestHardest){
        if(studentList.size() == 0) return "n/a";

        StringBuilder sb = new StringBuilder();
        Map<String, Double> avg = new HashMap<>();
        avg.put("Java",0.0);
        avg.put("DSA",0.0);
        avg.put("Databases",0.0);
        avg.put("Spring",0.0);
        double avgjava=0.0;
        double avgdsa=0.0;
        double avgdatabases=0.0;
        double avgspring=0.0;
        double max=0.0;
        double min=0.0;
        for (Student student:studentList) {
            avgjava+=(double)student.getPointsJava()/countjava;
//                System.out.println(student.getPointsJava()+"/"+countjava);
            avgdsa+=(double)student.getPointsDsa()/countdsa;
            avgdatabases+=(double)student.getPointsDatabases()/countdatabase;
            avgspring+=(double)student.getPointsSpring()/countspring;

            avg.replace("Java",avgjava);
            avg.replace("DSA",avgdsa);
            avg.replace("Databases",avgdatabases);
            avg.replace("Spring",avgspring);
        }
        if("easiest".equals(easiestHardest)){

            max = Collections.max(avg.values());
//            min = Collections.min(avg);
            for (var item: avg.entrySet()) {
                if(item.getValue() == max){
                    sb.append(item.getKey()+", ");
                }

            }
            sb.deleteCharAt(sb.length() -1);
            sb.deleteCharAt(sb.length() -1);

//            for (int i=0;i<avg.size();i++) {
//                if(avg.get(i) == max){
//                    switch (i){
//                        case 0:
//                            sb.append("Java");
//                            break;
//                        case 1:
//                            sb.append("DSA");
//                            break;
//                        case 2:
//                            sb.append("Databases");
//                            break;
//                        case 3:
//                            sb.append("Spring");
//                    }
//                    if(avg.size()>0) sb.append(", ");
//                }
//            }
//            sb.deleteCharAt(sb.length()-1);
//            sb.deleteCharAt(sb.length()-1);
        } else if ("hardest".equals(easiestHardest)) {
            min = Collections.min(avg.values());
            for (var item: avg.entrySet()) {
                if(item.getValue() == min){
                    sb.append(item.getKey()+", ");
                }

            }
//            for (int i=0;i<avg.size();i++) {
//                if(avg.get(i) == min){
//                    switch (i){
//                        case 0:
//                            sb.append("Java");
//                            break;
//                        case 1:
//                            sb.append("DSA");
//                            break;
//                        case 2:
//                            sb.append("Databases");
//                            break;
//                        case 3:
//                            sb.append("Spring");
//                    }
//                    if(avg.size()>0) sb.append(", ");
//                }
//            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
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
        return id +
                " "+ points +
                "        " + completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
