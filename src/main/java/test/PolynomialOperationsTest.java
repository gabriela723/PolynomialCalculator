package test;

import operations.Function;
import polynomial.Polynom;

import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PolynomialOperationsTest {
    private static Polynom polynomial1;
    private static Polynom polynomial2;
    private static Polynom resultCorrect;
    @BeforeEach
    public void setUp(){
        polynomial1=new Polynom("x^3-2x^2+6x-5");
        polynomial2=new Polynom("x^2-1");
    }

    @Test
    void addTest(){
        Polynom result= Function.add(polynomial1,polynomial2);
        resultCorrect=new Polynom("x^3-x^2+6x-6");
        Assertions.assertEquals(result.convertPolynom(result),resultCorrect.convertPolynom(resultCorrect) );
        resultCorrect = new Polynom("x^3-x^2+6x+6");
        Assertions.assertNotEquals(result.convertPolynom(result),resultCorrect.convertPolynom(resultCorrect));
    }
    @Test
    void substractTest(){
        Polynom result=Function.subtract(polynomial1,polynomial2);
        resultCorrect=new Polynom("x^3-3x^2+6x-4");
        Assertions.assertEquals(result.convertPolynom(result),resultCorrect.convertPolynom(resultCorrect) );
        resultCorrect = new Polynom("x^3+3x^2+6x-4");
        Assertions.assertNotEquals(resultCorrect.convertPolynom(resultCorrect), result.convertPolynom(result));
    }

    @Test
    void multiplicationTest(){
        Polynom result=Function.multiplication(polynomial1,polynomial2);
        resultCorrect=new Polynom("x^5-2x^4+5x^3-3x^2-6x+5");
        Assertions.assertEquals(result.convertPolynom(result),resultCorrect.convertPolynom(resultCorrect) );
        resultCorrect=new Polynom("x^5-2x^4+5x^3-5x^2-6x+5");
        Assertions.assertNotEquals(resultCorrect.convertPolynom(resultCorrect), result.convertPolynom(result));
    }

    @Test
    void derivationTest(){
        Polynom result=Function.derivation(polynomial1);
        resultCorrect=new Polynom("3x^2-4x+6");
        Assertions.assertEquals(result.convertPolynom(result),resultCorrect.convertPolynom(resultCorrect) );
        resultCorrect=new Polynom("3x^2+4x+6");
        Assertions.assertNotEquals(resultCorrect.convertPolynom(resultCorrect), result.convertPolynom(result));
    }

}
