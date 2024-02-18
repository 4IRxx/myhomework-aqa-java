package android_tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest extends BaseTest {
    @DataProvider(name = "additionNumbers")
    public Object[][] getAdditionData() {
        return new Object[][] {
                {0, 4, 4},
                {1, 7, 8},
                {3, 6, 9},
                {8, 9, 17}
        };
    }

    @Test(dataProvider = "additionNumbers")
    public void testAddition(int numberOne, int numberTwo, int expectedResult) {
        int additionResult = calculator.addition(numberOne, numberTwo);
        assertEquals(additionResult, expectedResult, "Addition operation is not correct");
    }

    @DataProvider(name = "deductionNumbers")
    public Object[][] getDeducationData() {
        return new Object[][] {
                {6, 3, 3},
                {8, 1, 7},
                {9, 5, 4},
                {2, 0, 2}
        };
    }

    @Test(dataProvider = "deductionNumbers")
    public void testDeduction(int numberOne, int numberTwo, int expectedResult) {
        int deductionResult = calculator.deduction(numberOne, numberTwo);
        assertEquals(deductionResult, expectedResult, "Deduction operation is not correct");
    }

    @DataProvider(name = "multiplicationNumbers")
    public Object[][] getMultiplicationData() {
        return new Object[][] {
                {2, 7, 14},
                {8, 1, 8},
                {9, 5, 45},
                {6, 0, 0}
        };
    }

    @Test(dataProvider = "multiplicationNumbers")
    public void testMultiplication(int numberOne, int numberTwo, int expectedResult) {
        int multiplicationResult = calculator.multiplication(numberOne, numberTwo);
        assertEquals(multiplicationResult, expectedResult, "Multiplication operation is not correct");
    }

    @DataProvider(name = "divisionNumbers")
    public Object[][] getDivisionData() {
        return new Object[][] {
                {6, 2, 3},
                {8, 1, 8},
                {9, 3, 3},
                {4, 4, 1}
        };
    }

    @Test(dataProvider = "divisionNumbers")
    public void testDivision(int numberOne, int numberTwo, int expectedResult) {
        int divisionResult = calculator.division(numberOne, numberTwo);
        assertEquals(divisionResult, expectedResult, "Division operation is not correct");
    }
    @Test
    public void testDivisionByZero() {
        String errorMessage = calculator.divisionByZero(3);
        calculator.clickClearButton();
        assertEquals(errorMessage, "Can't divide by 0", "Division operation is not correct");
    }
}