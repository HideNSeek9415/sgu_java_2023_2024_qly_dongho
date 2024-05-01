package gui.dashboard;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class CheckValid {
	private static final String EMAIL_REGEX =
			 "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	private static final String PHONE_NUMBER_REGEX =
            "^0[0-9]{9}$";
	private static Pattern emailPattern = null;
	private static Pattern phonePattern = null;
    
    public static boolean isValidEmail(String email) {
    	emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
    	phonePattern = Pattern.compile(PHONE_NUMBER_REGEX);
    	Matcher matcher = phonePattern.matcher(phoneNumber);
    	return matcher.matches();
    }
}



