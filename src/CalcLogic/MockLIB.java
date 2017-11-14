package CalcLogic;

/**
 * Created by Ren on 14.11.2017.
 */
public class MockLIB implements LibI
{

    @Override
    public int Calc(int a, int b, String op) {
            int res = 0;
            switch (op)
            {
                case "+":
                    res = a + b;
                    break;
                case "-":
                    res = a - b;
                    break;
                case "*":
                    res = a * b;
                    break;
                case "/":
                    res = a / b;
                    break;
            }
            return res;
    }
}
