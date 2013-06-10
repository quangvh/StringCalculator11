/**
 * User: quangvh
 * Date: 6/10/13
 */
public class Calculator {
    public static int add(String text) throws Exception {
        int sum = 0;
        String strDelimiter = "";
        String strNumber = "";
        if (text.isEmpty()) {
            return 0;
        } else {
            if (text.startsWith("//")) {
                strDelimiter = text.substring(2, 3) + "|\n";
                strNumber = text.substring(2);
            } else if (text.contains(",")){
                strDelimiter = ",|\n";
                strNumber = text;
            } else {
                return Integer.parseInt(text);
            }
            String[] listNumber = strNumber.split(strDelimiter);
            String strNegative = "";
            for (String number : listNumber) {
                if (!number.equals(""))
                    sum += Integer.parseInt(number);
                if (Integer.parseInt(number) < 0)
                    strNegative += " " + number;
            }
            if (!strNegative.equals(""))
                throw new Exception("negatives not allowed" + strNegative);
        }
        return sum;
    }
}
