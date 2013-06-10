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
                String firstDelimiter = text.split("\\[")[1];
                String secondDelimiter = Pattern.quote(firstDelimiter.split("]")[0]);
                strDelimiter = "\n|" + secondDelimiter;
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
