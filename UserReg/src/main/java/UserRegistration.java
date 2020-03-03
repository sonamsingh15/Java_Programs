public class UserRegistration {
    public static String checkFirstName(String message) {
        if (message.matches("^[A-Z]{1}[a-z]{2,10}$"))
            return "valid";
        else
            return "Invalid";

    }

    public String checkLastName(String message) {
        if (message.matches("^[A-Z]{1}[a-z]{2,10}[A-Z]{1}[a-z]{2,10}$"))
            return "valid";
            else
                return "Invalid";
    }

    public String checkEmail(String messsage) {
        if (messsage.matches("^[a-zA-Z0-9]{1,}[._+-]?[a-zA-Z0-9]{1,}?[@][a-zA-Z0-9]{1,}([.][a-zA-Z]{2,4}){1,2}$"))
            return "valid";
        else
            return "invalid";

    }

    public String checkPhoneNumber(String message) {
        if (message.matches("^[+]?[0-9]{2}[ ][0-9]{10}$"))
            return "valid";
        else
            return "invalid";
    }

    public String checkPassword(String message) {
            if (message.matches("(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[+@#$%^&*!.()-]){1}.{8,}"))

            return "valid";
        else
            return "invalid";
    }
}
