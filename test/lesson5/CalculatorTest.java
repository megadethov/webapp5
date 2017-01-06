package lesson5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.javawebinar.webapp.WebAppException;

import static org.junit.Assert.*;

public class CalculatorTest {

    static Calculator calc;

    static {
        calc = new Calculator();
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = WebAppException.class)
    public void abs() throws Exception {
        Assert.assertEquals(5, calc.abs(-5));
        throw new WebAppException("");
    }

}