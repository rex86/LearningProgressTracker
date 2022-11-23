package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {

    int id;
    int pointsJava;
    int pointsDsa;
    int pointsDatabases;
    int allPoints;
    int pointsSpring = 0;
    private String name;
    private String email;

    private int countActivityJava=1;
    private int countActivityDsa=1;
    private int countActivityDatabases=1;
    private int countActivitySpring=1;


    public List<String> getEveryPoints() {
        return everyPoints;
    }

    public void setEveryPoints(List<String> everyPoints) {
        this.everyPoints = everyPoints;
    }

    private List<String> everyPoints;
    public Map<String, Integer> getActivityMap() {
        return activityMap;
    }

    private Map<String,Integer> activityMap = new HashMap<>();
    public Student(int id, String name, String email) {
        this.name = name;
        this.email = email;
        this.id = id;
        everyPoints = new ArrayList<>();
        activityMap.put("Java",0);
        activityMap.put("DSA",0);
        activityMap.put("Databases",0);
        activityMap.put("Spring",0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getPointsJava() {return pointsJava;
    }

    public void setPointsJava(int pointsJava) {

        this.pointsJava = pointsJava;
        if(pointsJava>0) activityMap.replace("Java",countActivityJava++);

    }

    public int getPointsDsa() {
        return pointsDsa;
    }

    public void setPointsDsa(int pointsDsa) {

        this.pointsDsa = pointsDsa;
        if(pointsDsa>0) activityMap.replace("DSA",countActivityDsa++);
    }

    public int getPointsDatabases() {
        return pointsDatabases;
    }

    public void setPointsDatabases(int pointsDatabases) {

        this.pointsDatabases = pointsDatabases;
        if(pointsDatabases>0) activityMap.replace("Databases",countActivityDatabases++);

    }

    public int getPointsSpring() {
        return pointsSpring;
    }

    public void setPointsSpring(int pointsSpring) {

        this.pointsSpring = pointsSpring;
        if(pointsSpring>0) activityMap.replace("Spring",countActivitySpring++);

    }
    public int getCountActivityJava() {
        return countActivityJava;
    }

    public int getCountActivityDsa() {
        return countActivityDsa;
    }

    public int getCountActivityDatabases() {
        return countActivityDatabases;
    }

    public int getCountActivitySpring() {
        return countActivitySpring;
    }

    @Override
    public String toString() {
        return String.format("%d points: Java=%d; DSA=%d; Databases=%d; Spring=%d",
                getId(),getPointsJava(),getPointsDsa(),getPointsDatabases(),getPointsSpring());
    }
    public int getAllPoints() {
        return pointsJava+pointsDsa+pointsDatabases+pointsSpring;
    }

}
