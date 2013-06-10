/**
 * User: quangvh
 * Date: 6/10/13
 */
public class Calculator {
    public static int add(String text) throws Exception {
        int sum = 0;
        String strDelimiter = "";
        if (text.isEmpty()) {
            return 0;
        } else {
            if (text.startsWith("//")) {
                strDelimiter = text.substring(2, 3) + "|\n";
                text = text.substring(2);
            } else if (text.contains(",")){
                strDelimiter = ",|\n";
            } else {
                return Integer.parseInt(text);
            }
            String[] listNumber = text.split(strDelimiter);
            for (String number : listNumber) {
                if (!number.equals(""))
                    sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}
