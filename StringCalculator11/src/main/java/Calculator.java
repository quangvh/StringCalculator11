/**
 * User: quangvh
 * Date: 6/10/13
 */
public class Calculator {
    public static int add(String text) {
        if (text.isEmpty()) {
            return 0;
        } else {
            if (text.contains(",")){
                String[] listNumber = text.split(",");
                int sum = 0;
                for (String number : listNumber) {
                    sum += Integer.parseInt(number);
                }
                return sum;
            } else {
                return Integer.parseInt(text);
            }
        }
    }
}
