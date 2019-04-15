package practice;

public class PrimeNumber {

    /// SOLUTION FOR https://code-exercises.com/programming/medium/8/prime-number

    public Boolean isPrime(Integer n){
        for(int i=2; i<n; i++){
            if(n%i==0) return false;
        }  return true;
    }

}
