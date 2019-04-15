package practice;

public class Fibonacci {

    public Integer fibonacci(Integer n){
        return n<2? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

}
