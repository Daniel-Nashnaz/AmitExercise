
public final class Triangle {

    //variables
    private double sideA;
    private double sideB;
    private double sideC;
    private double angleA;
    private double angleB;
    private double angleC;

    //initialization
    /**
     * constructor one
     *
     * @param sideA
     * @param sideB
     * @param sideC
     */
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

    }

    /**
     * constructor two
     *
     * @param sideA
     * @param angleA
     * @param sideC
     */
    public Triangle(double sideA, float angleA, double sideC) {
        this.sideA = sideA;
        this.angleA = angleA;
        this.sideC = sideC;
        FindSide1();
    }

    /**
     * constructor three
     *
     * @param sideA
     * @param angleA
     * @param angleB
     */
    public Triangle(double sideA, float angleA, float angleB) throws Exception {
        this.sideA = sideA;
        this.angleA = angleA;
        this.angleB = angleB;
        FindSide2();

    }

    //constructor four (get&&set)
    public Triangle() {

    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getAngleA() {
        return angleA;
    }

    public void setAngleA(double angleA) {
        this.angleA = angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public void setAngleB(double angleB) {
        this.angleB = angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    public void setAngleC(double angleC) {
        this.angleC = angleC;
    }

    //The sum of the scope
    public double SumScope() {
        return this.sideA + this.sideB + this.sideC;
    }

    //Heron's Formula to find area and exception
    public double SumArea() throws Exception {

        if (this.sideA + this.sideB <= this.sideC
                || this.sideA + this.sideC <= this.sideB
                || this.sideB + this.sideC <= this.sideA) {
            //If the sides is invalid
            throw new Exception("error: The sum of the sides is incorrect");
        }
        double sum = SumScope() / 2;
        return Math.sqrt(sum * (sum - this.sideA) * (sum - this.sideB) * (sum - this.sideC));

    }

    //find height of triangle betweem B and AC
    public double height() throws Exception {
        return (2 * SumArea()) / this.sideC;
    }

    //Find sideB with angle and two side with formula cosine 
    public void FindSide1() {
        this.sideB = Math.sqrt((this.sideA * this.sideA + this.sideC * this.sideC)
                - (2 * this.sideA * this.sideC) * Math.cos(Math.toRadians(this.angleA)));
    }

    //Find sideC with side and three angle with Law of sines
    public void FindSide2() throws Exception {
        this.angleC = 180 - this.angleA - this.angleB;

        //If the angles is invalid
        if (this.angleC < 0) {
            throw new Exception("error: The sum of the angles is incorrect!");

        }
        this.sideC = this.sideA * Math.sin(Math.toRadians(angleB)) / Math.sin(Math.toRadians(angleA));
        FindSide1();
    }

    //Find type of triangle 
    public String FindTypeTriangle() {

        if (this.sideA == this.sideB && this.sideA == this.sideC) {
            return "Equilateral triangle";

        }
        if (sideA == sideB || sideB == sideC || sideA == sideC) {
            return "Isosceles triangle";
        }
        int a1 = (int) (this.sideA * this.sideA);
        int b1 = (int) (this.sideB * this.sideB);
        int c1 = (int) (this.sideC * this.sideC);
        if (c1 == a1 + b1 || b1 == a1 + c1 || a1 == b1 + c1) {
            return "Right-Angle Triangle";
        }
        return "orthr triangle";
    }

    @Override
    public String toString() {
        try {
            return "Triangle:\n" + "sideA=" + sideA + "\nsideB=" + sideB + "\nsideC=" + sideC
                    + "\nangleA=" + angleA + "\nangleB=" + angleB + "\nangleC=" + angleC + '}'
                    + "\nsum area is: " + SumArea()
                    + "\nsum scope is: " + SumScope()
                    + "\nsum height is: " + height()
                    + "\nThis is " + FindTypeTriangle();
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.sideA) ^ (Double.doubleToLongBits(this.sideA) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.sideB) ^ (Double.doubleToLongBits(this.sideB) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.sideC) ^ (Double.doubleToLongBits(this.sideC) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.angleA) ^ (Double.doubleToLongBits(this.angleA) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.angleB) ^ (Double.doubleToLongBits(this.angleB) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.angleC) ^ (Double.doubleToLongBits(this.angleC) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triangle other = (Triangle) obj;
        return true;
    }
    
    

}
