/**
 * User: quangvh
 * Date: 6/10/13
 */
public class Calculator {
    public static int add(String text) {
        Integer sum = 0;
        if (text.isEmpty()) {
            return 0;
        } else {
            if (text.contains(",")){
                String[] listNumber = text.split(",");
                return Integer.parseInt(listNumber[0]) + Integer.parseInt(listNumber[1]);
            } else {
                return Integer.parseInt(text);
            }
        }
    }
}
