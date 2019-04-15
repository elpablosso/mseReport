package practice;

public class FizzBuzz {

// SOLUTION FOR https://code-exercises.com/programming/medium/6/fizz-buzz

    public String fizzBuzz(Integer i){
        if(i%3!=0 && i%5!=0) return i.toString();
        if(i%3==0 && i%5==0) return "FizzBuzz";
        if(i%3==0) return "Fizz";
        else return "Buzz";
    }


}
