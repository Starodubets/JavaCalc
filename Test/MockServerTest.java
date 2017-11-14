import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import CalcLogic.LibI;
import CalcLogic.MockLIB;
import CalcLogic.ServerMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import CalcLogic.CalcAPI;

@RunWith(Parameterized.class)
public class MockServerTest
{
    private int numberA;
    private int numberB;
    private int expected;
    private String op;


    public MockServerTest(int numberA, int numberB, String op, int expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expected = expected;
        this.op = op;
    }

    // name attribute is optional, provide an unique name for test
    // multiple parameters, uses Collection<Object[]>
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 3, "+", 10},
                {4, 5, "-", 10},
                {6, 7, "*", 10},
                {8, 4, "/", 10}
        });
    }

    @Test
    public void testCalc()
    {
        LibI calc = new ServerMock();
        assertEquals(expected, calc.Calc(numberA, numberB, op));
    }
}
