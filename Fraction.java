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
        if (this.den < 0) return this.num + "/(" + this.den + ")";
        else return this.num + "/" + this.den;
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
        while (n != d){
            if (n > d) n -= d;
            else if (d > n) d -= n;
        }
        return n;
    }

    public void reduce(){
        int gcf = GCF(this.num, this.den);
        this.num /= gcf;
        this.den /= gcf;
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
        int newDen = b.den * a.num;
        Fraction f = new Fraction(newNum, newDen);
        f.reduce();
        return f;
    }

    public static Fraction add(Fraction a, Fraction b){
        a.num *= b.den;
        b.num *= a.den;

        int newNum = a.num + b.num;
        int newDen = a.den * b.den;
        Fraction f = new Fraction(newNum, newDen);
        f.reduce();
        return f;
    }

    public static Fraction subtract(Fraction a, Fraction b){
        a.num *= b.den;
        b.num *= a.den;

        int newNum = a.num - b.num;
        int newDen = a.den * b.den;
        Fraction f = new Fraction(newNum, newDen);
        f.reduce();
        return f;
    }
}