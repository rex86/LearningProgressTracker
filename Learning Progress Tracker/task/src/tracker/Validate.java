package tracker;

public class Validate {

    public static boolean checkData(String firstName, String lastName, String email){

        if(!checkFirstName(firstName)){
            System.out.println("Incorrect first name.");
        } else if (!checkLastName(lastName)) {
            System.out.println("Incorrect last name.");
        } else if (!checkEmail(email)) {
            System.out.println("Incorrect email.");
        }
        return checkFirstName(firstName) &&
                checkLastName(lastName) &&
                checkEmail(email);
    }

    public static boolean checkFirstName(String name){
        boolean isOKFirstName;
//        System.out.println("F:" + name);
//        isOKFirstName = name.matches("[a-zA-Z-']*");
//        isOKFirstName = name.matches("^[^\\.-][a-zA-Z]*[a-zA-Z][-']?+[^\\.-]$");
        isOKFirstName = name.matches("^([a-zA-Z]+[-']?\s?)*[a-zA-Z]+$");
//        isOKFirstName = true;
//        System.out.println("length" + name.length());
        return isOKFirstName && name.length()>1;
    }

    public static boolean checkLastName(String name){
        boolean isOKLastName;
        String regexp= "^([a-zA-Z]+[-']?\s?)*[a-zA-Z]+$";
        isOKLastName = name.matches(regexp);
//        System.out.println(isOKLastName + " - " + (name.length()>1));
        return isOKLastName && name.length()>1;
    }
    public static boolean checkEmail(String email){

//        return email.matches("[a-z]+[\\.-]*[a-z]+@\\w+[-_]*.\\w{2,4}");
//        return email.matches("\\w+[\\.-]*\\w+@\\w+[-_]*.\\w+");
        return email.matches("^\\w+[-\\.]?\\w*@\\w+\\.\\w+");
    }
}
