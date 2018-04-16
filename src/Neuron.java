import java.util.Random;

public class Neuron extends AbstractNeuron{
    private static final Random R = new Random();
    private double[] weights;
    private String name;

    public Neuron(String name) {
        this.name = name;
        weights = new double[3];
        generateWeights();
    }

    private void generateWeights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = R.nextDouble() * 2 - 1;
        }
    }

    @Override
    public void train(double[] x, double expectedAnswer, double learnRate) {
        if (getName().equals("First") && expectedAnswer == 0) {
            expectedAnswer = -1;
        } else if (getName().equals("Second") && expectedAnswer == 0) {
            expectedAnswer = 1;
        }
        double adjustedError = (expectedAnswer - result(x)) * learnRate;
        for (int i = 0; i < weights.length - 1; i++) {
            weights[i] += adjustedError * x[i];
        }
        weights[weights.length - 1] += adjustedError;
    }

    @Override
    public double result(double[] x) {
        double sum = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            sum += x[i] * weights[i];
        }
        sum += weights[weights.length - 1];
        return (sum > 0) ? 1 : -1;
    }

    @Override
    public String getName() {
        return name;
    }

}
