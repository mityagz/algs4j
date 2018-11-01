package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/12/15.
 */
public class Rational {
    private int numerator;
    private int denominator;
    Rational(int n, int d){
        int gcd = Euclid.gcd(n, d);
        numerator = n/gcd;
        denominator = d/gcd;
    }

    public Rational plus(Rational b){
        return  new Rational(this.numerator * b.denominator + this.denominator * b.numerator, this.denominator*b.denominator);
    }

    public Rational minus(Rational b){
        return  new Rational(this.numerator * b.denominator - this.denominator * b.numerator, this.denominator*b.denominator);
    }

    public Rational times(Rational b){
        return new Rational(this.numerator * b.numerator, this.denominator * b.denominator);
    }

    public Rational divides(Rational b){
        return new Rational(this.numerator * b.denominator, this.denominator * b.numerator);
    }

    public boolean equals(Rational b){

        return false;
    }

    public String toString(){
        return (numerator + "/" + denominator);
    }

    public static void main(String [] args){
        Rational r = new Rational(3, 5);
        StdOut.println(r);
        StdOut.println(r.times(new Rational(2, 3)));
        StdOut.println(r.plus(new Rational(2, 3)));
        StdOut.println(r.minus(new Rational(2, 3)));
        StdOut.println(r.divides(new Rational(2, 3)));
    }
}
