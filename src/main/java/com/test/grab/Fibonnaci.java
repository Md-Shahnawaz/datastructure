package com.test.grab;

import java.math.BigInteger;

public class Fibonnaci {

    static BigInteger fib(int n)
    {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c;
        for (int j=2 ; j<=n ; j++)
        {
            c =  a.add(b);
            a = b;
            b = c;
        }

        return (a);
    }

    public static void main(String[] args)
    {
        int n = 5;
        BigInteger numb = fib(n);
        System.out.println("Fibonacci of " + n +
            "th term" + " " +"is" +" " + numb);

        System.out.println(numb.mod(BigInteger.valueOf(1000000l)));
    }
}
