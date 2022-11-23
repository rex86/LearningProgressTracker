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
        isOKFirstName = name.matches("^([a-zA-Z]+[-']?\s?)*[a-zA-Z]+$");
        return isOKFirstName && name.length()>1;
    }

    public static boolean checkLastName(String name){
        boolean isOKLastName;
        String regexp= "^([a-zA-Z]+[-']?\s?)*[a-zA-Z]+$";
        isOKLastName = name.matches(regexp);
        return isOKLastName && name.length()>1;
    }
    public static boolean checkEmail(String email){
        return email.matches("^\\w+[-\\.]?\\w*@\\w+\\.\\w+");
    }
}
