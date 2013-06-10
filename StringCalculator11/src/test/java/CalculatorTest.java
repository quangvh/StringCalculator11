import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: quangvh
 * Date: 6/10/13
 */
public class CalculatorTest {
    @Test
    public void testStringEmpty() {
        assertEquals(Calculator.add(""), 0);
    }
    @Test
    public void testOneNumber() {
        assertEquals(Calculator.add("1"), 1);
    }
    @Test
    public void testTwoNumber() {
        assertEquals(Calculator.add("1,2"), 3);
    }
    @Test
    public void testUnknownNumber() {
        assertEquals(Calculator.add("1,2,3,4,5"), 15);
    }

}
