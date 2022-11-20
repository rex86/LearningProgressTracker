package tracker.modes;
public class ModeController {
    public static void main(String[] args) {
        String command = "topLevel";
        new ModeChanger().run(new TopLevelMode(),command); //enter to particular mode

//        Mode pointsMode = new PointsMode();
//        Mode studentsMode = new StudentsMode();
//        Mode findMode = new FindMode();
//        Mode topLevelMode = new TopLevelMode();
//        Mode listMode = new ListMode();
    }
}
