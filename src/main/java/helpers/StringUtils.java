package helpers;

public class StringUtils {
    public static String getPascalCaseString(String text) {
        String returnText ="";
        try {
            String[] splitText = text.split("\\s");

            for (String partialText : splitText) {
                if (!partialText.isEmpty()) {
                    partialText = Character.toUpperCase(partialText.toCharArray()[0]) + partialText.substring(1).toLowerCase();
                    returnText = returnText + partialText;
                }
            }
        }
        catch (Exception e)
        {
            throw e;
        }

        return returnText;
    }
}
