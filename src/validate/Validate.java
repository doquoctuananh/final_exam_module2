package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static String regexPhone = "^\\([0-9]{2}\\)-\\([0-9]{9}\\)$";
    public static String regexEmail = "^[a-zA-Z0-9]+@gmail\\.com$";
    // validatephone
    public static boolean validatePhone(String phone){
        Pattern pattern = Pattern.compile(regexPhone);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    // validate email
    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
