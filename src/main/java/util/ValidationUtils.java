package util;

public class ValidationUtils {

    public static boolean isValidAnimalData(String s) {
        String line[]=s.split(",");
        String species=null;
        String eyeColor=null;
        String fur=null;
        if(line.length!=3) return false;
        species=line[0];
        eyeColor=line[1];
        fur=line[2];
        if(!(fur.equalsIgnoreCase("да")||fur.equalsIgnoreCase("нет")
                ||fur.equalsIgnoreCase("true")||fur.equalsIgnoreCase("false")))
            return false;
        return !species.isEmpty() && !eyeColor.isEmpty();
    }

    public static boolean isValidBarrelData(Integer volume, String content, String made) {
        // Implement validation logic
        return volume > 0 && !content.isEmpty() && !made.isEmpty();
    }

    public static boolean isValidPersonData(String surname, String gender, int age) {
        // Implement validation logic
        return age > 0 && (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f")) && !surname.isEmpty();
    }

}

