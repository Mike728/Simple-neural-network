public class DoubleLine extends AbstractResult {
    private double a, b;
    private String name;

    public DoubleLine(double a, double b, String name) {
        this.a = a;
        this.b = b;
        this.name = name;
    }

    @Override
    public double result(double[] x) {
        double Line1 = a * x[0] + b;
        double Line2 = a * x[0] - b;
        if (x[1] > Line1) { //NAD PIERWSZA || POD DRUGA
            return 1;
        } else if (x[1] < Line2) {
            return -1;
        } else
            return 0;
    }

    @Override
    public String getName() {
        return name;
    }


}
