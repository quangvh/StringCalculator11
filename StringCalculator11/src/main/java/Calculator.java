/**
 * User: quangvh
 * Date: 6/10/13
 */
public class Calculator {
    public static int add(String text) throws Exception {
        int sum = 0;
        if (text.isEmpty()) {
            return 0;
        } else {
            if (text.contains(",")){
                String strDelimiter = ",|\n";
                String[] listNumber = text.split(strDelimiter);
                for (String number : listNumber) {
                    sum += Integer.parseInt(number);
                }
            } else {
                return Integer.parseInt(text);
            }
        }
        return sum;
    }
}
