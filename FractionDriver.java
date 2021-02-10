//Mark Ewert
//Jan 29, 2021

class FractionDriver{
    public static void main(String[] args){
        /*Fraction a = new Fraction("1/4");
        Fraction b = new Fraction(3, 8);
        Fraction add = Fraction.add(a, b);
        Fraction sub = Fraction.subtract(a, b);
        Fraction mul = Fraction.multiply(a, b);
        Fraction div = Fraction.divide(a, b);
        System.out.println(a + " & " + b + " =");
        System.out.println(add + " " + sub + " " + mul + " " + div);*/
        
        Fraction f = Fraction.approximate(Math.pow(2, 0.5), 1000);
        System.out.println(f);
    }
}
