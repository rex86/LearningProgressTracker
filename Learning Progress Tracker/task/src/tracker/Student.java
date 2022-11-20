package tracker;

public class Student implements Comparable<Student> {

    int id;
    int pointsJava;
    int pointsDsa;
    int pointsDatabases;



    int pointsSpring = 0;
    private String name;
    private String email;

    public Student(int id, String name, String email) {
        this.name = name;
        this.email = email;
        this.id = id;
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

    public int getPointsJava() {
        return pointsJava;
    }

    public void setPointsJava(int pointsJava) {
        this.pointsJava = pointsJava;
    }

    public int getPointsDsa() {
        return pointsDsa;
    }

    public void setPointsDsa(int pointsDsa) {
        this.pointsDsa = pointsDsa;
    }

    public int getPointsDatabases() {
        return pointsDatabases;
    }

    public void setPointsDatabases(int pointsDatabases) {
        this.pointsDatabases = pointsDatabases;
    }

    public int getPointsSpring() {
        return pointsSpring;
    }

    public void setPointsSpring(int pointsSpring) {
        this.pointsSpring = pointsSpring;
    }

    @Override
    public String toString() {
        return String.format("%d points: Java=%d; DSA=%d; Databases=%d; Spring=%d",
                getId(),getPointsJava(),getPointsDsa(),getPointsDatabases(),getPointsSpring());
    }

    @Override
    public int compareTo(Student student) {
        return email.equals(student.getEmail())?1:0;
//        if(email.equals(student.getEmail()))
    }
}
