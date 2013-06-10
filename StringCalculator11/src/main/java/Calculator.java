import java.util.regex.Pattern;

/**
 * User: quangvh
 * Date: 6/10/13
 */
public class Calculator {
    public static int add(String text) throws Exception {
        int sum = 0;
        String strDelimiter = "";
        String strNumber = "";
        String strNegative = "";
        if (text.isEmpty()) {
            return 0;
        } else {
            if (text.startsWith("//[")) {
                strDelimiter = "\n";
                String[] listDelimiter = text.split("\\[");
                for (int i=0; i < listDelimiter.length; i++) {
                   if (i >= 1) {
                       strDelimiter += "|" + Pattern.quote(listDelimiter[i].split("]")[0]);
                   }
                }
                strNumber = text.split("\n")[1];
            } else if (text.startsWith("//")) {
                strDelimiter = text.substring(2, 3) + "|\n";
                strNumber = text.substring(2);
            } else if (text.contains(",")){
                strDelimiter = ",|\n";
                strNumber = text;
            } else {
                return Integer.parseInt(text);
            }
            String[] listNumber = strNumber.split(strDelimiter);
            for (String number : listNumber) {
                if (!number.equals("") && Integer.parseInt(number) <= 1000){
                    if (Integer.parseInt(number) < 0)
                        strNegative += " " + number;
                    sum += Integer.parseInt(number);
                }
            }
        }
        if (!strNegative.equals(""))
            throw new Exception("negatives not allowed" + strNegative);
        return sum;
    }
}
