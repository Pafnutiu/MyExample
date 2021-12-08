package WorkDZ_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalcAreaTests {
    @Test
    void successSquareCalculation() throws Exception {
        Assertions.assertEquals(DZ_4.calcArea(3,4,5),6);
        Assertions.assertTrue(Math.abs(DZ_4.calcArea(3,4,5)-6)<0.0001);
    }

    @ParameterizedTest
    @CsvSource("3,4,5")
    void successSquare(double a,double b,double c) throws Exception {
        Assertions.assertEquals(DZ_4.calcArea(a,b,c),6);
    }

    @Test
    void negativeTest(){
        Assertions.assertThrows(Exception.class, () -> DZ_4.calcArea(-3,2,1));
    }
}
