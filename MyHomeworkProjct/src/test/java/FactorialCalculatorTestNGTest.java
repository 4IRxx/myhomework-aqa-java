import com.myaqa.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialCalculatorTestNGTest {
    @DataProvider(name = "factorialTestData")
    public Object[][] getData() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {5, 120}
        };
    }

    @Test(dataProvider = "factorialTestData", description = "Test factorial calculation with positive numbers")
    public void testFactorialOfPositiveNumber(int input, int expected) {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(input), expected, "Factorial calculation is incorrect");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Test factorial calculation with negative number")
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.calculateFactorial(-1);
    }
}