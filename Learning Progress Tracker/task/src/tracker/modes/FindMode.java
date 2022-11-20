package tracker.modes;
public class FindMode implements Mode{

    public void execute(String command) {
        if("find".equals(command)){
//            System.out.printf("You have entered Find mode");
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
