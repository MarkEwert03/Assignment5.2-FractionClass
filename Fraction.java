//Mark Ewert
//Jan 29, 2021

class Fraction{
    //instance variables / fields
    private int num, den; //public for testing, eventually will be private 

    //--------------------------------------------------constructors--------------------------------------------------
    public Fraction(){
        this.num = 1;
        this.den = 1;
    }

    public Fraction(int num, int den){
        //numerator
        this.num = num;

        //denominator
        if (den == 0) {
            System.out.println("Error: demoninator was zero");
            this.den = 1;
        } else {
            this.den = den;
        }
    }

    //new double-type constructor I made
    public Fraction(double num, double den){
        if (den == 0) {
            System.out.println("Error: demoninator was zero");
            this.num = 1;
            this.den = 1;
        } else {
            //turns doubles into Strings
            String n = String.valueOf(num);
            String d = String.valueOf(den);

            //finds decimal points in each numberical String
            int decN = n.indexOf(".");
            int decD = d.indexOf(".");

            //finds number of digits after decimal point
            int digitsN = n.substring(decN).length()-1;
            int digitsD = d.substring(decD).length()-1;

            //finds numerical string with more digits after decimal point
            int digitsMax = Math.max(digitsN, digitsD);

            //shifts each number so that the decimal point will be at the end for both
            this.num = (int)(num * Math.pow(10, digitsMax));
            this.den = (int)(den * Math.pow(10, digitsMax));
        }
    }

    public Fraction(String str){
        int slash = str.indexOf("/");

        //numerator
        String numString = str.substring(0, slash);
        this.num = Integer.parseInt(numString);

        //denominator
        String denString = str.substring(slash + 1);
        if (denString.equals("0")){
            System.out.println("Error: demoninator was zero");
            this.den = 1;
        } else {
            this.den = Integer.parseInt(denString);
        }
    }

    public Fraction(Fraction frac){
        this.num = frac.num;
        this.den = frac.den;
    }

    //--------------------------------------------------accessor methods--------------------------------------------------
    public int getNum(){
        return this.num;
    }

    public int getDenom(){
        return this.den;
    }

    //Overrides old toString function that points to ram address
    public String toString(){
        String str = "";

        //negative numerator
        if (this.num < 0) str += "(" + this.num + ")";
        else str += this.num;

        str += "/";

        //negative denominator
        if (this.den < 0) str += "(" + this.den + ")";
        else str += this.den;

        return str;
    }

    public double toDouble(){
        return (double)this.num/this.den;
    }

    //--------------------------------------------------mutator methods--------------------------------------------------
    public void setNum(int num){
        this.num = num;
    }

    public void setDenom(int den){
        if (den == 0) System.out.println("Error: denominator was 0");
        else this.den = den;
    }

    private int GCF(int n, int d){
        n = Math.abs(n);
        d = Math.abs(d);

        while (n != d){
            if (n > d) n -= d;
            else if (d > n) d -= n;
        }
        return n;
    }

    public void reduce(){
        if (this.num != 0) {
            int gcf = GCF(this.num, this.den);
            this.num /= gcf;
            this.den /= gcf;
        }

        //if num and den are negative then fraction will be postive
        if (this.num < 0 && this.den < 0){
            this.num = Math.abs(this.num);
            this.den = Math.abs(this.den);
        }
    }

    //what-if case
    public void multiply(Fraction b){
        this.num *= b.num;
        this.den *= b.den;
        this.reduce();
        //can omit "this" and code will still run
    }

    //--------------------------------------------------static methods--------------------------------------------------
    public static Fraction multiply(Fraction a, Fraction b){
        int newNum = a.num * b.num;
        int newDen = a.den * b.den;
        Fraction f = new Fraction(newNum, newDen);
        f.reduce();
        return f;
    }

    public static Fraction divide(Fraction a, Fraction b){
        if (b.num == 0) {
            System.out.println("Error: second fraction was 0");
            return a;
        }

        int newNum = a.num * b.den;
        int newDen = a.den * b.num;
        Fraction f = new Fraction(newNum, newDen);
        f.reduce();
        return f;
    }

    public static Fraction add(Fraction a, Fraction b){
        int newNum = (a.num * b.den) + (b.num * a.den);
        int newDen = a.den * b.den;
        Fraction f = new Fraction(newNum, newDen);
        f.reduce();
        return f;
    }

    public static Fraction subtract(Fraction a, Fraction b){
        int newNum = (a.num * b.den) - (b.num * a.den);
        int newDen = a.den * b.den;
        Fraction f = new Fraction(newNum, newDen);
        f.reduce();
        return f;
    }
}