import java.util.regex.Pattern;

/**
 * User: quangvh
 * Date: 6/7/13
 */
public class Calculator {
    public static int add(String numbers) throws Exception {
        String strNegative = "";
        String strDelimiter = "";
        String strNumber = "";
        String[] listNumber = null;
        Integer sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        } else {
            if (numbers.startsWith("//")) {
                strDelimiter = numbers.substring(2,3) + "|\n";
                strNumber = numbers.substring(2);
            } else if (numbers.contains(",")){
                strDelimiter = ",|\n";
                strNumber = numbers;
            } else {
                return Integer.parseInt(numbers);
            }
            listNumber = strNumber.split(strDelimiter);
            for (String number : listNumber) {
                if (!number.equals("") && Integer.parseInt(number) <= 1000) {
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
}
