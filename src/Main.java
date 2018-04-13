public class Main {

    public static void main(String[] args) {
        ConsoleLogger cp = new ConsoleLogger();

        Pattern pattern = new Pattern("Pattern");
        pattern.addBarrier(new DoubleLine(0.3, 0.7, "Double Line"));

        cp.addResponder(pattern);
        cp.printResults();
    }
}
