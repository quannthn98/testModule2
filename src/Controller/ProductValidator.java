package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductValidator {
    private static final String REGEX = "^[A-Za-z0-9' ']{3,}$";
    private static final String NUMBEREGEX = "^[0-9]{4,}$";
    private static final String QUANTITYREGEX = "^[0-9]{1,}$";

    public ProductValidator() {
    }

    public static boolean isValidated(String input){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()){
            System.out.println("Your input isn't validated, please input at least 3 characters");
            return false;
        }
        return matcher.matches();
    }

    public static boolean isPriceValidated(String input){
        Pattern pattern = Pattern.compile(NUMBEREGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()){
            System.out.println("Please input valid price, currency is VND");
            return  false;
        }
        return matcher.matches();
    }

    public static boolean isQuantityValidated(String input){
        Pattern pattern = Pattern.compile(QUANTITYREGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()){
            System.out.println("PLease input at least 1 quantity of product");
            return false;
        }
        return matcher.matches();
    }
}
