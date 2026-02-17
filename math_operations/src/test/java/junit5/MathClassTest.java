package junit5;

import org.junit.jupiter.api.*;

public class MathClassTest {

    static MathClass math;
    @BeforeAll
    static void create_MathClass_Object(){
        math = new MathClass();
    }
    
    @Test
    void sum_test() {
        Assertions.assertEquals(5, math.sum(2, 3));
    }

    @Test
    void sub_test() {
        Assertions.assertEquals(3, math.sub(5, 2));
        Assertions.assertEquals(3, math.sub(2, 5));
    }

    @Test
    void mul_test() {
        Assertions.assertEquals(20, math.mul(4, 5));
    }

    @Test
    void div_test() {
        Assertions.assertEquals(5, math.div(10, 2));
        Assertions.assertEquals(0, math.div(10, 0));
    }
}
