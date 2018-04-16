public class Main {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();

        Pattern pattern = new Pattern("Pattern");
        pattern.addBarrier(new DoubleLine(0.3, 0.7, "Double Line"));

        Perceptron p1 = new Perceptron();

        p1.addNeuron(new Neuron("First"));
        p1.addNeuron(new Neuron("Second"));

        consoleLogger.addResponder(pattern);
        consoleLogger.addResponder(p1);
        consoleLogger.printResults();

        for (int i = 0; i < 2000; i++) {
            double[] d = new double[2];

            d[0] = pattern.getRandom();
            d[1] = pattern.getRandom();

            double a1 = pattern.result(d);
            p1.train(d, a1, 0.01);

            if(i%200 == 0) {
                consoleLogger.printResults();
            }
        }
        consoleLogger.printResults();

    }
}
