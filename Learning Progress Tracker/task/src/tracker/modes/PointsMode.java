package tracker.modes;
public class PointsMode implements Mode {

    @Override
    public void execute(String command) {
        if("add points".equals(command)){
//            System.out.printf("You have entered Points mode");
            System.out.println();

            String input = "";
            do{
                input = tracker.Asker.userInput("");
            }while (!"back".equals(input));
            new ModeChanger().run(new TopLevelMode(),"topLevel");
        }else{
            throw new UnsupportedCommandException(command);
        }
    }
}
