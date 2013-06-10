import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * User: quangvh
 * Date: 6/10/13
 */
public class CalculatorTest {
    @Test
    public void testStringEmpty() throws Exception {
        assertEquals(Calculator.add(""), 0);
    }
    @Test
    public void testOneNumber() throws Exception {
        assertEquals(Calculator.add("1"), 1);
    }
    @Test
    public void testTwoNumber() throws Exception {
        assertEquals(Calculator.add("1,2"), 3);
    }
    @Test
    public void testUnknownNumber() throws Exception {
        assertEquals(Calculator.add("1,2,3,4,5"), 15);
    }
    @Test
    public void testHaveNewLine() throws Exception {
        assertEquals(Calculator.add("1\n2,3"), 6);
    }
    @Test
    public void testDifferentDelimiter() throws Exception {
        assertEquals(Calculator.add("//;\n1;2"), 3);
    }
    @Test
    public void testNegativeNumber() {
        try {
            Calculator.add("-1,-2");
            fail("Exception");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "negatives not allowed -1 -2");
        }
    }

}
