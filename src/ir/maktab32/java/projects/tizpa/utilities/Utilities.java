package ir.maktab32.java.projects.tizpa.utilities;

public class Utilities {

    public static boolean isValueInRange(String numericString, int min, int max){
        if (!isNumeric(numericString))
            return false;
        else if (Integer.parseInt(numericString) >= min && Integer.parseInt(numericString) <= max)
            return true;
        else
            return false;
    }

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}