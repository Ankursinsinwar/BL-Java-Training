package junit5;

public class MathClass {

    int sum(int a, int b){
        return a+b;
    }
    int sub(int a, int b){
        return a>=b?a-b:b-a;
    }
    int mul(int a, int b){
        return a*b;
    }
    int div(int a, int b){
        try {
            return a/b;
        } catch (ArithmeticException  e) {
            System.err.println("can't devide by zero! ");
            return 0;
        }
    }
}
