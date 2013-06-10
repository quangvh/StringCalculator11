import java.util.regex.Pattern;

/**
 * User: quangvh
 * Date: 6/10/13
 */
public class Calculator {
    public static int add(String text) throws Exception {
        if (text.isEmpty())
            return 0;
        String strDelimiter = getStrDelimiter(text);
        String[] listNumber = getStrNumber(text).split(strDelimiter);
        return getSumOfListNumber(listNumber);
    }

    public static String getStrDelimiter(String text) {
        String strDelimiter = ",|\n";
        if (text.startsWith("//[")) {
            strDelimiter = "\n";
            String[] listDelimiter = text.split("\\[");
            for (int i = 0; i < listDelimiter.length; i++) {
                if (i >= 1) {
                    strDelimiter += "|" + Pattern.quote(listDelimiter[i].split("]")[0]);
                }
            }
        } else if (text.startsWith("//")) {
            strDelimiter = text.substring(2, 3) + "|\n";
        }
        return strDelimiter;
    }

    public static String getStrNumber(String text) {
        String strNumber = text;
        if (text.startsWith("//")) {
            strNumber = text.split("\n")[1];
        }
        return strNumber;
    }

    public static int getSumOfListNumber(String[] listNumber) throws Exception {
        int sum = 0;
        String strNegative = "";
        for (String number : listNumber) {
            if (Integer.parseInt(number) <= 1000) {
                if (Integer.parseInt(number) < 0)
                    strNegative += " " + number;
                sum += Integer.parseInt(number);
            }
        }
        if (!strNegative.equals(""))
            throw new Exception("negatives not allowed" + strNegative);
        return sum;
    }

}
