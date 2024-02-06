import com.myaqa.FactorialCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @ParameterizedTest(name = "Factorial of {0} should be {1}")
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120"
    })
    void testFactorial(int input, int expected) {
        assertEquals(expected, FactorialCalculator.calculateFactorial(input));
    }

    @Test
    @DisplayName("Test factorial calculation with negative number")
    void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorial(-1));
    }
}
